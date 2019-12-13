package poli;

public class FracPolinom {
    private Polinom numerator;
    private Polinom denominator;

    public FracPolinom(Polinom numerator, Polinom denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void render() {
        numerator.render();
        System.out.println("\n-------------------------------------------");
        denominator.render();
        System.out.println();
    }
}
