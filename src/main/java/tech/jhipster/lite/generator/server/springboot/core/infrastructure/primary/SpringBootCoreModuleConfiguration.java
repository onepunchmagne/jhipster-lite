package tech.jhipster.lite.generator.server.springboot.core.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.core.application.SpringBootApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleApiDoc;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class SpringBootCoreModuleConfiguration {

  @Bean
  JHipsterModuleResource springBootCoreModule(SpringBootApplicationService springBoot) {
    return JHipsterModuleResource
      .builder()
      .legacyUrl("/api/servers/spring-boot")
      .slug("springboot")
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().addProjectBaseName().addIndentation().build())
      .apiDoc(new JHipsterModuleApiDoc("Spring Boot", "Init Spring Boot project with dependencies, App, and properties"))
      .organization(JHipsterModuleOrganization.builder().addFeatureDependency("java-build-tool").build())
      .tags("server", "spring", "spring-boot")
      .factory(springBoot::buildModule);
  }
}
