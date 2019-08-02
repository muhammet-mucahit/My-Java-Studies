package Vize2017;

import java.util.Random;

class T {
    T t;
    int n;
    public T(int d) {
        if (d == 0) return;
        t = new T(d - 1);
        n = new Random().nextInt(100);
    }
}

public class Question12 {
    public static void main(String args[]) {
        System.out.println(new T(10).t.t.t.t.n);
    }
}
