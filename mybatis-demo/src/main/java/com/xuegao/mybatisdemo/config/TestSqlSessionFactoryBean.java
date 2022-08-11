package com.xuegao.mybatisdemo.config;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@AutoConfigureAfter({SqlSessionFactory.class})
public class TestSqlSessionFactoryBean implements ApplicationContextAware, ApplicationListener<ApplicationReadyEvent> {
    private static final Logger log = LoggerFactory.getLogger(TestSqlSessionFactoryBean.class);

    @Autowired
    private MybatisProperties properties;

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        SqlSessionFactory oldSqlSessionFactory = (SqlSessionFactory) this.context.getBean("sqlSessionFactory");
        SqlSessionFactory sqlSessionFactory = this.context.getBean(SqlSessionFactory.class);
        log.info("[xue-gao-mybatis-refresh][TestSqlSessionFactoryBean][onApplicationEvent][applicationReadyEvent={}]", applicationReadyEvent);
        Configuration oldConfiguration = oldSqlSessionFactory.getConfiguration();

        if (this.properties != null) {
            Resource[] resources = this.properties.resolveMapperLocations();
            int r = resources.length;
            for (Resource resource : resources) {
                System.out.println(resource);
            }
            String configLocation = this.properties.getConfigLocation();
            String[] mapperLocations = this.properties.getMapperLocations();
            Configuration configuration = this.properties.getConfiguration();
            String typeAliasesPackage = this.properties.getTypeAliasesPackage();
            Class<?> typeAliasesSuperType = this.properties.getTypeAliasesSuperType();
            Properties configurationProperties = this.properties.getConfigurationProperties();
            String typeHandlersPackage = this.properties.getTypeHandlersPackage();



            System.out.println();
        }

    }
}
