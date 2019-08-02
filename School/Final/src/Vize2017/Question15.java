package Vize2017;

abstract class Exp {
    public abstract int eval();
}

class Or extends Exp {
    Exp a, b;
    public Or(Exp x, Exp y) { a = x; b = y; }

    @Override
    public int eval() { return (a.eval() + b.eval()  > 0 ? 1 : 0); }
}

class And extends Exp {
    Exp a, b;
    public And(Exp x, Exp y) { a = x; b = y; }

    @Override
    public int eval() { return (a.eval() * b.eval() > 0 ? 1 : 0); }
}

class N extends Exp {
    int n;
    public N(int x) { n = x;}

    @Override
    public int eval() { return (n > 0 ? 1 : 0); }
}


public class Question15 {
    public static void main(String args[]) {
        Exp e = new Or(new Or(new N(2),
                new And(new N(3),new N(4))),
                new N(5));

        System.out.println(e.eval());
    }
}
