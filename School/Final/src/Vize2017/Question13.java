package Vize2017;

import java.util.Random;

class S {
    S s;
    int n;
    public S(int d) {
        if (d == 0) return;
        s = new S(d - 1);
        n = new Random().nextInt(100);
    }
}

public class Question13 {
    public static void main(String args[]) {
        S s = new S(10);
        System.out.println(tSum(s));
    }

    public static int tSum(S s) {
        return s == null ? 0 : s.n + tSum(s.s);
    }
}
