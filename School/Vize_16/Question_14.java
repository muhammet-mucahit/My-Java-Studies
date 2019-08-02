/*

14. Aşağıda verilen K sınıfı tanımlamasına göre,
new K().k()
çağrımının göstereceği veriyi belirleyiniz. (10p)

 class K {
    int x = 0;
    public K() { x = 1; }
    public K(K k) { k.x = 2; }
    public void k() {
        x = 3;
        K k = new K(this);
        System.out.print(x + " " + k.x);
    }
 }

*/

class K {

    int x = 0;

    public K() { x = 1; }
    public K(K k) { k.x = 2; }

    public void k() {
        x = 3;
        K k = new K(this);
        System.out.print(x + " " + k.x);
    }
}

public class Question_14 {
    public static void main(String[] args) {
        new K().k();
    }
}
