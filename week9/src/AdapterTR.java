public class AdapterTR extends RoundPeg{
    private EquilateralTrianglePeg equilateralTrianglePeg;
    AdapterTR(EquilateralTrianglePeg e){
        this.equilateralTrianglePeg=e;
    }

    @Override
    public double getRadius() {
        return equilateralTrianglePeg.getSide()/Math.sqrt(3);
    }

    @Override
    public double getArea() {
        return equilateralTrianglePeg.getArea();

    }
}
