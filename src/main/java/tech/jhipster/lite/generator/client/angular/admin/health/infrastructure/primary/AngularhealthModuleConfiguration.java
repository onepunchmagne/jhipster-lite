package tech.jhipster.lite.generator.client.angular.admin.health.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.client.angular.admin.health.application.AngularHealthApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleApiDoc;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class AngularhealthModuleConfiguration {

  @Bean
  JHipsterModuleResource angularHealthModule(AngularHealthApplicationService angularHealth) {
    return JHipsterModuleResource
      .builder()
      .legacyUrl("/api/clients/angular/admin-pages/health")
      .slug("angular-health")
      .withoutProperties()
      .apiDoc(new JHipsterModuleApiDoc("Angular", "Angular Health"))
      .organization(JHipsterModuleOrganization.builder().addModuleDependency("angular-core").build())
      .tags("client", "angular", "health")
      .factory(angularHealth::buildModule);
  }
}
