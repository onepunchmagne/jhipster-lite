package tech.jhipster.lite.module.infrastructure.primary;

import java.util.Collection;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;

class RestJHipsterModulePropertiesDefinition {

  private final Collection<RestJHipsterModulePropertyDefinition> definitions;

  private RestJHipsterModulePropertiesDefinition(Collection<RestJHipsterModulePropertyDefinition> definitions) {
    this.definitions = definitions;
  }

  static RestJHipsterModulePropertiesDefinition from(JHipsterModulePropertiesDefinition propertiesDefinition) {
    return new RestJHipsterModulePropertiesDefinition(
      propertiesDefinition.stream().map(RestJHipsterModulePropertyDefinition::from).toList()
    );
  }

  public Collection<RestJHipsterModulePropertyDefinition> getDefinitions() {
    return definitions;
  }
}
