package tech.jhipster.lite.generator.server.springboot.mvc.security.jwt.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.mvc.security.jwt.application.JwtAuthenticationApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleApiDoc;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
public class JwtAuthenticationModulesConfiguration {

  private static final String AUTHENTICATION = "authentication";

  @Bean
  JHipsterModuleResource jwtAuthenticationModule(JwtAuthenticationApplicationService jwtAuthentications) {
    return JHipsterModuleResource
      .builder()
      .legacyUrl("/api/servers/spring-boot/security-systems/jwt")
      .slug("springboot-jwt")
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().addIndentation().addProjectBaseName().build())
      .apiDoc(new JHipsterModuleApiDoc("Spring Boot - MVC - Security", "Add Spring Security JWT"))
      .organization(JHipsterModuleOrganization.builder().feature(AUTHENTICATION).addFeatureDependency("spring-server").build())
      .tags("server", "spring", "spring-boot", AUTHENTICATION)
      .factory(jwtAuthentications::buildAuthenticationModule);
  }

  @Bean
  JHipsterModuleResource jwtBasicAuthModule(JwtAuthenticationApplicationService jwtAuthentications) {
    return JHipsterModuleResource
      .builder()
      .legacyUrl("/api/servers/spring-boot/security-systems/jwt/basic-auth")
      .slug("springboot-jwt-basic-auth")
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().addIndentation().build())
      .apiDoc(new JHipsterModuleApiDoc("Spring Boot - MVC - Security", "Add Basic Auth for Spring Security JWT"))
      .organization(JHipsterModuleOrganization.builder().addModuleDependency("springboot-jwt").build())
      .tags("server", "spring", "spring-boot", AUTHENTICATION)
      .factory(jwtAuthentications::buildBasicAuthModule);
  }
}
