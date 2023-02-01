package Entity;

public class Entity {
    private String name;
    private String img;

    public Entity(String name, String img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "{" + "\"name\": \"" + name + "\"" + ", \"image\": " + img + "}";
    }
}
