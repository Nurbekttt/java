public class Test {
    public static void main(String[] args) {
        RoundHole q = new RoundHole(10);
        RoundPeg z= new AdapterSquare(new SquarePeg(21));
        System.out.println(q.fits(z));
        RoundPeg tr = new AdapterTR(new EquilateralTrianglePeg(3));
        System.out.println(q.fits(tr));
        System.out.println(q.freeSpace(tr));
    }
}
