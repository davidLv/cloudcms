package org.cloudcms.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PreDestroy;
import java.io.IOException;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
@MapperScan(basePackages = {"org.cloudcms.mapper"})
public class MybatisDataSource {
    @Autowired
    private DataSourceProperties dataSourceProperties;

    private final static String mapperLocation = "classpath:org/cloudcms/mapper/*.xml";

    private DataSource pool;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSourceProperties config = dataSourceProperties;

        this.pool = new DataSource();
        this.pool.setDriverClassName(config.getDriverClassName());
        this.pool.setUrl(config.getUrl());

        if (config.getUsername() != null) {
            this.pool.setUsername(config.getUsername());
        }

        if (config.getPassword() != null) {
            this.pool.setPassword(config.getPassword());
        }

        this.pool.setInitialSize(config.getInitialSize());
        this.pool.setMaxActive(config.getMaxActive());
        this.pool.setMaxIdle(config.getMaxIdle());
        this.pool.setMinIdle(config.getMinIdle());
        this.pool.setTestOnBorrow(config.isTestOnBorrow());
        this.pool.setTestOnReturn(config.isTestOnReturn());
        this.pool.setValidationQuery(config.getValidationQuery());
        return this.pool;
    }

    @PreDestroy
    public void close() {
        if (this.pool != null) {
            this.pool.close();
        }
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(this.dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocation));

        return sqlSessionFactoryBean.getObject();
    }

    /*@Bean
    public MapperScannerConfigurer mapperScannerConfigurer() throws Exception {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.cloudcms.dao");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName(String.valueOf(sqlSessionFactory));
        return mapperScannerConfigurer;
    }*/

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
