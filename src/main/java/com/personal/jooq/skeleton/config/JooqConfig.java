package com.personal.jooq.skeleton.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.sfm.jooq.SfmRecordMapperProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by minhpham on 6/6/16.
 */
@Configuration
@EnableTransactionManagement
public class JooqConfig {

    private static final String DB_DRIVER = "db.driver";
    private static final String DB_URL = "db.url";
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASSWORD = "db.password";
    private static final String JOOQ_SQL_DIALECT = "jooq.sql.dialect";

    @Autowired
    Environment env;

    @Bean(destroyMethod = "close")
    DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(env.getProperty(DB_DRIVER));
        config.setJdbcUrl(env.getProperty(DB_URL));
        config.setUsername(env.getProperty(DB_USERNAME));
        config.setPassword(env.getProperty(DB_PASSWORD));
        return new HikariDataSource(config);
    }

    @Bean
    public LazyConnectionDataSourceProxy lazyConnectionDataSource() {
        return new LazyConnectionDataSourceProxy(dataSource());
    }

    @Bean
    public TransactionAwareDataSourceProxy transactionAwareDataSource() {
        return new TransactionAwareDataSourceProxy(lazyConnectionDataSource());
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(lazyConnectionDataSource());
    }

    @Bean
    public DataSourceConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(transactionAwareDataSource());
    }

    @Bean
    public JOOQToSpringExceptionTransformer jooqToSpringExceptionTransformer() {
        return new JOOQToSpringExceptionTransformer();
    }

    @Bean
    public DefaultConfiguration configuration() {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();

        jooqConfiguration.set(connectionProvider());
        jooqConfiguration.set(new DefaultExecuteListenerProvider(
                jooqToSpringExceptionTransformer()
        ));

        String sqlDialectName = env.getProperty(JOOQ_SQL_DIALECT);
        SQLDialect dialect = SQLDialect.valueOf(sqlDialectName);
        jooqConfiguration.set(dialect);

        // Use Simple Flat Mapper for auto mapping between JOOQ record and pojo object
        jooqConfiguration.set(new SfmRecordMapperProvider());

        return jooqConfiguration;
    }

    @Bean
    public DefaultDSLContext dsl() {
        return new DefaultDSLContext(configuration());
    }

}
