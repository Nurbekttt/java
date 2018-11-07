public class AdapterSquare extends RoundPeg{
    private SquarePeg squarePeg;
    AdapterSquare(SquarePeg s){
        this.squarePeg=s;
    }

    @Override
    public double getRadius() {
        return squarePeg.getWidth()*Math.sqrt(2)/2;
    }

    @Override
    public double getArea() {
        return squarePeg.getArea();
    }
}
