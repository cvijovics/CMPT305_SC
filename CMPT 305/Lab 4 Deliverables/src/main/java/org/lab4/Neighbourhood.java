package org.lab4;

import java.util.Objects;

public class Neighbourhood {
    private final String name;
    private final String ward;
    private final Integer id;

    public Neighbourhood(String[] singleData)
    {
        this.name = singleData[5];
        if(singleData[6] == null || singleData[6].trim().isEmpty())
        {
            this.ward = null;
            this.id = null;
        } else {
            this.ward = singleData[6];
            this.id = Integer.parseInt(singleData[4]);
        }
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
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
        if (other == this) return true;
        if (!(other instanceof Neighbourhood neighbourhoodOther)) return false;

        return Objects.equals(this.id, neighbourhoodOther.getId());
    }
}
