package lab2;

import java.util.Objects;

public class PropertyAssessment implements Comparable<PropertyAssessment>{
    private final Integer accountNum;
    private final Address address;
    private final GeoLocation geolocation;
    private final Neighbourhood neighbourhood;
    private final AssessmentClass assessment;
    private final boolean hasGarage;
    private final String taxClass;
    private final Integer value;

    public PropertyAssessment(String[] singleData)
    {
        this.accountNum = Integer.parseInt(singleData[0]);
        this.address = new Address(singleData);
        this.geolocation = new GeoLocation(singleData);
        this.neighbourhood = new Neighbourhood(singleData);
        this.assessment = new AssessmentClass(singleData);
        this.hasGarage = singleData[9].equals("Y");
        this.taxClass = singleData[8];
        this.value = Integer.parseInt(singleData[7]);
    }

    public Integer getValue() {
        return value;
    }

    public Integer getAccountNum() {
        return accountNum;
    }

    public Address getAddress() {
        return address;
    }

    public boolean getHasGarage() {
        return hasGarage;
    }

    public AssessmentClass getAssessment() {
        return assessment;
    }

    public GeoLocation getGeolocation() {
        return geolocation;
    }

    public String getTaxClass() {
        return taxClass;
    }

    @Override
    public String toString(){
        return "Account Number: " + accountNum;
    }

    public boolean equals(PropertyAssessment other){
        return this.accountNum.equals(other.accountNum);
    }

    @Override
    public int hashCode(){
        return Objects.hash(accountNum);
    }

    public Neighbourhood getNeighbourhood() { return neighbourhood; }

    @Override
    public int compareTo(PropertyAssessment other) {
        return this.value.compareTo(other.value);
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof PropertyAssessment propertyAssessmentOther)) return false;

        return (Objects.equals(this.accountNum, propertyAssessmentOther.getAccountNum()));
    }
}
