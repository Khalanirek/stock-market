package com.khalanirek.stockmarket

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName

import static org.springframework.test.context.support.TestPropertySourceUtils.addInlinedPropertiesToEnvironment

class DatabaseInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    static PostgreSQLContainer postgresContainer

    @Override
    void initialize(ConfigurableApplicationContext applicationContext) {
        postgresContainer = startContainer()
        setupApplication(applicationContext)
    }

    private static PostgreSQLContainer startContainer() {
        DockerImageName postgres = DockerImageName.parse("postgres:16.2-alpine3.19")
                .asCompatibleSubstituteFor("postgres")
        def container = new PostgreSQLContainer(postgres)
                .withUsername("test")
                .withPassword("test")
                .tap { start() }
        println("PostgreSQLContainer started at " + container.jdbcUrl)
        return container
    }

    private static setupApplication(ConfigurableApplicationContext applicationContext) {
        addInlinedPropertiesToEnvironment(applicationContext,
                "spring.datasource.url=$postgresContainer.jdbcUrl",
                "spring.datasource.username=$postgresContainer.username",
                "spring.datasource.password=$postgresContainer.password")
    }

}
