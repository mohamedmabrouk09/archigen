package com.archigen.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.Map;

public class FileGenerator {

    private final Configuration cfg;

    public FileGenerator() throws IOException {
        cfg = new Configuration(Configuration.VERSION_2_3_33);
        cfg.setClassForTemplateLoading(FileGenerator.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");
    }

    public void generate(String templateName, Map<String, Object> model, Path outputPath)
            throws IOException, TemplateException {
        Template template = cfg.getTemplate(templateName);
        outputPath.getParent().toFile().mkdirs();
        try (Writer writer = new FileWriter(outputPath.toFile())) {
            template.process(model, writer);
        }
    }
}
