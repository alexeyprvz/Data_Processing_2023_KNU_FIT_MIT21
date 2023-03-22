package crud;

import entity.GrndEntity;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CrudFile{

    public static JsonElement bodyParse(HttpServletRequest request) {
        JsonElement jsonElement=null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }



    public static GrndEntity grenadeParse(HttpServletRequest request) {
        GrndEntity grnd = new GrndEntity();
        JsonElement jsonElement = bodyParse(request);
        grnd.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        grnd.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        grnd.setImg(jsonElement.getAsJsonObject().get("img").getAsString());
        grnd.setType(jsonElement.getAsJsonObject().get("type").getAsString());
        grnd.setWeight(jsonElement.getAsJsonObject().get("weight").getAsInt());
        return grnd;
    }

    public static int getNextId(List<GrndEntity> list) {
        int maxId = 0;

        Iterator<GrndEntity> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }

    public static int getIndexByGrenadeId(int id, List<GrndEntity> list) {
        int listId = id;

        Iterator<GrndEntity> iterator = list.iterator();
        while(iterator.hasNext()) {
            GrndEntity temp =iterator.next();
            if(temp.getId()==listId) {
                listId=list.indexOf(temp);
                break;
            }
        }
        return listId;
    }

}
