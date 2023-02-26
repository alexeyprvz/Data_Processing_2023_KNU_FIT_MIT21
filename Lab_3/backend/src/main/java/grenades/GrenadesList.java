package grenades;

import Entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class GrenadesList {

    private List<Entity> grenadesList = new ArrayList<>();

    public GrenadesList(){
        this.grenadesList.add(new Entity(0, "Something1", "1.jpg", "Smtth1", 11));
        this.grenadesList.add(new Entity(1, "Something2", "1.jpg", "Smtth2", 12));
        this.grenadesList.add(new Entity(2, "Something3", "1.jpg", "Smtth3", 13));
    }

    public List<Entity> getGrenadesList() {
        return grenadesList;
    }

    public void setGrenadesList(List<Entity> grenadesList) {
        this.grenadesList = grenadesList;
    }
}
