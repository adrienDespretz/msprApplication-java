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
                "  <link rel='stylesheet' href='https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@400;500;600;700&amp;display=swap'><link rel=\"stylesheet\" href=\"./style.css\">\n"+
                "</head>\n" +
                "<body>\n";

        // Contenu = Liens vers les fiches agent
        htmlContent += "<article class=\"leaderboard\">\n";
        htmlContent += " <header>\n";
        htmlContent += "<img src=\"gosecuri.png\" style=\"padding-top: 12px;\" class=\"\">\n";
        htmlContent += " <h1  class=\"leaderboard__title\"> <span class=\"leaderboard__title--top\">Personnel</span></h1>\n";
        htmlContent += " </header>\n";
        htmlContent += "  <main class=\"leaderboard__profiles\">\n";
        htmlContent += " <input id=\"searchbar\" onkeyup=\"search_personnel()\" type=\"text\" name=\"search\" placeholder=\"Ex : Pouton\">\n";
        for(String staffName : staffList){
            Agent agent = new Agent(staffName);
            htmlContent += " <a class=\"block\" href=\"agents/"+agent.getLogin()+".html\">";
            htmlContent += "<article class=\"leaderboard__profile\">\n";
            htmlContent += " <img src=\"id-card.png\" class=\"leaderboard__picture\">\n";
            htmlContent += " <span class=\"leaderboard__name\">"+agent.getNom()+" "+agent.getPrenom()+"</span>\n";
            htmlContent += "</article>";
            htmlContent += "</a>";
        }
        htmlContent += "</main>";
        htmlContent += "</article>";
        htmlContent += "<script src=\"./personnel.js\"></script>\n";

        htmlContent += "</body>\n" +
                "</html>";

        return htmlContent;
    }
}
