package poli;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Polinom {
    private static double EPS = 1e-5;
    private Map<Integer, Double> polinom;

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
            result.addElement(key-1, value * key);
        });

        result.polinom.entrySet().removeIf(e -> e.getKey() < 0);

        return result;
    }
}
