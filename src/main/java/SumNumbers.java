public class SumNumbers {
    public static int sumNumbers(String str) {
        Integer sum = 0;
        char [] k = str.toCharArray();
        int a = -1;
        int b = -1;
        for(int i =0; i<=k.length; i++) {
            if(i < k.length && Character.isDigit(k[i])) {
                if(a == -1)
                    a = i;
                else {
                    b = i;
                }
            } else {
                if(a != -1 && b != -1) {
                    sum += Integer.parseInt(str.substring(a, b+1));
                    a = -1;
                    b = -1;
                } else if(a != -1) {
                  sum += Integer.parseInt(str.substring(a, i));
                  a = -1;
                  b = -1;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumNumbers("7 11"));
    }
}
