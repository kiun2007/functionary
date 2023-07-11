package com.kiun.mybatis.auto.generate;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Mojo(name = "create")
public class MybatisMojo extends AbstractMojo {

    @Parameter(name = "path")
    private String path;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("================= start create xml =================");
        getLog().info(path);
        if (path == null){
            getLog().error("请配置 path");
            return;
        }

        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);

        long start = System.currentTimeMillis();
        try {
            File file = new File(path);
            Configuration config = cp.parseConfiguration(file);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            getLog().info("=======create complete use time " + (System.currentTimeMillis() - start) + " ms=======");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
