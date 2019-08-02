package Final2016;

class E { }

class P extends E {
    E a, b;
    public P(E x, E y) { a = x; b = y; }
}

class S extends E {
    E a, b;
    public S(E x, E y) { a = x; b = y; }
}

class R extends E {
    double r;
    public R(double x) { r = x; }
}

public class Question12 {
    public static void main(String[] args) {
        E e = new S(new R(2), new P(new R(4), new S(new R(3), new R(5))));

        System.out.println(esdir(e));
    }

    public static double esdir(E e) {

        if (e instanceof R) {
            return ((R) e).r;
        }
        else if (e instanceof S) {
            return esdir(((S) e).a) + esdir(((S) e).b);
        }
        else if (e instanceof P){
            return (esdir(((P) e).a) * esdir(((P) e).b)) / (esdir(((P) e).a) + esdir(((P) e).b));
        }

        return 0;
    }
}
