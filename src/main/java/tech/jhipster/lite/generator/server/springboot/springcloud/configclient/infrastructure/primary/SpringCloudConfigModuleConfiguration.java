package tech.jhipster.lite.generator.server.springboot.springcloud.configclient.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.springboot.springcloud.configclient.application.SpringCloudConfigClientApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleApiDoc;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class SpringCloudConfigModuleConfiguration {

  @Bean
  JHipsterModuleResource springCloudConfigModule(SpringCloudConfigClientApplicationService cloudConfigs) {
    return JHipsterModuleResource
      .builder()
      .legacyUrl("/api/servers/spring-boot/distributed-systems/spring-cloud/config-client")
      .slug("spring-cloud")
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addProjectBaseName().build())
      .apiDoc(new JHipsterModuleApiDoc("Spring Boot - Spring Cloud", "Add Spring Cloud Config Client"))
      .organization(JHipsterModuleOrganization.SPRINGBOOT_DEPENDENCY)
      .tags("server", "spring", "spring-boot", "cloud")
      .factory(cloudConfigs::buildModule);
  }
}
