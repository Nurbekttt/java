public class Car {
    String status;
    boolean moving;
    boolean q;
    Gearbox GearBox;
    public Car(){
        this.GearBox = new Park(false,false);
        moving = false;
        this.GearBox=new Park(false,false);

    }

    public void setGear(Gearbox GGG){
        if(this.GearBox.getBreaking()){
            this.GearBox=GGG;
        }
    }

    public String getStatus() {
        return status;
    }
}
