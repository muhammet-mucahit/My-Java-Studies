package Vize2016;

// My Solution
//class T {
//
//    int i = 1;
//    public T() { }
//    public T(T otherObject) { this.i += otherObject.i; }
//    public int d() { return i; }
//}

// Teacher's Solution
class T {
    static int x = 0;
    public T() { this(null); }
    public T(T t) { x++; }
    public int d() { return x; }
}

public class Question12 {
    public static void main(String[] args) {
        System.out.println(new T().d());
        System.out.println(new T(new T()).d());
        System.out.println(new T(new T(new T())).d());
        System.out.println(new T(new T(new T(new T()))).d());
        System.out.println(new T(new T(new T(new T(new T())))).d());
        System.out.println(new T(new T(new T(new T(new T(new T()))))).d());
    }
}
