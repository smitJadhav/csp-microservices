package com.csp.config.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @author Smit.Jadhav on 3-10-2020.
 */

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableConfigurationProperties({JpaProperties.class, DatabaseConfig.class})
public class HibernateConfig {

    private final JpaProperties jpaProperties;

    @Autowired
    public HibernateConfig(JpaProperties jpaProperties) {
        this.jpaProperties = jpaProperties;
    }

    @Bean
    @Autowired
    public DataSource hikariDataSource(DatabaseConfig databaseConfig) throws Exception {
        return databaseConfig.createDataSource();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource hikariDataSource, DatabaseConfig databaseConfig,
                                                                       JpaProperties jpaProperties, HibernateProperties hibernateProperties) {
        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(hikariDataSource);
        entityManager.setPackagesToScan(databaseConfig.getPackagesToScan());
        entityManager.setJpaVendorAdapter(jpaVendorAdapter());
        entityManager.setJpaPropertyMap(properties);

        return entityManager;
    }


    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }


}
