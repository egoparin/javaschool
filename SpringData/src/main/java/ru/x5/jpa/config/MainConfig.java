package ru.x5.jpa.config;

import java.util.Properties;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import ru.x5.jpa.repository.UserRepository;

/**
 * @author egor.oparin@x5.ru
 */
@Configuration
@ComponentScan(basePackages = "ru.x5.jpa")
@EnableMongoRepositories()
public class MainConfig {

//    @Bean
//    public DriverManagerDataSource dataSource() {
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClassName("org.h2.Driver");
//        driverManagerDataSource.setUrl("jdbc:h2:mem:testdb;INIT=RUNSCRIPT FROM 'classpath:/data.sql';");
//        return driverManagerDataSource;
//    }
//
//    @Bean(name="entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource());
//        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        Properties jpaProperties = new Properties();
//        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
////        jpaProperties.setProperty("hibernate.format_sql", "true" );
////        jpaProperties.setProperty("hibernate.show_sql", "true" );
//        entityManagerFactoryBean.setJpaProperties(jpaProperties);
//        entityManagerFactoryBean.setPackagesToScan("ru.x5.jpa");
//        return entityManagerFactoryBean;
//    }
//
//    @Bean("transactionManager")
//    public JpaTransactionManager jpaTransactionManager() {
//        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//        jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
//        return jpaTransactionManager;
//    }


}
