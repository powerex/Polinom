package poli;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Polinom {
    private static double EPS = 1e-5;
    private Map<Integer, Double> polinom;

    private double getKoeficient(int power) {
        if (polinom.get(power) != null)
            return polinom.get(power);
        else
            return 0.0;
    }

    private int getMaxPower() {
        return Collections.max(polinom.keySet());
    }

    public Polinom() {
        polinom = new HashMap<>();
    }

    public void addElement(Power p) {
        polinom.put(p.power, p.coeficient);
    }

    public void addElement(int power, double coeficient) {
        polinom.put(power, coeficient);
    }

    public void render() {
        if (polinom.isEmpty()) {
            System.out.print('0');
        } else {
            int m = getMaxPower();
            Map<Integer, Double> tm = new TreeMap<>(polinom).descendingMap();
            tm.forEach((key, value) -> {
                Power p = new Power(key, value);
                p.render(m != key);
            });
        }
    }

    public Polinom multToScalar(double k) {
        Polinom result = new Polinom();
        polinom.forEach((key, value) -> {
            result.addElement(key, value*k);
        });
        result.polinom.entrySet().removeIf(e -> Math.abs(e.getValue()) < EPS);
        return result;
    }

    public Polinom add(Polinom that) {
        Polinom result = new Polinom();
        this.polinom.forEach((key, value) -> {
            result.addElement(key, value);
        });
        that.polinom.forEach((key, value) -> {
            if (result.polinom.containsKey(key)) {
                result.polinom.replace(key, that.polinom.get(key) + result.polinom.get(key));
            } else {
                result.addElement(key, value);
            }
        });
        return result;
    }

    public Polinom multiply(Polinom that) {
        Polinom result = new Polinom();
        this.polinom.forEach((key, value) -> that.polinom.forEach((key1, value1) -> {
            int power = key + key1;
            double k = value * value1;
            if (!result.polinom.containsKey(power)) {
                result.polinom.put(power, k);
            } else {
                result.polinom.put(power, result.polinom.get(power) + k);
            }
        }));

        result.polinom.entrySet().removeIf(e -> Math.abs(e.getValue()) < EPS);

        return result;
    }

    public Polinom getPrime() {
        Polinom result = new Polinom();
        polinom.forEach((key, value) -> {
            result.addElement(key - 1, value * key);
        });

        result.polinom.entrySet().removeIf(e -> e.getKey() < 0);

        return result;
    }

    public Polinom sqrt() {
        int m = getMaxPower();
        if (m % 2 == 1)
            return null;
        Polinom result = new Polinom();

        switch (m) {
            case 2:
                double a = getKoeficient(m);
                if (a < 0) return null;
                a = Math.sqrt(a);
                double b = getKoeficient(0);
                if (b < 0) return null;
                b = Math.sqrt(b);
                if (Math.abs(getKoeficient(1)) == 2 * a * b) {
                    result.addElement(1, a);
                    if (getKoeficient(1) < 0)
                        b *= -1;
                    result.addElement(0, b);
                }
                break;
            case 4:

                break;
        }

        result.polinom.entrySet().removeIf(e -> Math.abs(e.getValue()) < EPS);
        return result;
    }
}
