package readers;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AgentReader {
    public static List<String> staffInfos;

    public static List<String> getAgentInfos(String staffName){
        String txtStaff = getTextFromGithub("https://raw.githubusercontent.com/adrienDespretz/msprApplication-ressources/master/data/"+staffName+".txt");
        staffInfos = Arrays.asList(txtStaff.split("\n"));

        return staffInfos;
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
