package uva;

import java.util.Scanner;

import static java.lang.System.in;

public class SearchingForNessy {
    public static void main(String args[]) {
        Scanner sc = new Scanner(in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println((a/3) * (b/3));
        }
    }
}
