package ba.propertydamgerecognition.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;


import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = {
                "ba.propertydamgerecognition.repository"},
        transactionManagerRef = "pdrTransactionManager",
        entityManagerFactoryRef = "pdrEntityManagerFactory"
)
@EntityScan(basePackages = "ba.propertydamgerecognition.entity")
@ComponentScan(basePackages = {"ba.propertydamgerecognition"})
public class PersistenceConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(name = "pdrDataSource")
    public DataSource pdrDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "pdrEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean pdrEntityManagerFactory(
            final EntityManagerFactoryBuilder builder,
            final DataSource pdrDataSource) {
        return builder
                .dataSource(pdrDataSource)
                .packages(
                        "ba.propertydamgerecognition.entity"
                )
                .persistenceUnit("entityPersistenceUnit")
                .build();
    }

    @Bean(name = "pdrTransactionManager")
    public PlatformTransactionManager pdrTransactionManager(final EntityManagerFactory pdrEntityManagerFactory) {
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                pdrEntityManagerFactory);
        return transactionManager;
    }

}