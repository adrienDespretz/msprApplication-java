package readers;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaterielReader {
    public static Map<String, String> materielList;

    public static Map<String, String> getMaterielList(){
        materielList = new HashMap<String, String>();

        String txtStaff = getTextFromGithub("https://raw.githubusercontent.com/adrienDespretz/msprApplication-ressources/master/liste.txt");
        List<String> tmpMaterielIndexList = Arrays.asList(txtStaff.split("\n"));
        List<String> tmpMaterielName = Arrays.asList(txtStaff.split("\n"));

        int cpt = 0;
        for(String materiel : tmpMaterielIndexList){
            int index = materiel.indexOf(' ');
            String materielIndex = materiel.substring(0, index);
            String materielName = materiel.substring(index + 1, materiel.length());
            tmpMaterielIndexList.set(cpt, materielIndex);
            tmpMaterielName.set(cpt, materielName);

            materielList.put(tmpMaterielIndexList.get(cpt), tmpMaterielName.get(cpt));
            cpt++;
        }

        return materielList;
    }

    public static String getTextFromGithub(String link) {
        URL url = null;
        try {
            url = new URL(link);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        HttpURLConnection http = null;
        try {
            http = (HttpURLConnection) url.openConnection();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Map<String, List<String>> Header = http.getHeaderFields();

        for (String header : Header.get(null)) {
            if (header.contains(" 302 ") || header.contains(" 301 ")) {
                link = Header.get("Location").get(0);
                try {
                    url = new URL(link);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    http = (HttpURLConnection) url.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Header = http.getHeaderFields();
            }
        }
        InputStream stream = null;
        try {
            stream = http.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String response = null;
        try {
            response = GetStringFromStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private static String GetStringFromStream(InputStream stream) throws IOException {
        if (stream != null) {
            Writer writer = new StringWriter();

            char[] Buffer = new char[2048];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
                int counter;
                while ((counter = reader.read(Buffer)) != -1) {
                    writer.write(Buffer, 0, counter);
                }
            } finally {
                stream.close();
            }
            return writer.toString();
        } else {
            return "No Contents";
        }
    }
}
