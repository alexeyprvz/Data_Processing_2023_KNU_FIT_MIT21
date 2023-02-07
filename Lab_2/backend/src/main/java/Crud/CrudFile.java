package Crud;

import Entity.Entity;
import FileIO.FileIO;
import FileIO.FileIOInterface;

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
}
