package engineering;

import java.util.Random;

public class InsecureRandomExample {

    public int getRandomInt() {
        Random rnd = new Random();
        return rnd.nextInt();
    }

    public double getSecureRandomDouble() {
        return Math.random();
    }
}