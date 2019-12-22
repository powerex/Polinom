import poli.FracPolinom;
import poli.Polinom;

public class TestApp {
    public static void main(String[] args) {
        Polinom a0 = new Polinom();
        a0.addElement(0, 1);
        System.out.print("a0 = ");
        a0.render();

        Polinom b0 = new Polinom();
        b0.addElement(1, -3);
        System.out.println();
        System.out.print("b0 = ");
        b0.render();

        Polinom c0 = new Polinom();
        c0.addElement(2, 2);
        System.out.println();
        System.out.print("c0 = ");
        c0.render();

        Polinom a1 = new Polinom();
        a1.addElement(1, 1);
        System.out.println();
        System.out.print("a1 = ");
        a1.render();

        Polinom b1 = new Polinom();
        b1.addElement(0, 5);
        System.out.println();
        System.out.print("b1 = ");
        b1.render();


        System.out.println();
        System.out.println("\nCharacteristic equation");
        System.out.print('(');
        a0.render();
        System.out.print(")L^2+(");
        b0.render();
        System.out.print(")L+(");
        c0.render();
        System.out.println(')');

        Polinom d = a0.multiply(c0);
        d = d.multToScalar(-4);
        d = d.add(b0.multiply(b0));
        System.out.print("D = ");
        d.render();
        System.out.println();
        d = d.sqrt();
        System.out.print("sqrt(D) = ");
        d.render();

        Polinom y01 = (b0.multToScalar(-1).add(d)).multToScalar(0.5);
        System.out.println();
        System.out.print("y0(1) = ");
        y01.render();

        Polinom y02 = (b0.multToScalar(-1).add(d.multToScalar(-1))).multToScalar(0.5);
        System.out.println();
        System.out.print("y0(2) = ");
        y02.render();

        Polinom y01_prime = y01.getPrime();
        System.out.println();
        System.out.print("y0(1)` = ");
        y01_prime.render();

        Polinom y02_prime = y02.getPrime();
        System.out.println();
        System.out.print("y0(2)` = ");
        y02_prime.render();

        Polinom y11_num = b1.multToScalar(-1).multiply(y01).
                add(a1.multToScalar(-1).multiply(y01).multiply(y01)).
                add(y01.getPrime());

        Polinom y11_denom = b0.add(a0.multiply(y01).multToScalar(2));
        FracPolinom y11 = new FracPolinom(y11_num, y11_denom);

        System.out.println();
        System.out.println("\n\t\ty1:");
        y11.render();

        Polinom y12_num = b1.multToScalar(-1).multiply(y02).
                add(a1.multToScalar(-1).multiply(y02).multiply(y02)).
                add(y02.getPrime());

        Polinom y12_denom = b0.add(a0.multiply(y02).multToScalar(2));

        FracPolinom y12 = new FracPolinom(y12_num, y12_denom);

        System.out.println();
        System.out.println("\t\ty2:");
        y12.render();



    }
}

