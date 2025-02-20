package tech.jhipster.lite.module.infrastructure.primary;

import static org.assertj.core.api.Assertions.*;
import static tech.jhipster.lite.module.domain.resource.JHipsterModulesResourceFixture.*;

import org.junit.jupiter.api.Test;
import tech.jhipster.lite.JsonHelper;
import tech.jhipster.lite.UnitTest;
import tech.jhipster.lite.module.domain.resource.JHipsterLandscape;
import tech.jhipster.lite.module.domain.resource.JHipsterLandscapeFixture;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@UnitTest
class RestJHipsterLandscapeTest {

  @Test
  void shouldSerializeToJson() {
    JHipsterModuleResource firstModule = defaultModuleResourceBuilder().slug("first").build();
    JHipsterModuleResource secondModule = defaultModuleResourceBuilder()
      .slug("second")
      .feature("my-feature")
      .moduleDependency("first")
      .build();

    assertThat(
      JsonHelper.writeAsString(
        RestJHipsterLandscape.from(JHipsterLandscape.from(JHipsterLandscapeFixture.moduleResources(firstModule, secondModule)))
      )
    )
      .isEqualTo(json());
  }

  private String json() {
    return """
        {\
        "levels":[\
        {"elements":[{"type":"MODULE","slug":"first","operation":"operation"}]},\
        {"elements":[{"type":"FEATURE","slug":"my-feature","modules":[{"type":"MODULE","slug":"second","operation":"operation","dependencies":["first"]}]}]}\
        ]\
        }\
        """;
  }
}
