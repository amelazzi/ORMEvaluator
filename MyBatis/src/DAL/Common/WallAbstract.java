package DAL.Common;


import java.util.List;


public abstract class WallAbstract {

    public WallAbstract(){}

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getDescription();

    public abstract void setDescription(String description);

    public abstract List<PublicationAbstract> getPublications();

    public abstract void setPublications();
}
