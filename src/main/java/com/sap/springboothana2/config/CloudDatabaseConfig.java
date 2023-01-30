package com.sap.springboothana2.config;

import javax.persistence.EntityManagerFactory;
// import javax.sql.DataSource;

// import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
// import org.springframework.context.annotation.Profile;

import com.zaxxer.hikari.HikariDataSource;

import io.pivotal.cfenv.core.CfCredentials;
import io.pivotal.cfenv.jdbc.CfJdbcEnv;


@Configuration
// @Profile("cloud")
public class CloudDatabaseConfig extends AbstractCloudConfig {

    Logger log = LoggerFactory.getLogger(getClass());
    // @Bean
    // public DataSourceBuilder<HikariDataSource> dataSource (){

    //     CfJdbcEnv cfJdbcEnv = new CfJdbcEnv();
    //     // CfCredentials cfCredentials = cfJdbcEnv.findCredentialsByTag("hana");
    //     CfCredentials cfCredentials = cfJdbcEnv.findServiceByLabel("hana").getCredentials();
    //     String uri = cfCredentials.getUri("hana");
    //     log.info(uri);
    //     log.info(cfCredentials.getUsername());
    //     log.info(cfCredentials.getPassword());


    //     return DataSourceBuilder.create()
    //     .type(HikariDataSource.class)
    //     .driverClassName(com.sap.db.jdbc.Driver.class.getName())
    //     .url("jdbc:sap://f4426177-a5b1-4212-81bd-38112b919382.hana.prod-eu10.hanacloud.ondemand.com:443?encrypt=true&validateCertificate=true&currentschema=USR_0WW6IJ32WEGYF0Z9IQEOUNT1S")
    //     .username(cfCredentials.getUsername())
    //     .password(cfCredentials.getPassword());
        
    // }

    @Bean
    @Primary
    // @Profile("cloud")
    public DataSourceProperties dataSourceProperties(){
        CfJdbcEnv cfJdbcEnv = new CfJdbcEnv();
    DataSourceProperties dataSourceProperties = new DataSourceProperties();
    CfCredentials cfCredentials = cfJdbcEnv.findCredentialsByTag("hana");
    if(cfCredentials != null){
        String uri = cfCredentials.getUri("hana");
        dataSourceProperties.setUrl(uri);
        dataSourceProperties.setUsername(cfCredentials.getUsername());
        dataSourceProperties.setPassword(cfCredentials.getPassword());
        dataSourceProperties.setDriverClassName(com.sap.db.jdbc.Driver.class.getName());
    }
    return dataSourceProperties;

    }

    
    
}
