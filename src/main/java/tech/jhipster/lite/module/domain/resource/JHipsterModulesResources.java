package tech.jhipster.lite.module.domain.resource;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import tech.jhipster.lite.error.domain.Assert;

public record JHipsterModulesResources(Collection<JHipsterModuleResource> modulesResources) {
  public JHipsterModulesResources {
    Assert.field("modulesResources", modulesResources).noNullElement().notEmpty();

    assertUniqueSlugs(modulesResources);
  }

  private void assertUniqueSlugs(Collection<JHipsterModuleResource> modulesResources) {
    if (duplicatedSlug(modulesResources)) {
      throw new DuplicatedSlugException();
    }
  }

  private boolean duplicatedSlug(Collection<JHipsterModuleResource> modulesResources) {
    return modulesResources.stream().map(JHipsterModuleResource::slug).collect(Collectors.toSet()).size() != modulesResources.size();
  }

  public Stream<JHipsterModuleResource> stream() {
    return modulesResources().stream();
  }
}
