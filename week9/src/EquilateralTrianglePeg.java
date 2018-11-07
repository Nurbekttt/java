public class EquilateralTrianglePeg {
    private double side;
    EquilateralTrianglePeg(double s){
        this.side=s;
    }

    public double getSide() {
        return side;
    }
    public double getArea(){
        return Math.sqrt(3)*side*side/4;
    }
}
