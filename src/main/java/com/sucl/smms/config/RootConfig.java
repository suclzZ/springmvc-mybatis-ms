package com.sucl.smms.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
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

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Driver;

/**
 * 排除的时候还需要排除其他@ComponentScan的类
 * 比如类A和类B都配置了@ComponentScan，那么回去合集
 * @author sucl
 * @since 2019/3/21
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.sucl.smms.*.mapper")
//@PropertySource(value = "classpath:config/config-*.properties")
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

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
//            dataSource.setDriverClass(env.getProperty("jdbc.driverClass"));
            dataSource.setDriverClass(Driver.class.getName());
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
        sqlSessionFactoryBean.setMapperLocations(null);
//        sqlSessionFactoryBean.setConfigLocation();
        sqlSessionFactoryBean.setTypeAliasesPackage("com.sucl.smms.*.model");
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("transactionManager")
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
