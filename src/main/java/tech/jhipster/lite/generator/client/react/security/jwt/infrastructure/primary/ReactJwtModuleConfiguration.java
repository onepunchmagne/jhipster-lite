package tech.jhipster.lite.generator.client.react.security.jwt.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.client.react.security.jwt.application.ReactJwtApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleApiDoc;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class ReactJwtModuleConfiguration {

  @Bean
  JHipsterModuleResource reactJwtModule(ReactJwtApplicationService reactJwt) {
    return JHipsterModuleResource
      .builder()
      .legacyUrl("/api/clients/react/jwt")
      .slug("react-jwt")
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addIndentation().build())
      .apiDoc(new JHipsterModuleApiDoc("React", "Add JWT Login React"))
      .organization(JHipsterModuleOrganization.builder().addModuleDependency("react-core").build())
      .tags("client", "react", "jwt")
      .factory(reactJwt::buildModule);
  }
}
