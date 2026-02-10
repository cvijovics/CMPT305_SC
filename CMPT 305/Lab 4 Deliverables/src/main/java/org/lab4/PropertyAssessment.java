package org.lab4;

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

    public Neighbourhood getNeighbourhood() { return neighbourhood; }

    @Override
    public String toString(){
        return "Account Number: " + accountNum;
    }

    @Override
    public int hashCode(){
        return Objects.hash(accountNum);
    }

    @Override
    public int compareTo(PropertyAssessment other) {
        return this.value.compareTo(other.value);
    }

    @Override
    public boolean equals(Object other){
        if (other == this) return true;
        if (!(other instanceof PropertyAssessment propertyAssessmentOther)) return false;

        return (Objects.equals(this.accountNum, propertyAssessmentOther.getAccountNum()));
    }
}
