package tech.jhipster.lite.generator.packagemanager.npm.domain;

import java.util.Optional;
import tech.jhipster.lite.generator.project.domain.Project;

public interface NpmService {
  void addDependency(Project project, String dependency, String version);
  void addDevDependency(Project project, String dependency, String version);
  void addScript(Project project, String name, String cmd);

  Optional<String> getVersion(String folder, String name);
}
