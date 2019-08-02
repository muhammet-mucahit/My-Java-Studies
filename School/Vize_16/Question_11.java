/*

11. Aşağıda tanımlaması verilen M sınıfı
System.out.println(new M(1).add(3).add(5).add(4).getN());
gibi kullanıldığında belirtilen tamsayıların toplamı olan 13
değerini göstermektedir. M sınıfının boş bırakılan kısmını
tamamlayınız. (10p)

class M {
 int n;
 public M(int x) { n = x; }
 public int getN() { return n; }
 .........
}

*/

class M {
    int n;
    public M(int x) { n = x; }
    public int getN() { return n; }
    public M add(int x) { return new M(n + x); }
}

public class Question_11 {
    public static void main(String[] args) {
        System.out.println(new M(1).add(3).add(5).add(4).getN());
    }
}
