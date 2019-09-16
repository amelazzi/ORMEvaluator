package DAL.MySQL;


import DAL.Common.PublicationAbstract;
import DAL.Common.WallAbstract;

import java.util.ArrayList;
import java.util.List;

public class Wall extends WallAbstract {
    private int id;
    private String description;
    private int wallType;
    private List<Publication> publications = new ArrayList<Publication>(0);

    public Wall(int id, String description, int wallType) {
        this.id = id;
        this.description = description;
        this.wallType = wallType;
    }

    public Wall() {super();}

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description=description;
    }

    @Override
    public List<PublicationAbstract> getPublications() {
        List<PublicationAbstract>publicationAbstracts = new ArrayList<PublicationAbstract>(0);
        for (Publication publication: this.publications){
            publicationAbstracts.add(publication);
        }
        return publicationAbstracts;
    }

    @Override
    public void setPublications() {
        for (PublicationAbstract publicationAbstract: publications){
            this.publications.add((Publication) publicationAbstract);
        }
    }

}
