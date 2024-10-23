package com.libwiz.libwiz.configurations;

import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories(basePackages = "com.libwiz.libwiz.repository") // Repository arayüzlerinin bulunduğu paket
@EnableConfigurationProperties(DataSourceProperties.class)
public class JPAConfigurations {

    private static final Logger logger = LoggerFactory.getLogger(JPAConfigurations.class);

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        logger.info("Creating EntityManagerFactory bean...");

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.libwiz.libwiz");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        logger.info("EntityManagerFactory bean created with data source: {}", dataSource);
        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        logger.info("Creating TransactionManager bean...");
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public DataSource dataSource(DataSourceProperties properties) {
        logger.info("Configuring DataSource bean...");
        DataSource dataSource = properties.initializeDataSourceBuilder().build();
        logger.info("DataSource bean configured: {}", dataSource);
        return dataSource;
    }
}
