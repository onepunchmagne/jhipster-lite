package tech.jhipster.lite.module.domain.resource;

import tech.jhipster.lite.error.domain.Assert;
import tech.jhipster.lite.module.domain.JHipsterFeatureSlug;
import tech.jhipster.lite.module.domain.JHipsterSlug;

public record JHipsterFeatureDependency(JHipsterFeatureSlug feature) implements JHipsterLandscapeDependency {
  public JHipsterFeatureDependency {
    Assert.notNull("feature", feature);
  }

  @Override
  public JHipsterSlug slug() {
    return feature();
  }
}
