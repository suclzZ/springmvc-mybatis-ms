package com.sucl.smms.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * web.xml
 * @author sucl
 * @since 2019/3/21
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*
     * DispatcherServlet的映射路径
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /*
     * 应用上下文，除web部分
     */
    @Override
    protected Class[] getRootConfigClasses() {
        //加载配置文件类，这里与上面的xml配置是对应的，需要使用@Configuration注解进行标注
        return new Class[] {RootConfig.class};
    }

    /*
     * web上下文
     */
    @Override
    protected Class[] getServletConfigClasses() {
        return new Class[] {ServletConfig.class};
    }

    /*
     * 注册过滤器，映射路径与DispatcherServlet一致，路径不一致的过滤器需要注册到另外的WebApplicationInitializer中
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }

}
