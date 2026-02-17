package ParkingSpot;

public class ParkingSpot {
    private String SpotId;
    private boolean isFree;
    public  ParkingSpot(String SpotId){
        this.SpotId = SpotId;
    }
    public boolean spotAvalaible(){
        return isFree;
    }
    public void unPark(){
        isFree=true;
        return;
    }

    public void park(){
        isFree=false;
        return;
    }

    public String getSpotId() {
        return SpotId;
    }

    public void setSpotId(String spotId) {
        SpotId = spotId;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }


}
