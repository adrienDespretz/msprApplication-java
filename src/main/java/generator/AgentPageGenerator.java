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
                "</head>\n" +
                "<body>\n";

        // Contenu = Infos des agents
        htmlContent += "<h3>"+agent.getNom()+" "+agent.getPrenom()+"</h3>\n";
        htmlContent += "<h4>"+agent.getPoste()+"</h4>\n";

        // Carte d'identité
        htmlContent += "<img alt=\"Photo d'identité\" src=\""+agent.getImgUrl()+"\"><br>\n";

        // Lise du matériel
        htmlContent += "Liste du matériel : \n";
        htmlContent += "<ul>\n";
        for(String materiel : listeMateriel){
            htmlContent += "<li>"+materielArray.get(materiel)+"</li>\n";
        }
        htmlContent += "</ul>\n";

        // Fin de page
        htmlContent += "</body>\n" +
                "</html>";

        return htmlContent;
    }
}
