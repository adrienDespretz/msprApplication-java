package objects;

import readers.AgentReader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Agent {
    public static String login;
    public static String nom;
    public static String prenom;
    public static String poste;
    public static String password;
    public static List<String> listeMateriel;
    public static String imgUrl;

    public Agent(String staffName){
        AgentReader agentReader = new AgentReader();
        List<String> agentInfos = agentReader.getAgentInfos(staffName);


        this.login = staffName;
        this.nom = agentInfos.get(0);
        this.prenom = agentInfos.get(1);
        this.poste = agentInfos.get(2);
        this.password = agentInfos.get(3);
        this.listeMateriel = agentInfos.subList(5, agentInfos.size());
        this.imgUrl = "https://raw.githubusercontent.com/adrienDespretz/msprApplication-ressources/master/data/"+staffName+".jpg";
    }

    public static String getLogin() {
        return login;
    }

    public static String getNom() {
        return nom;
    }

    public static String getPrenom() {
        return prenom;
    }

    public static String getPoste() {
        return poste;
    }

    public static String getPassword() {
        return password;
    }

    public static List<String> getListeMateriel() {
        return listeMateriel;
    }

    public static String getImgUrl() {
        return imgUrl;
    }
}
