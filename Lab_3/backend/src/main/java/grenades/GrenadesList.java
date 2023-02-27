package grenades;

import Entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class GrenadesList {

    private List<Entity> grenadesList = new ArrayList<>();

    public GrenadesList(){
        this.grenadesList.add(new Entity(0, "РГ-42", "1", "ручна, осколкова, наступальної дії", 420));
        this.grenadesList.add(new Entity(1, "Ф-1", "2", "ручна, дистанційної дії", 60));
        this.grenadesList.add(new Entity(2, "М-61", "3", "ручна, оборонна", 450));
        this.grenadesList.add(new Entity(3, "M67", "4", "ручна, наступальна", 397));
        this.grenadesList.add(new Entity(4, "РГД-5", "5", "протипіхотна, уламкова, ручна, дистанційної дії, наступальна", 310));
        this.grenadesList.add(new Entity(5, "AN/M8", "6", "ручна, димова, отруйна", 680));
    }

    public List<Entity> getGrenadesList() {
        return grenadesList;
    }

    public void setGrenadesList(List<Entity> grenadesList) {
        this.grenadesList = grenadesList;
    }
}
