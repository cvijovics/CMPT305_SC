package lab2;
import java.util.Objects;

public class GeoLocation {
    private final double latitude;
    private final double longitude;

    public GeoLocation(String[] singleData)
    {
        this.latitude = Double.parseDouble(singleData[16]);
        this.longitude = Double.parseDouble(singleData[17]);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString(){
        return "(" + latitude + ", " + longitude + ")";
    }

    @Override
    public int hashCode(){
        return Objects.hash(latitude, longitude);
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof GeoLocation geolocationOther)) return false;

        return (this.latitude == geolocationOther.getLatitude() &&
                this.longitude == geolocationOther.getLongitude());
    }
}
