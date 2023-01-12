import junit.framework.Assert;
import org.junit.Test;
import readers.AgentReader;
import readers.MaterielReader;
import readers.StaffReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadersTest {
    private static StaffReader staffReader;
    private static MaterielReader materielReader;
    private static AgentReader agentReader;

    @Test
    public void should_GetListOfStaffInAlphabeticalOrderFromFile() {
        List<String> listOfExpectedStaff = Arrays.asList("adespretz","apouton","aschollick","bstinson","bswaffer","btrazzi","cfleeming","cgrob","dcastellaccio","eamieva","ebooton","eboulter","ebratcher","ewilse","fride","gcartlidge","gjedraszczyk","glailey","gzorener","hatcock","hesselen","hteodorski","ijessup","jkubicki","klassen","lbalch","lfessions","lloch","lmatthiae","ltoffanelli","mbraznell","mcabrales","mcastle","mfildery","moverlow","mpetris","msenogles","ploblie","ppieracci","rchevalier","rdigiorgio","rduinbleton","schallener","skubek","spavlovic","sromer","staffrey","taeth","tandries","tdemougeot","trough","ufrancois","vbradburn","wdevennie","zthatcher");
        List<String> listOfStaffFromFile = staffReader.getStaffList();
        Assert.assertEquals(listOfExpectedStaff, listOfStaffFromFile);
    }

    @Test
    public void should_GetListOfMaterielFromFile() {
        Map<String, String> expectedMaterielList;
        expectedMaterielList = new HashMap<String, String>();

        expectedMaterielList.put("mousqueton","Mousqueton");
        expectedMaterielList.put("gants","Gants d'intervention");
        expectedMaterielList.put("brassard","Brassard de sécurité");
        expectedMaterielList.put("menottes","Porte menottes");
        expectedMaterielList.put("cyno","Bandeau agent cynophile");
        expectedMaterielList.put("talky","Talkies walkies");
        expectedMaterielList.put("lampe","Lampe Torche");
        expectedMaterielList.put("kit","Kit oreillette");
        expectedMaterielList.put("taser","Tasers");
        expectedMaterielList.put("lacrymo","Bombes lacrymogènes");
        expectedMaterielList.put("pc","Ordinateurs");

        Map<String, String> actualMaterielList;
        actualMaterielList = new HashMap<String, String>();

        actualMaterielList = materielReader.getMaterielList();

        Assert.assertEquals(expectedMaterielList, actualMaterielList);
    }

    @Test
    public void should_GetListOfAgentInfosFromFile() {
        List<String> listOfExpectedAgentInfos = Arrays.asList("Adrien", "Despretz", "Agent", "JhrU5I", "", "kit", "brassard", "talky", "taser", "cyno", "gants");
        List<String> listOfAgentInfosFromFile = agentReader.getAgentInfos("adespretz");
        Assert.assertEquals(listOfExpectedAgentInfos, listOfAgentInfosFromFile);
    }
}
