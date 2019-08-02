/*

13. Aşağıdaki gibi kullanıldığında nesne derinliğini geri
döndüren T sınıfını tanımlayınız. (10p)

 new T().d(); //1 döndürür.
 new T(new T()).d(); //2 döndürür.
 new T(new T(new T())).d(); //3 döndürür.
 ........

*/

class T {

    static int deep = 0;

    public T() { this(null); }

    public T (T obj) { deep++; }

    public int d() {
        int temp = deep;
        deep = 0;
        return temp;
    }
}

public class Question_13 {
    public static void main(String[] args) {
        System.out.println( new T().d() ); // 1
        System.out.println( new T( new T() ).d() ); // 2
        System.out.println( new T( new T( new T() )).d() ); // 3
    }
}
