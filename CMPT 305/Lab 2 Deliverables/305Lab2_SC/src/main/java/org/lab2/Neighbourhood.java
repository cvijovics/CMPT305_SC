package lab2;

import java.util.Objects;

public class Neighbourhood {
    private final String name;
    private final String ward;
    private final Integer id;

    public Neighbourhood(String[] singleData)
    {
        this.name = singleData[5];
        this.ward = singleData[6];
        if(singleData[6] == null || singleData[6].trim().isEmpty())
        {
            this.id = null;
        } else {
            this.id = Integer.parseInt(singleData[4]);
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getWard() {
        return ward;
    }

    @Override
    public String toString(){
        if (ward != null)
            return name + " (" + ward + " Ward)";
        else
            return name;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, ward, id);
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Neighbourhood neighbourhoodOther)) return false;

        return (this.id == neighbourhoodOther.getId() &&
                Objects.equals(this.name, neighbourhoodOther.getName()) &&
                Objects.equals(this.ward, neighbourhoodOther.getWard()));
    }
}
