package tech.jhipster.lite.module.infrastructure.secondary;

import static org.assertj.core.api.Assertions.*;
import static tech.jhipster.lite.module.domain.JHipsterModule.*;
import static tech.jhipster.lite.module.domain.JHipsterModule.from;

import ch.qos.logback.classic.Level;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tech.jhipster.lite.LogsSpy;
import tech.jhipster.lite.TestFileUtils;
import tech.jhipster.lite.UnitTest;
import tech.jhipster.lite.error.domain.GeneratorException;
import tech.jhipster.lite.module.domain.FilesToDelete;
import tech.jhipster.lite.module.domain.JHipsterModule;
import tech.jhipster.lite.module.domain.JHipsterProjectFilePath;
import tech.jhipster.lite.module.domain.properties.JHipsterModuleProperties;
import tech.jhipster.lite.module.domain.properties.JHipsterProjectFolder;
import tech.jhipster.lite.projectfile.infrastructure.secondary.FileSystemProjectFilesReader;

@UnitTest
@ExtendWith(LogsSpy.class)
class FileSystemJHipsterModuleFilesTest {

  private static final FileSystemJHipsterModuleFiles files = new FileSystemJHipsterModuleFiles(new FileSystemProjectFilesReader());

  private final LogsSpy logs;

  public FileSystemJHipsterModuleFilesTest(LogsSpy logs) {
    this.logs = logs;
  }

  @Test
  void shouldNotWriteOnUnwritablePath() {
    JHipsterProjectFolder project = new JHipsterProjectFolder(Paths.get("src/test/resources/generator").toAbsolutePath().toString());

    JHipsterModule module = moduleBuilder(JHipsterModuleProperties.defaultProperties(project))
      .files()
      .add(from("server/springboot/core/MainApp.java.mustache"), to("content"))
      .and()
      .build();

    assertThatThrownBy(() -> files.create(project, module.templatedFiles())).isExactlyInstanceOf(GeneratorException.class);
  }

  @Test
  void shouldTraceAddedFiles() {
    JHipsterProjectFolder project = new JHipsterProjectFolder(TestFileUtils.tmpDirForTest());

    JHipsterModule module = moduleBuilder(JHipsterModuleProperties.defaultProperties(project))
      .files()
      .add(from("server/springboot/core/MainApp.java.mustache"), to("MainApp.java"))
      .and()
      .build();

    files.create(project, module.templatedFiles());

    logs.shouldHave(Level.DEBUG, "MainApp.java");
  }

  @Test
  void shouldNotDeleteUnknownFile() {
    JHipsterProjectFolder project = new JHipsterProjectFolder(TestFileUtils.tmpDirForTest());

    assertThatThrownBy(() -> files.delete(project, new FilesToDelete(List.of(new JHipsterProjectFilePath("unknown-file")))))
      .isExactlyInstanceOf(UnknownFileToDeleteException.class)
      .hasMessageContaining("unknown-file");
  }
}
