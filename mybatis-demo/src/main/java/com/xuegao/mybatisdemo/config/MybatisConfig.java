// package com.xuegao.mybatisdemo.config;
//
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.mybatis.spring.annotation.MapperScan;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;
// import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
// import javax.sql.DataSource;
//
// @Configuration
// @MapperScan(basePackages = "com.xuegao.mybatisdemo.business.demo.*")
// public class MybatisConfig {
//     @Bean("sqlSessionFactory")
//     @Primary
//     public SqlSessionFactory sqlSessionFactory(@Autowired @Qualifier("dataSource") DataSource dataSource) throws Exception {
//
//         // 可添加自定义拦截器，没有自定义拦截器的小伙伴可忽略此部分
//         // MybatisConfiguration
//         MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
//
//         // 开启缓存，可自行选择
//         mybatisConfiguration.setCacheEnabled(true);
//         mybatisConfiguration.setMapUnderscoreToCamelCase(Boolean.TRUE);
//
//         // 使用MybatisSqlSessionFactoryBean
//         MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//
//         // 设置数据源
//         sqlSessionFactoryBean.setDataSource(dataSource);
//
//         // 添加MybatisConfiguration
//         sqlSessionFactoryBean.setConfiguration(mybatisConfiguration);
//
//         // 设置mapper相应的xml路径,
//         sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                 .getResources("classpath*:/mapper/**/*.xml"));
//         sqlSessionFactoryBean.setTypeAliasesPackage("com.kye.crmoffertool.model");
//
//         // 返回MybatisSqlSessionFactoryBean从而替代原生的sqlSessionFactory
//         return sqlSessionFactoryBean.getObject();
//     }
//
// }
