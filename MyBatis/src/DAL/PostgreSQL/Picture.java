package DAL.PostgreSQL;

public class Picture extends Publication {
    private String name;
    private String extension;

    public Picture(){super();}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
