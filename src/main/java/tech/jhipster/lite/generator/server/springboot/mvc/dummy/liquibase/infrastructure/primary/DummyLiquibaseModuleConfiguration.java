package tech.jhipster.lite.generator.server.springboot.mvc.dummy.liquibase.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.mvc.dummy.liquibase.application.DummyLiquibaseApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleApiDoc;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class DummyLiquibaseModuleConfiguration {

  @Bean
  JHipsterModuleResource dummyLiquibaseModule(DummyLiquibaseApplicationService dummyLiquibase) {
    return JHipsterModuleResource
      .builder()
      .legacyUrl("/api/servers/spring-boot/features/dummy-liquibase-changelog")
      .slug("dummy-liquibase-changelog")
      .withoutProperties()
      .apiDoc(new JHipsterModuleApiDoc("Spring Boot - MVC", "Add liquibase changelog for dummy feature"))
      .organization(JHipsterModuleOrganization.builder().feature("dummy-schema").addModuleDependency("dummy-feature").build())
      .tags("server")
      .factory(dummyLiquibase::buildModule);
  }
}
