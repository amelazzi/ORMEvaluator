package DAL.Entities.MySQL;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "video")
@PrimaryKeyJoinColumn(name = "publicationid", referencedColumnName = "id")
public class Video extends Publication {
    private String name;
    private String extension;

    public Video(){super();}

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
