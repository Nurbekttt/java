public class RoundHole {
    private double radius;

    RoundHole(double r){
        this.radius=r;

    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
    public double getRadius() {
        return radius;
    }
    public boolean fits(RoundPeg r){
        if(this.radius>r.getRadius()){
            return true;
        }
        return false;
    }
    public double freeSpace(RoundPeg r){
        return this.getArea()-r.getArea();

    }
}
