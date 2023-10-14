package com.app;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

@Service
public class PojoService {


    private String className;

    public void loadFile() {

        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            className = prop.getProperty("className");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void foo() throws Exception {
        loadFile();

        // 1. Configure FreeMarker
        //
        // You should do this ONLY ONCE, when your application starts,
        // then reuse the same Configuration object elsewhere.
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);

        // Where do we load the templates from:
        cfg.setClassForTemplateLoading(PojoService.class, "templates");

        // Some other recommended settings:
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setBooleanFormat("c");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // 2. Proccess template(s)
        // You will do this for several times in typical applications.
        // 2.1. Prepare the template input:
        Map<String, Object> input = new HashMap<>();
        input.put("cn", className);
//        input.put("bpn", className);
        input.put("obj", className);
//        input.put("hot", true);

        // 2.2. Get the template
        Template template = cfg.getTemplate("temp.ftl");

        // 2.3. Generate the output
        // Write output to the console
        // For the sake of example, also write output into a file:
        try (Writer fileWriter = new FileWriter(className + ".java")) {
            template.process(input, fileWriter);
        }

    }
}