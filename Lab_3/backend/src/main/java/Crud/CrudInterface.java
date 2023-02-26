package Crud;

import Entity.Entity;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CrudInterface {
    public Entity readEntity();
    public void updateEntity(Entity entity);
    Entity grenadeParse(HttpServletRequest request);
    int getIndexByGrenadeId(int id, List<Entity> lu);
    int getNextId(List<Entity> lu);
}
