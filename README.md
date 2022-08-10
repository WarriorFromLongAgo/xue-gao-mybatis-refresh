# xue-gao-mybatis-refresh
# v1
新增了一个 SqlSessionFactoryBean，这样子是不行的，
因为mybatis-plus等等的存在，新代理一个 SqlSessionFactoryBean 这样子会应影响正常的流程

由于代理了 SqlSessionFactoryBean，所以入参基本上都是直接传递进来的，所以不用去拿参数

包括但不限制于，Resource configLocation，Resource[] mapperLocations，Properties configurationProperties
SqlSessionFactoryBuilder sqlSessionFactoryBuilder，SqlSessionFactory sqlSessionFactory，
String environment，Interceptor[] plugins，TypeHandler<?>[] typeHandlers，
String typeHandlersPackage，Class<?>[] typeAliases，String typeAliasesPackage，

# v2

