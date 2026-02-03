package lab2;

import java.util.Objects;

public class Address {
    private final Integer houseNum;
    private final String streetName;
    private final String suite;

    public Address(String[] singleData)
    {
        if (singleData[2] == null || singleData[2].trim().isEmpty())
        {
            this.houseNum = null;
        } else {
            this.houseNum = Integer.parseInt(singleData[2]);
        }

        this.streetName = singleData[3];

        if (singleData[1] == null || singleData[1].trim().isEmpty()) {
            this.suite = null;
        }
        else {
            this.suite = singleData[1].trim();
        }

    }

    public int getHouseNum() {
        return houseNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuite() {
        if (suite != null)
            return suite;
        return null;
    }

    @Override
    public String toString(){
        if(suite != null)
            return suite + " " + houseNum + " " + streetName;
        else
            return houseNum + " " + streetName;
    }

    @Override
    public int hashCode(){
        return Objects.hash(houseNum, streetName, suite);
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Address otherAddress)) return false;
        return Objects.equals(otherAddress.getSuite(), this.getSuite()) &&
                otherAddress.getHouseNum() == this.getHouseNum() &&
                Objects.equals(otherAddress.getStreetName(), this.getStreetName());
    }

}
