package generator;

import readers.StaffReader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GlobalGenerator {
    public static void main(String[] args) {
        AccueilGenerator accueilGenerator = new AccueilGenerator();
        String indexHtml = accueilGenerator.getHtmlPage();

        try {
            FileWriter myWriter = new FileWriter("out/index.html");
            myWriter.write(indexHtml);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        StaffReader staffReader = new StaffReader();
        List<String> staffList = staffReader.getStaffList();
        for(String staffName : staffList){
            AgentPageGenerator agentPageGenerator = new AgentPageGenerator(staffName);
            String agentPageHtml = agentPageGenerator.getHtmlPage();

            try {
                FileWriter myWriter = new FileWriter("out/agents/"+staffName+".html");
                myWriter.write(agentPageHtml);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
}
