package com.archigen.command;

import com.archigen.generator.ProjectGenerator;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Path;

@Command(name = "new", description = "Generate a new Spring Boot project")
public class NewCommand implements Runnable {

    @Parameters(index = "0", description = "Project name")
    private String projectName;

    @Option(names = {"--group-id", "-g"}, description = "Maven group ID", defaultValue = "com.example")
    private String groupId;

    @Option(names = {"--artifact-id", "-a"}, description = "Maven artifact ID")
    private String artifactId;

    @Option(names = {"--version", "-v"}, description = "Project version", defaultValue = "0.0.1-SNAPSHOT")
    private String version;

    @Option(names = {"--entity", "-e"}, description = "Entity name (e.g. Order)", defaultValue = "Sample")
    private String entityName;

    @Option(names = {"--build-tool", "-b"}, description = "Build tool: maven or gradle", defaultValue = "maven")
    private String buildTool;

    @Option(names = {"--output", "-o"}, description = "Output directory", defaultValue = ".")
    private String outputDir;

    @Override
    public void run() {
        if (artifactId == null) {
            artifactId = projectName.toLowerCase().replace(" ", "-");
        }
        try {
            new ProjectGenerator().generate(
                Path.of(outputDir), projectName, groupId, artifactId, version, entityName, buildTool
            );
        } catch (Exception e) {
            System.err.println("Error generating project: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
