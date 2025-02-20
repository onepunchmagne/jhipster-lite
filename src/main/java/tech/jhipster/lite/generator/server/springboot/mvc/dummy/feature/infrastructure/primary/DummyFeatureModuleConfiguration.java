package tech.jhipster.lite.generator.server.springboot.mvc.dummy.feature.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.mvc.dummy.feature.application.DummyApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleApiDoc;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class DummyFeatureModuleConfiguration {

  @Bean
  JHipsterModuleResource dummyFeatureModule(DummyApplicationService dummy) {
    return JHipsterModuleResource
      .builder()
      .legacyUrl("/api/servers/spring-boot/features/dummy")
      .slug("dummy-feature")
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().addIndentation().build())
      .apiDoc(new JHipsterModuleApiDoc("Spring Boot - MVC", "Add Dummy context with some APIs"))
      .organization(
        JHipsterModuleOrganization
          .builder()
          .addFeatureDependency("cucumber-authentication")
          .addModuleDependency("bean-validation-test")
          .build()
      )
      .tags("server")
      .factory(dummy::buildModule);
  }
}
