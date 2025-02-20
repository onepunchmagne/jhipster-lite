package tech.jhipster.lite.generator.ci.github.actions.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.ci.github.actions.application.GitHubActionsApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleApiDoc;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class GitHubActionsModuleConfiguration {

  @Bean
  JHipsterModuleResource gutHubActionsModule(GitHubActionsApplicationService gitHubActions) {
    return JHipsterModuleResource
      .builder()
      .legacyUrl("/api/developer-tools/github-actions")
      .slug("github-actions")
      .withoutProperties()
      .apiDoc(new JHipsterModuleApiDoc("Continuous Integration", "Add GitHub Actions for Maven Build"))
      .organization(JHipsterModuleOrganization.builder().addModuleDependency("maven-java").build())
      .tags("ci", "github")
      .factory(gitHubActions::buildModule);
  }
}
