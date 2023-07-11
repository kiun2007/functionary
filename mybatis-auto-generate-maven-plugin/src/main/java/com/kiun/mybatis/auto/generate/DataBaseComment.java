package com.kiun.mybatis.auto.generate;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class DataBaseComment extends DefaultCommentGenerator {

    private PluginProperties pluginProperties;

    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        String remarks = introspectedTable.getRemarks();
        addCommentStart(topLevelClass, remarks);

        topLevelClass.addJavaDocLine(" * ");
        StringBuilder sb = new StringBuilder();
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        topLevelClass.addJavaDocLine(sb.toString());
        topLevelClass.addJavaDocLine(" *");
        addJavadocTag(topLevelClass, false);
        topLevelClass.addJavaDocLine(" */");
    }

    private void addCommentStart(JavaElement element, String remarks){

        element.addJavaDocLine("/**");
        if (StringUtility.stringHasValue(remarks)) {
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));
            for (String remarkLine : remarkLines) {
                element.addJavaDocLine(" * " + remarkLine);
            }
        }
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        pluginProperties = new PluginProperties(properties);
        super.addConfigurationProperties(properties);
    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

        String remarks = introspectedColumn.getRemarks();
        addCommentStart(field, remarks);
        field.addJavaDocLine(" */");

        String tableName = introspectedTable.getTableConfiguration().getTableName();
        String tableRemarks = introspectedTable.getRemarks();

        pluginProperties.getList("anno").forEach(item->{

            String annoStr = item.replaceAll("\\$\\{tableName}", String.format("\"%s\"", tableName));
            annoStr = annoStr.replaceAll("\\$\\{remarks}", String.format("\"%s\"", remarks));
            annoStr = annoStr.replaceAll("\\$\\{tableRemarks}", String.format("\"%s\"", tableRemarks));
            field.addAnnotation(annoStr);
        });
    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        field.addJavaDocLine("/**");
        addJavadocTag(field, false);
        field.addJavaDocLine(" */");
    }

    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
    }

    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
    }

    protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
        StringBuilder sb = new StringBuilder();
        sb.append(" *");
        if (markAsDoNotDelete) {
            sb.append(" do_not_delete_during_merge"); //$NON-NLS-1$
        }
        String s = getDateString();
        if (s != null) {
            sb.append(' ');
            sb.append(s);
        }
        javaElement.addJavaDocLine(sb.toString());
    }

    protected String getDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
