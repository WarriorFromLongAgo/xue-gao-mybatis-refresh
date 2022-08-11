package com.xuegao.mybatisdemo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.xuegao.mybatisdemo.business.*")
public class MybatisConfig {
    private static final Logger log = LoggerFactory.getLogger(MybatisConfig.class);

    @Bean("sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Autowired @Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        // com.xuegao.mybatisrefresh.v1.SqlSessionFactoryBean factoryBean = new com.xuegao.mybatisrefresh.v1.SqlSessionFactoryBean();

        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:/mapper/**/*.xml"));
        factoryBean.setTypeAliasesPackage("com.kye.crmoffertool.model.*");
        log.info("[xue-gao-mybatis-refresh][MybatisConfig][sqlSessionFactory][1111]");
        return factoryBean.getObject();
    }
}
