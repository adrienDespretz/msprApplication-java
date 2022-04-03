package generator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GlobalGenerator {
    public static void main(String[] args) {
        AccueilGenerator generator = new AccueilGenerator();
        String indexHtml = generator.getHtmlPage();


    }
}
