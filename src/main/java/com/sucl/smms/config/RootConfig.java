package com.sucl.smms.config;

import com.github.pagehelper.PageInterceptor;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * 排除的时候还需要排除其他@ComponentScan的类
 * 比如类A和类B都配置了@ComponentScan，那么回去合集
 * @author sucl
 * @since 2019/3/21
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.sucl.smms.*.mapper")
@PropertySource(value = "classpath:config/config-jdbc.properties")
@ComponentScan(value = "com.sucl.smms",useDefaultFilters = true,
                excludeFilters = {
                    @ComponentScan.Filter({Controller.class,ControllerAdvice.class})
//                    ,@ComponentScan.Filter(type = FilterType.CUSTOM,classes = ConsumTypeFilter.class)
                    ,@ComponentScan.Filter(type = FilterType.REGEX,pattern = ".*\\.config\\.ServletConfig")
                }
            )
public class RootConfig {
    @Autowired
    private Environment env;

    @Bean(value = "dataSource",destroyMethod = "close")
    public ComboPooledDataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(env.getProperty("jdbc.driverClass"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        dataSource.setUser(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
//        sqlSessionFactoryBean.setMapperLocations(null);
//        sqlSessionFactoryBean.setConfigLocation();
        sqlSessionFactoryBean.setTypeAliasesPackage("com.sucl.smms.*.model");

        Interceptor[] plugins = new Interceptor[]{pageInterceptor()};
        sqlSessionFactoryBean.setPlugins(plugins);
        return sqlSessionFactoryBean.getObject();
    }

    private Interceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();;
//        RelaxedPropertyResolver resolver = new RelaxedPropertyResolver(env, "pagehelper.");
//        Map<String, Object> subProperties = resolver.getSubProperties("");
//        for (String key : subProperties.keySet()) {
//            properties.setProperty(key, resolver.getProperty(key));
//        }
        properties.setProperty("helperDialect","mysql");
        properties.setProperty("reasonable","true");
        properties.setProperty("supportMethodsArguments","true");
        properties.setProperty("params","count=countSql");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    @Bean("transactionManager")
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
