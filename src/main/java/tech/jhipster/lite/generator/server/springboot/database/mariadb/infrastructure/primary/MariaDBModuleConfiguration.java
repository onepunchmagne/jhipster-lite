package tech.jhipster.lite.generator.server.springboot.database.mariadb.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.database.mariadb.application.MariaDBApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleApiDoc;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class MariaDBModuleConfiguration {

  public static final String URL_MARIADB_MODULE = "/api/servers/spring-boot/databases/mariadb";

  @Bean
  JHipsterModuleResource mariaDBModule(MariaDBApplicationService applicationService) {
    return JHipsterModuleResource
      .builder()
      .legacyUrl(URL_MARIADB_MODULE)
      .slug("mariadb")
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().addIndentation().addProjectBaseName().build())
      .apiDoc(new JHipsterModuleApiDoc("Spring Boot - Database", "Add MariaDB to project"))
      .organization(JHipsterModuleOrganization.builder().feature("jpa-persistence").addModuleDependency("springboot").build())
      .tags("server", "spring", "spring-boot", "database")
      .factory(applicationService::build);
  }
}
