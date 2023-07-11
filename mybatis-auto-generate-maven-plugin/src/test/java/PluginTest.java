import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PluginTest {

    public static void main(String[] args) {

        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);

        long start = System.currentTimeMillis();
        try {
            File file = new File("E:\\Work\\Project\\GK\\functionary\\app\\generate\\mybatis-test.xml");
            Configuration config = cp.parseConfiguration(file);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
