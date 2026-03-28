package com.archigen.generator;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class BuildFileGenerator {

    private final FileGenerator fileGenerator;

    public BuildFileGenerator(FileGenerator fileGenerator) {
        this.fileGenerator = fileGenerator;
    }

    public void generate(Path projectDir, String groupId, String artifactId, String version, String buildTool)
            throws IOException, TemplateException {
        Files.createDirectories(projectDir);
        Map<String, Object> model = new HashMap<>();
        model.put("groupId", groupId);
        model.put("artifactId", artifactId);
        model.put("version", version);

        if ("gradle".equalsIgnoreCase(buildTool)) {
            fileGenerator.generate("build.gradle.ftl", model, projectDir.resolve("build.gradle"));
        } else {
            fileGenerator.generate("pom.xml.ftl", model, projectDir.resolve("pom.xml"));
        }
    }
}
