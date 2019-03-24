package com.sucl.smms.code;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        File file = new File("src\\main\\resources\\generatorConfig.xml");
        List<String> warns = new ArrayList<String>();
        ConfigurationParser configurationParser = new ConfigurationParser(warns);
        Configuration configuration = configurationParser.parseConfiguration(file);
        ShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration,callback,warns);
        myBatisGenerator.generate(null);
    }
}
