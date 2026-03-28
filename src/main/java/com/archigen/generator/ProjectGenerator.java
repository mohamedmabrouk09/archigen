package com.archigen.generator;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ProjectGenerator {

    private final FileGenerator fileGenerator;
    private final StructureGenerator structureGenerator;
    private final BuildFileGenerator buildFileGenerator;

    public ProjectGenerator() throws IOException {
        this.fileGenerator = new FileGenerator();
        this.structureGenerator = new StructureGenerator(fileGenerator);
        this.buildFileGenerator = new BuildFileGenerator(fileGenerator);
    }

    public void generate(Path outputDir, String projectName, String groupId, String artifactId,
                         String version, String entityName, String buildTool)
            throws IOException, TemplateException {
        Path projectDir = outputDir.resolve(projectName);
        String packageName = groupId + "." + artifactId.replace("-", "");

        buildFileGenerator.generate(projectDir, groupId, artifactId, version, buildTool);
        structureGenerator.generate(projectDir, packageName, projectName, entityName);

        Map<String, Object> readmeModel = new HashMap<>();
        readmeModel.put("projectName", projectName);
        readmeModel.put("packagePath", packageName.replace('.', '/'));
        fileGenerator.generate("README.md.ftl", readmeModel, projectDir.resolve("README.md"));

        System.out.println("Project '" + projectName + "' generated at: " + projectDir.toAbsolutePath());
    }
}
