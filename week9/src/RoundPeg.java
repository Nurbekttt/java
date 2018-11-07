public class RoundPeg {
    private double radius;
    AdapterSquare adapterSquare;
    RoundPeg(){
    }
    RoundPeg(double r){
        this.radius=r;
    }

    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
}
