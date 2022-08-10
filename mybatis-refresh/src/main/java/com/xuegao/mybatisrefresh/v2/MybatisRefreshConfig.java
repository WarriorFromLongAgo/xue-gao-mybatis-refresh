// package com.xuegao.mybatisrefresh.myv1;
//
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.autoconfigure.AutoConfigureAfter;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.io.Resource;
// import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
// import org.springframework.core.io.support.ResourcePatternResolver;
//
// import java.io.IOException;
//
// @Configuration
// @AutoConfigureAfter
// public class MybatisRefreshConfig {
//
//     @Autowired
//     private SqlSessionFactory sqlSessionFactory;
//
//     @Value("${mybatis.refresh-mapper:true}")
//     private Boolean refreshMapper;
//
//     private static final ResourcePatternResolver RESOURCE_RESOLVER = new PathMatchingResourcePatternResolver();
//
//     /**
//      * mapper.xml 热加载
//      *
//      * @return
//      */
//     @Bean
//     public com.xuegao.mybatisrefresh.myv1.MybatisMapperRefresh mybatisMapperRefresh() {
//         SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) SpringContextHolder.getBean("sqlSessionFactory");
//         Resource[] resources = new Resource[0];
//         try {
//             org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
//             configuration.m
//
//
//             resources = RESOURCE_RESOLVER.getResources(mapperLocations);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         com.xuegao.mybatisrefresh.myv1.MybatisMapperRefresh mybatisMapperRefresh =
//                 new com.xuegao.mybatisrefresh.myv1.MybatisMapperRefresh(resources, sqlSessionFactory, 10, 5, refreshMapper);
//         return mybatisMapperRefresh;
//
//     }
//
// }
