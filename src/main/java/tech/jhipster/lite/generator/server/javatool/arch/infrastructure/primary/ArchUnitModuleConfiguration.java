package tech.jhipster.lite.generator.server.javatool.arch.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.javatool.arch.application.JavaArchUnitApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleApiDoc;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class ArchUnitModuleConfiguration {

  @Bean
  JHipsterModuleResource archUnitModule(JavaArchUnitApplicationService archUnit) {
    return JHipsterModuleResource
      .builder()
      .legacyUrl("/api/servers/java/arch")
      .slug("java-archunit")
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().addIndentation().build())
      .apiDoc(new JHipsterModuleApiDoc("Java", "Add Hexagonal Arch classes to project"))
      .organization(JHipsterModuleOrganization.builder().addFeatureDependency("java-build-tool").build())
      .tags("server", "test")
      .factory(archUnit::buildModule);
  }
}
