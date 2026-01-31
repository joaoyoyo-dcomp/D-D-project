package rpg.utils;
import java.util.Random;

public class Dado {
    private static Random gerador = new Random();
    public static int rolar(int faces) {
        return gerador.nextInt(faces) + 1;
    }

    public static int d20() { return rolar(20); }
    public static int d12() { return rolar(12); }
    public static int d10() { return rolar(10); }
    public static int d8()  { return rolar(8); }
    public static int d6()  { return rolar(6); }
    public static int d4()  { return rolar(4); }
}
