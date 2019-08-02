package Vize2016;

// My Solution
//class M {
//    int n;
//
//    public M(int x) { n = x; }
//    public int getN() { return n; }
//
//    public M add(int x) {
//        this.n += x;
//        return this;
//    }
//}

// Teacher's Solution
class M {
    int n;

    public M(int x) { n = x; }
    public int getN() { return n; }

    public M add(int x) {
        return new M(n + x);
    }
}

public class Question11 {
    public static void main(String[] args) {
        System.out.println(new M(1).add(3).add(5).add(4).getN());
    }
}
