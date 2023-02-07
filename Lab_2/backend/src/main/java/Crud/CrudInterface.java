package Crud;

import Entity.Entity;

public interface CrudInterface {
    public Entity readEntity();
    public void updateEntity(Entity entity);
}
