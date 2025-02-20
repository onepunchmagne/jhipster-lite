package tech.jhipster.lite.module.domain.resource;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import tech.jhipster.lite.module.domain.JHipsterFeatureSlug;
import tech.jhipster.lite.module.domain.JHipsterModuleSlug;

public final class JHipsterLandscapeFixture {

  private JHipsterLandscapeFixture() {}

  public static JHipsterModulesResources moduleResources(JHipsterModuleResource... resources) {
    return new JHipsterModulesResources(List.of(resources));
  }

  public static JHipsterLandscapeModule noDependencyLandscapeModule(String slug) {
    return JHipsterLandscapeModule.builder().module(slug).operation("operation").withoutDependencies();
  }

  public static JHipsterLandscapeModule oneModuleDependencyLandscapeModule(String slug, String dependency) {
    return JHipsterLandscapeModule.builder().module(slug).operation("operation").dependencies(landscapeModuleDependencies(dependency));
  }

  public static JHipsterLandscapeLevel landscapeLevel(JHipsterLandscapeElement... elements) {
    return new JHipsterLandscapeLevel(List.of(elements));
  }

  public static JHipsterLandscapeFeature landscapeFeature(String slug, JHipsterLandscapeModule... modules) {
    return new JHipsterLandscapeFeature(new JHipsterFeatureSlug(slug), List.of(modules));
  }

  public static Collection<JHipsterLandscapeDependency> landscapeModuleDependencies(String... modules) {
    return Stream.of(modules).map(JHipsterModuleSlug::new).map(toModuleDependency()).toList();
  }

  private static Function<JHipsterModuleSlug, JHipsterLandscapeDependency> toModuleDependency() {
    return JHipsterModuleDependency::new;
  }
}
