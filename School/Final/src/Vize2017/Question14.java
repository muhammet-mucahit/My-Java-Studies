package Vize2017;

class M {
    M m;
    static int n = 0;
    public M(M x) {
        m = x;
        while (x != null) {
            n += 2;
            x = x.m;
        }
    }
}

public class Question14 {
    public static void main(String args[]) {
        M m = new M(new M(new M(new M(null))));
        System.out.println(m.n);
    }
}
