package Crud;

import Entity.Entity;
import FileIO.FileIO;
import FileIO.FileIOInterface;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CrudFile implements CrudInterface{

    FileIOInterface fio;

    public CrudFile(){
        this.fio = new FileIO();
    }
    @Override
    public Entity readEntity() {
        return (Entity) fio.loadFromFile();
    }

    @Override
    public void updateEntity(Entity entity) {
        fio.saveToFile(entity);
    }

    public static JsonElement bodyParse(HttpServletRequest request) {
        JsonElement jsonElement=null;

        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        return jsonElement;
    }

    @Override
    public Entity grenadeParse(HttpServletRequest request) {
        Entity grnd = new Entity();
        JsonElement jsonElement = bodyParse(request);
        grnd.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        grnd.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        grnd.setImg(jsonElement.getAsJsonObject().get("img").getAsString());
        grnd.setType(jsonElement.getAsJsonObject().get("type").getAsString());
        grnd.setWeight(jsonElement.getAsJsonObject().get("weight").getAsInt());
        return grnd;
    }

    public int getNextId(List<Entity> list) {
        int maxId = 0;

        Iterator<Entity> iterator = list.iterator();
        while(iterator.hasNext()) {
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }

    public int getIndexByGrenadeId(int id, List<Entity> list) {
        int listId = id;

        Iterator<Entity> iterator = list.iterator();
        while(iterator.hasNext()) {
            Entity temp =iterator.next();
            if(temp.getId()==listId) {
                listId=list.indexOf(temp);
                break;
            }
        }
        return listId;
    }

}
