package generator;

import objects.Agent;
import readers.MaterielReader;

import java.util.List;
import java.util.Map;

public class AgentPageGenerator {
    public static Agent agent;

    public AgentPageGenerator(String staffName){
        agent = new Agent(staffName);
    }

    public String getHtmlPage(){
        List<String> listeMateriel = agent.getListeMateriel();
        MaterielReader materielReader = new MaterielReader();
        Map<String, String> materielArray = materielReader.getMaterielList();

        // Début de page
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "  <link rel='stylesheet' href='https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@400;500;600;700&amp;display=swap'><link rel=\"stylesheet\" href=\"../style.css\">\n"+
                "</head>\n" +
                "<body>\n";

        // Contenu = Liens vers les fiches agent
        htmlContent += "<article class=\"leaderboard\">\n";
        htmlContent += " <header>\n";
        htmlContent += "<img src=\"../gosecuri.png\" style=\"padding-top: 12px;\" class=\"\">\n";
        htmlContent += " <h1  class=\"leaderboard__title\">";
        htmlContent += "<span class=\"leaderboard__title--top\">"+agent.getNom()+" "+agent.getPrenom()+"</span>\n";
        htmlContent += "<span class=\"leaderboard__title--top\">"+agent.getPoste()+"</span>\n";
        htmlContent += "</h1>\n";
        htmlContent += " </header>\n";

        htmlContent += " <main class=\"leaderboard__profiles\">\n";
        htmlContent += " <img src=\""+agent.getImgUrl()+"\" style=\"border-radius: 20px;\" >";
        htmlContent += " <div class=\"container\">\n";
        htmlContent += " <div class=\"row\">";
        htmlContent += " <div class=\"col-sm-offset-4 col-sm-4\">";
        htmlContent += "<div class=\"checkbox-list\">\n";

        for(String materiel : listeMateriel){
            htmlContent += "<div class=\"checkbox\">\n";
            htmlContent += "<img src=\"../check.png\" />\n";
            htmlContent += "<label class=\"leaderboard__name\">"+materielArray.get(materiel)+"!</label>\n";
            htmlContent += "</div>\n";
        }
        htmlContent += " </div>\n";
        htmlContent += " </div>\n";
        htmlContent += " </div>\n";
        htmlContent += " </div>\n";
        htmlContent += " </div>\n";
        htmlContent += " <form>\n";
        htmlContent += " <input class=\"button-19\" type=\"button\" value=\"Retour\" onclick=\"history.back()\">\n";
        htmlContent += " </form>\n";

        // Fin de page
        htmlContent += "</body>\n" +
                "</html>";

        return htmlContent;
    }
}
