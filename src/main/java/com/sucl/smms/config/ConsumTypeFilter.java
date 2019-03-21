package com.sucl.smms.config;

import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @ComponentScan.Filter(type = FilterType.CUSTOM)
 * @author sucl
 * @since 2019/3/21
 */
public class ConsumTypeFilter implements TypeFilter {

    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        for (String s : annotationMetadata.getAnnotationTypes()) {
            if(s.equals(Controller.class.getName()) || s.equals(RestController.class.getName())){
                return true;
            }
            System.out.println("当前正在被扫描的类注解类型" + s);
        }
        //获取当前正在扫描类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        System.out.println("当前正在被扫描的类的类名" + classMetadata.getClassName());
        //获取当前类的资源信息（类存放的路径...）
        Resource resource = metadataReader.getResource();
        System.out.println("当前正在被扫描的类存放的地址" + resource.getURL());
        return false;
    }
}
