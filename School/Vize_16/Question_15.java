/*

15. Tamsayıları ve çıkarma işlecini içeren aritmetik ifadeler N
sınıfı ile temsil edilerek değerlendirilmek isteniyor. Örneğin,
3-5-2 ifadesinin temsili ve nasıl değerlendirildiği aşağıda
gösterilmiştir.

N n = new N(new Integer(3), new N(new Integer(5), new Integer(2)));
Integer m = (Integer)n.eval();
System.out.println(m.intValue());

Buna göre bir kısmı aşağıda tanımlanan N sınıfında boş
bırakılan eval() metodunu tamamlayınız. (10p)

 class N {
    Object a, b;
    public N(Object x, Object y) {
        a = x;
        b = y;
    }
    public Object eval() {
    ..............
    }
 }

*/

class N {

    Object a, b;

    public N(Object x, Object y) {
        a = x;
        b = y;
    }

    public Object eval() {
        int n;

        if (a instanceof N)
            a = ((N) a).eval();
        n = ((Integer) a).intValue();

        if (b instanceof N)
            b = ((N) b).eval();
        n -= ((Integer) b).intValue();

        return new Integer(n);
    }
}

public class Question_15 {
    public static void main(String[] args) {
        N n = new N(new Integer(3), new N(new Integer(5), new Integer(2)));
        Integer m = (Integer) n.eval();
        System.out.println(m.intValue());
    }
}
