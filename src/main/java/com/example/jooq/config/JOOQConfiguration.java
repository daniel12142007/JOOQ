package com.example.jooq.config;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JOOQConfiguration {
    private final DataSource dataSource;

    @Bean
    public DSLContext dslContext() {
        TransactionAwareDataSourceProxy transactionAwareDataSource =
                new TransactionAwareDataSourceProxy(dataSource);
        DataSourceConnectionProvider connectionProvider =
                new DataSourceConnectionProvider(transactionAwareDataSource);
        DefaultConfiguration configuration = new DefaultConfiguration();
        configuration.set(connectionProvider);
        configuration.set(SQLDialect.POSTGRES);
        return new org.jooq.impl.DefaultDSLContext(configuration);
    }
}