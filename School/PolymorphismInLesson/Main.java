abstract class Exp {
    public abstract int eval();
    public abstract Exp copy();
}

class Plus extends Exp {

    Exp a, b;
    public Plus(Exp x, Exp y) {
        a = x;
        b = y;
    }

    @Override
    public int eval() {
        return a.eval() + b.eval();
    }

    @Override
    public Exp copy() {
        return new Plus(a.copy(), b.copy());
    }
}

class Minus extends Exp {

    Exp a, b;
    public Minus(Exp x, Exp y) {
        a = x;
        b = y;
    }

    @Override
    public int eval() {
        return a.eval() - b.eval();
    }

    @Override
    public Exp copy() {
        return new Minus(a.copy(), b.copy());
    }
}

class Times extends Exp {

    Exp a, b;
    public Times(Exp x, Exp y) {
        a = x;
        b = y;
    }

    @Override
    public int eval() {
        return a.eval() * b.eval();
    }

    @Override
    public Exp copy() {
        return new Times(a.copy(), b.copy());
    }
}

class Divide extends Exp {

    Exp a, b;
    public Divide(Exp x, Exp y) {
        a = x;
        b = y;
    }

    @Override
    public int eval() {
        return a.eval() / b.eval();
    }

    @Override
    public Exp copy() {
        return new Divide(a.copy(), b.copy());
    }
}

class Num extends Exp {

    int n;
    public Num(int x) { n = x; }

    @Override
    public int eval() {
        return n;
    }

    @Override
    public Exp copy() {
        return new Num(n);
    }
}

public class Main {
    public static void main(String[] args) {
        Exp e = new Plus(new Minus(new Times(new Num(3), new Num(4)), new Divide(new Num(10), new Num(6))), new Num(5));
        Exp copy = e.copy();
        System.out.println(copy.eval());
    }
}
