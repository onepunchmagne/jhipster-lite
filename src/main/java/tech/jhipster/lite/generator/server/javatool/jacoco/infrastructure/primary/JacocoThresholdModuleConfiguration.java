package tech.jhipster.lite.generator.server.javatool.jacoco.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.javatool.jacoco.application.JacocoApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleApiDoc;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class JacocoThresholdModuleConfiguration {

  @Bean
  JHipsterModuleResource jacocoModuleThreshold(JacocoApplicationService jacoco) {
    return JHipsterModuleResource
      .builder()
      .legacyUrl("/api/servers/java/jacoco-minimum-coverage")
      .slug("jacoco-check-min-coverage")
      .withoutProperties()
      .apiDoc(new JHipsterModuleApiDoc("Java", "Add JaCoCo configuration to check minimum coverage"))
      .organization(JHipsterModuleOrganization.builder().addFeatureDependency("java-build-tool").build())
      .tags("server", "tools", "coverage")
      .factory(jacoco::buildModule);
  }
}
