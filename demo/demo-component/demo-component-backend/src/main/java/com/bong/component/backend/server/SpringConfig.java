/**
 * 
 */
package com.bong.component.backend.server;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <pre>
 * 
 * </pre>
 * @author Bongjin Kwon
 *
 */
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.bong" })
public class SpringConfig {
	
	@Autowired
	private DataSource datasource;

	@Bean
    @Profile("default")
    public DataSource devDataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            //.addScript("classpath:com/bank/config/sql/schema.sql")
            //.addScript("classpath:com/bank/config/sql/test-data.sql")
            .build();
    }

	/*
    @Bean
    @Profile("production")
    public DataSource productionDataSource() throws Exception {
        Context ctx = new InitialContext();
        return (DataSource) ctx.lookup("java:comp/env/jdbc/datasource");
    }
    
   */
    
    @Bean
    @Produces
    @ApplicationScoped
    public EntityManagerFactory entityManagerFactory() {

      HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      vendorAdapter.setGenerateDdl(true);

      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
      factory.setPersistenceUnitName("persistenceUnit");
      factory.setJpaVendorAdapter(vendorAdapter);
      factory.setPackagesToScan("com.bong.component.model");
      factory.setDataSource(datasource);
      factory.afterPropertiesSet();

      return factory.getObject();
      
    }
    
 
	
    @Bean
    public PlatformTransactionManager transactionManager() {

      JpaTransactionManager txManager = new JpaTransactionManager();
      txManager.setEntityManagerFactory(entityManagerFactory());
      return txManager;
    }
    
    public void close(@Disposes EntityManagerFactory entityManagerFactory) {
        entityManagerFactory.close();
      }

      @Produces
      @RequestScoped
      public EntityManager createEntityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
      }

      public void close(@Disposes EntityManager entityManager) {
        entityManager.close();
      }

}
