package main.almacenar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Estructura {

    public void generateXson(File file, String outputFilePath) throws IOException {
        String id = null;
        String name = null;
        String href = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("<C_CC")) {
                    id = extractAttribute(line, "id");
                    name = extractAttribute(line, "name");
                } else if (line.startsWith("<C_LINK")) {
                    href = extractAttribute(line, "href");
                }
            }
        }

        File recoveryFolder = new File("target/recovery");
        if (!recoveryFolder.exists()) {
            recoveryFolder.mkdirs(); 
        }

        try (FileWriter fileWriter = new FileWriter(outputFilePath)) {
            fileWriter.write("{\n");
            fileWriter.write("  \"id\": \"" + (id != null ? id : "") + "\",\n");
            fileWriter.write("  \"name\": \"" + (name != null ? name : "") + "\",\n");
            fileWriter.write("  \"link\": \"" + (href != null ? href : "") + "\",\n");
            fileWriter.write("  \"fileName\": \"" + file.getName() + "\"\n");
            fileWriter.write("}");
        }
    }

    private String extractAttribute(String line, String attribute) {
        String pattern = attribute + "=\"";
        int start = line.indexOf(pattern);
        if (start == -1) {
            return null;
        }

        start += pattern.length();
        int end = line.indexOf("\"", start);
        if (end == -1) {
            return null;
        }

        return line.substring(start, end);
    }
}
