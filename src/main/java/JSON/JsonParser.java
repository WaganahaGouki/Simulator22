package JSON;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class JsonParser {
    URL lts;

    public URL getLts() {
        return lts;
    }

    public void setLts(URL lts) {
        this.lts = lts;
    }

    public void parsing(){
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("config.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject url = (JSONObject) obj;
            setLts((URL) url.get("ltsUrl"));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
