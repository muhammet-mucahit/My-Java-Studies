package Final2016;

// My Solution
//class T {
//
//    int i;
//
//    public T() {
//        i = 1;
//    }
//
//    public T(T otherObject) {
//        otherObject.i++;
//        i = otherObject.i;
//    }
//
//    public String toString() {
//        return String.valueOf(i);
//    }
//}

// Teacher's Solution
class T {

    T currentObject;

    public T() { }

    public T(T otherObject) {
        currentObject = otherObject;
    }

    public String toString() {
        return (1 + (currentObject == null ? 0 : Integer.parseInt(currentObject + ""))) + "";
    }
}

public class Question11 {
    public static void main(String[] args) {
        String a = new T() + "";
        String b = new T(new T()) + "";
        String c = new T(new T(new T())) + "";
        String d = new T(new T(new T(new T()))) + "";
        System.out.println(a + " " + b + " " + c + " " + d);
    }
}
