package com.archigen.generator;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class StructureGenerator {

    private final FileGenerator fileGenerator;

    public StructureGenerator(FileGenerator fileGenerator) {
        this.fileGenerator = fileGenerator;
    }

    public void generate(Path baseDir, String packageName, String projectName, String entityName)
            throws IOException, TemplateException {
        String packagePath = packageName.replace('.', '/');
        Path srcMain = baseDir.resolve("src/main/java/" + packagePath);

        for (String dir : new String[]{"model", "dto", "mapper", "repository", "service", "service/impl", "controller"}) {
            Files.createDirectories(srcMain.resolve(dir));
        }
        Files.createDirectories(baseDir.resolve("src/main/resources"));
        Files.createDirectories(baseDir.resolve("src/test/java/" + packagePath));

        Map<String, Object> model = new HashMap<>();
        model.put("packageName", packageName);
        model.put("projectName", capitalize(projectName));
        model.put("entityName", entityName);

        fileGenerator.generate("Application.java.ftl", model,
                srcMain.resolve(capitalize(projectName) + "Application.java"));

        fileGenerator.generate("Model.java.ftl", model,
                srcMain.resolve("model/" + entityName + ".java"));

        fileGenerator.generate("RequestDTO.java.ftl", model,
                srcMain.resolve("dto/" + entityName + "RequestDTO.java"));

        fileGenerator.generate("ResponseDTO.java.ftl", model,
                srcMain.resolve("dto/" + entityName + "ResponseDTO.java"));

        fileGenerator.generate("Mapper.java.ftl", model,
                srcMain.resolve("mapper/" + entityName + "Mapper.java"));

        fileGenerator.generate("Repository.java.ftl", model,
                srcMain.resolve("repository/" + entityName + "Repository.java"));

        fileGenerator.generate("Service.java.ftl", model,
                srcMain.resolve("service/" + entityName + "Service.java"));

        fileGenerator.generate("ServiceImpl.java.ftl", model,
                srcMain.resolve("service/impl/" + entityName + "ServiceImpl.java"));

        fileGenerator.generate("Controller.java.ftl", model,
                srcMain.resolve("controller/" + entityName + "Controller.java"));
    }

    private String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}
