package Vize2016;

class N {
    Object a, b;

    public N(Object x, Object y) {
        a = x;
        b = y;
    }

    // My Solution
//    public Object eval() {
//        if (a instanceof N && b instanceof Integer) {
//            return (Integer)((N) a).eval() - (Integer)b;
//        }
//        else {
//            return (Integer)a - (Integer)b;
//        }
//    }


    // Teacher's Solution
    public Object eval() {
        int n;
        if (a instanceof N) a = ((N) a).eval();
        n = ((Integer) a).intValue();
        if (b instanceof N) b = ((N) b).eval();
        n -= ((Integer) b).intValue();
        return new Integer(n);
    }
}

public class Question14 {
    public static void main(String[] args) {
        N n = new N(new N(new Integer(3), new Integer(5)), new Integer(2));
        Integer m = (Integer)n.eval();
        System.out.println(m.intValue());
    }
}
