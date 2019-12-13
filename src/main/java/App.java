import poli.Polinom;

public class App {
    public static void main(String[] args) {
        /*
        Polinom p1 = new Polinom();
        p1.addElement(1, -1);
        p1.addElement(0, 2);

        Polinom p2 = new Polinom();
        p2.addElement(1, 1);
        p2.addElement(0, -2);

        Polinom p3 = p1.multiply(p2);
        p3.render();

        System.out.println();
        p3 = p3.getPrime();
        p3.render();
        //*/

        Polinom p4 = new Polinom();
        p4.addElement(2, 9);
        p4.addElement(1, 30);
        p4.addElement(0, 25);
        p4.render();
        System.out.println();

        Polinom p5 = p4.sqrt();
        if (p5 != null)
            p5.render();

    }
}
