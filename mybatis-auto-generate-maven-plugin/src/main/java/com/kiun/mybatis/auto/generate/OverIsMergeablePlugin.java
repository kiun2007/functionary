package com.kiun.mybatis.auto.generate;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.Arrays;
import java.util.List;

public class OverIsMergeablePlugin extends PluginAdapter {

    private PluginProperties properties = new PluginProperties(this.getProperties());

    private String firstUp(String v){
        return v.substring(0, 1).toUpperCase() + v.substring(1);
    }

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return super.modelPrimaryKeyClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        boolean isUseId = "1".equals(introspectedTable.getTableConfiguration().getProperty("useId"));
        String rootClass = introspectedTable.getTableConfiguration().getProperty("rootClass");

        if(isUseId || (properties.autoAddId() && introspectedTable.getPrimaryKeyColumns().size() == 1)){
            addLimit(topLevelClass, introspectedTable, introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty());
        }

        //指定父类
        if (rootClass != null){
            //设置不继承任何类
            if ("@null".equals(rootClass)){
                topLevelClass.setSuperClass((FullyQualifiedJavaType)null);
            }else{
                topLevelClass.setSuperClass(rootClass);
            }
        }

        properties.getList("import").forEach(topLevelClass::addImportedType);

        RuntimeAttribute runtimeAttribute =
                new RuntimeAttribute()
                        .put("tableName", introspectedTable.getTableConfiguration().getTableName())
                        .put("remarks", introspectedTable.getRemarks())
                        .put("recordType", introspectedTable.getBaseRecordType())
                        .put("modelName", topLevelClass.getType().getShortName());

        properties.getList("anno").forEach(item->{
            topLevelClass.addAnnotation(runtimeAttribute.run(item, true));
        });

        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        String baseExample = properties.exampleBase();
        if (baseExample != null){
            topLevelClass.setSuperClass(baseExample);
        }
        topLevelClass.getFields().removeIf(item->item.getName().equals("orderByClause"));

        InnerClass generatedCriteria = topLevelClass.getInnerClasses()
                .stream().filter(item-> item.getType().getShortName().equals("GeneratedCriteria")).findFirst().orElse(null);

        if(generatedCriteria != null){
            Field criteriaField = generatedCriteria.getFields().stream().filter(item-> item.getName().equals("criteria")).findFirst().orElse(null);

            if (!properties.criterionClass().isEmpty()){
                topLevelClass.addImportedType(properties.criterionClass());
                topLevelClass.getInnerClasses().remove(
                        topLevelClass.getInnerClasses().stream().filter(item-> item.getType().getShortName().equals("Criterion")).findFirst().orElse(null)
                );

                if (criteriaField != null){
                    criteriaField.getType().getTypeArguments().clear();
                    criteriaField.getType().getTypeArguments().add(new FullyQualifiedJavaType(properties.criterionClass()));
                }
            }

            if (properties.criteriaRoot() != null){
                generatedCriteria.setSuperClass(properties.criteriaRoot());
                generatedCriteria.getFields().remove(criteriaField);
                generatedCriteria.getMethods().removeIf(item-> item.getName().equals("addCriterion"));
            }
        }
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    private void addLimit(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {

        CommentGenerator commentGenerator = context.getCommentGenerator();
        char c = name.charAt(0);
        if(properties.withSetter()){
            //创建Set方法.
            String camel = Character.toUpperCase(c) + name.substring(1);
            Method method = new Method();
            method.setVisibility(JavaVisibility.PUBLIC);
            method.setName("setId");
            method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "id"));
            method.addBodyLine("this." + name + "=id;");
            commentGenerator.addGeneralMethodComment(method, introspectedTable);

            //创建Get方法.
            topLevelClass.addMethod(method);
            method = new Method();
            method.setVisibility(JavaVisibility.PUBLIC);
            method.setReturnType(FullyQualifiedJavaType.getStringInstance());
            method.setName("getId");
            method.addBodyLine("return " + name + ";");
            commentGenerator.addGeneralMethodComment(method, introspectedTable);
            topLevelClass.addMethod(method);
        }
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        boolean result = super.clientGenerated(interfaze, topLevelClass, introspectedTable);
        String objClz = introspectedTable.getTableConfiguration().getDomainObjectName();
        for (IntrospectedColumn column : introspectedTable.getAllColumns()){
            String columnName = column.getJavaProperty();
            FullyQualifiedJavaType type = column.getFullyQualifiedJavaType();

            Method method = new Method(String.format("selectBy%s", firstUp(columnName)));
            method.setReturnType(new FullyQualifiedJavaType(String.format("List<%s>", objClz)));
            method.addParameter(0, new Parameter(type, columnName));
            interfaze.addMethod(method);
        }

        properties.getList("clientImport").forEach(item-> interfaze.addImportedType(new FullyQualifiedJavaType(item)));
        RuntimeAttribute runtimeAttribute =
                new RuntimeAttribute()
                        .put("tableName", introspectedTable.getTableConfiguration().getTableName())
                        .put("remarks", introspectedTable.getRemarks())
                        .put("recordType", introspectedTable.getBaseRecordType())
                        .put("exampleType", introspectedTable.getExampleType());
        properties.getEntryAndAttribute(PluginProperties.ClientRoot).forEach(item->{
            List<String> paramClz = properties.getList("clientRootParam-" + item.getSort());

            FullyQualifiedJavaType type = new FullyQualifiedJavaType(item.getValue());
            interfaze.addImportedType(type);
            paramClz.forEach(iType->{
                FullyQualifiedJavaType fullType = new FullyQualifiedJavaType(runtimeAttribute.run(iType, false));
                interfaze.addImportedType(fullType);
                type.addTypeArgument(fullType);
            });

            interfaze.getMethods().removeIf(method-> Arrays.asList(
                    "countByExample", "deleteByExample", "insert",
                    "insertSelective", "selectByExample", "updateByExampleSelective",
                    "updateByExample", "updateByPrimaryKeySelective", "updateByPrimaryKey"
            ).contains(method.getName()));
            interfaze.addSuperInterface(type);
        });
        return result;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        sqlMap.setMergeable(false);
        return true;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {

        for (IntrospectedColumn column : introspectedTable.getAllColumns()){

            String columnName = column.getJavaProperty();
            FullyQualifiedJavaType type = column.getFullyQualifiedJavaType();
            String methodName = String.format("selectBy%s", firstUp(columnName));

            XmlElement element = new XmlElement("select");

            element.addAttribute(new Attribute("id", methodName));
            element.addAttribute(new Attribute("parameterType", type.getFullyQualifiedName()));
            element.addAttribute(new Attribute("resultMap", "BaseResultMap"));

            element.addElement(new TextElement("select"));
            element.addElement(new XmlElement("include"){{
                addAttribute(new Attribute("refid", "Base_Column_List"));
            }});

            element.addElement(new TextElement(String.format("from %s where %s = #{%s,jdbcType=%s}\n",
                    introspectedTable.getTableConfiguration().getTableName(), column.getActualColumnName(), columnName, column.getJdbcTypeName()
            )));

            document.getRootElement().addElement(new TextElement(""));
            document.getRootElement().addElement(element);
        }
        document.getRootElement().getElements().forEach(item->{
            if(item instanceof XmlElement){
                boolean isRemove = ((XmlElement) item).getAttributes().removeIf(attribute-> "id".equals(attribute.getName()) && "insert".equals(attribute.getValue()));
                if(isRemove){
                    ((XmlElement) item).getAttributes().add(new Attribute("id", "insertOne"));
                }
            }
        });
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }
}
