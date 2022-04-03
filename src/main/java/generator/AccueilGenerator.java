package generator;

import objects.Agent;
import readers.StaffReader;

import java.util.List;

public class AccueilGenerator {
    private static StaffReader staffReader;

    public String getHtmlPage(){
        List<String> staffList = staffReader.getStaffList();

        // Début de page
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n";

        // Contenu = Liens vers les fiches agent
        htmlContent += "<ul>\n";
        for(String staffName : staffList){
            Agent agent = new Agent(staffName);
            htmlContent += "<li><a href=\"agents/"+agent.getLogin()+".html\">"+agent.getNom()+" "+agent.getPrenom()+"</a></li>\n";
        }
        htmlContent += "</ul>";

        // Fin de page
        htmlContent += "</body>\n" +
                "</html>";

        return htmlContent;
    }
}
