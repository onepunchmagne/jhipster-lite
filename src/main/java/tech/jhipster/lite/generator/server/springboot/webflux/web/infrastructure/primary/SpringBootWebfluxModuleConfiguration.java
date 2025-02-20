package tech.jhipster.lite.generator.server.springboot.webflux.web.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.webflux.web.application.SpringBootWebfluxApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleApiDoc;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class SpringBootWebfluxModuleConfiguration {

  @Bean
  JHipsterModuleResource springBootWebfluxModule(SpringBootWebfluxApplicationService webflux) {
    return JHipsterModuleResource
      .builder()
      .legacyUrl("/api/servers/spring-boot/reactive-servers/netty")
      .slug("springboot-webflux-netty")
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().addIndentation().addServerPort().build())
      .apiDoc(new JHipsterModuleApiDoc("Spring Boot - Webflux", "Add Spring Boot Webflux with Netty"))
      .organization(JHipsterModuleOrganization.SPRINGBOOT_DEPENDENCY)
      .tags("server", "webflux")
      .factory(webflux::buildModule);
  }
}
