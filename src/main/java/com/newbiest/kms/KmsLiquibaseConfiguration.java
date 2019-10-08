package com.newbiest.kms;


import com.newbiest.main.YmlPropertyLoaderFactory;
import liquibase.integration.spring.SpringLiquibase;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Created by guoxunbo on 2019-07-25 16:28
 */
@Configuration
@ConfigurationProperties(prefix = "kms.liquibase")
@Data
@PropertySource(value = "classpath:kms.yml", factory = YmlPropertyLoaderFactory.class)
@Slf4j
public class KmsLiquibaseConfiguration {

    private String changeLog;

    private boolean enabled;

    private boolean dropFirst;

    /**
     * 默认的LiquibaseBean
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean("kmsLiquibase")
    @ConditionalOnResource(resources = {"classpath:kms.yml"})
    public SpringLiquibase liquibase(DataSource dataSource) throws Exception {
        if (log.isInfoEnabled()) {
            log.info("Load KMS Liquibase Configuration.");
        }
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(changeLog);
        liquibase.setShouldRun(enabled);
        liquibase.setDropFirst(dropFirst);
        return liquibase;
    }

}
