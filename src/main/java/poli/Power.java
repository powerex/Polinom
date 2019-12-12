package poli;

public class Power {
    public int power;
    public double coeficient;

    public Power(int power, double coeficient) {
        this.power = power;
        this.coeficient = coeficient;
    }

    public void render(boolean withPlus) {
        if (coeficient < 0)
            System.out.print('-');
        else if (withPlus)
            System.out.print('+');
        if (Math.abs(coeficient) != 1)
            System.out.print(Math.abs(coeficient));
        if (power != 0)
            System.out.print('x');
        if (power != 1 && power != 0)
            System.out.print("^" + power);
    }

    public void render() {
        render(true);
    }
}
