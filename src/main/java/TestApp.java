import poli.Polinom;

public class TestApp {
    public static void main(String[] args) {
        Polinom a0 = new Polinom();
        a0.addElement(0, 1);

        Polinom b0 = new Polinom();
        b0.addElement(1, -3);

        Polinom c0 = new Polinom();
        c0.addElement(2, 2);

        System.out.print('(');
        a0.render();
        System.out.print(")L^2+(");
        b0.render();
        System.out.print(")L+(");
        c0.render();
        System.out.println(')');

        Polinom d = new Polinom();
        d = a0.multiply(c0);
        d = d.multToScalar(-4);
        d = d.add(b0.multiply(b0));
        d.render();
        System.out.println();
        d = d.sqrt();
        d.render();

        Polinom y01 = (b0.multToScalar(-1).add(d.multToScalar(-1))).multToScalar(0.5);
        System.out.println();
        y01.render();

        Polinom y02 = (b0.multToScalar(-1).add(d)).multToScalar(0.5);
        System.out.println();
        y02.render();

//        Polinom y11 = b0.multToScalar(-1).multiply(y01).add()

    }
}
