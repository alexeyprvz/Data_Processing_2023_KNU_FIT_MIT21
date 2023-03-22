package entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="granades")
public class GrndEntity {

    //private static final long serialVersionUID = 1L;
    @Id
    private int id;
    private String name;
    private String img;
    private String type;
    private int weight;

    public GrndEntity(int id, String name, String img, String type, int weight) {
        super();
        this.id = id;
        this.name = name;
        this.img = img;
        this.type = type;
        this.weight = weight;
    }

    public GrndEntity() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{\"id\": "+id+",\"name\": \""+name+"\",\"img\":\""+img+"\", \"type\":\""+type+"\", \"weight\":"+weight+"}";
    }
}
