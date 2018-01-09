import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jdk.nashorn.api.scripting.URLReader;
import model.CoBuildings;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Path("/codata")
public class CoDataService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getCoData() {
        URL url = null;
        try {
            url = new URL("https://data.sfgov.org/resource/y2ju-xyjc.json");
            BufferedReader br = new BufferedReader(new URLReader(url));
            String line;
            StringBuilder allLines = new StringBuilder();
            StringBuilder retval = new StringBuilder();
            List<CoBuildings> datalist = new ArrayList<>();
            GsonBuilder builder = new GsonBuilder();
            Gson gs = builder.create();
            while((line=br.readLine())!=null){
                allLines.append(line);
            }
            CoBuildings[] cobuild = gs.fromJson(allLines.toString(), CoBuildings[].class);

            for (int i = 0; i< cobuild.length; i++){
                if(!"0".equals(cobuild[i].getEmissions_mtco2e())){
                    datalist.add(cobuild[i]);
                }
            }

            String ret = gs.toJson(datalist);

            return ret;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException iox){
            iox.printStackTrace();
        }
        return null;

    }
}
