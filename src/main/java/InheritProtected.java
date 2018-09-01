class K {
    int k1 = 100;
}
class K1 extends K {
}

public class InheritProtected {
    public static void main(String args[]) {
        System.out.println(new K().k1);
        System.out.println(new K1().k1);
        System.out.printf("Hello");
    }
}
