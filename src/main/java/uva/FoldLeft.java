package uva;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

public class FoldLeft {

    public static <A> Vector<Vector<A>> sliding(Vector<A> c, Integer n) {
        int size = c.size();
        Vector<Vector<A>> v = new Vector<>(size - 1);
        for(int i = 0; i <= size - n; i++) {
            v.add(new Vector<>(c.subList(i, i+n)));
        }
        if(v.isEmpty()) {
            v.add(c);
            return v;
        }
        return v;
    }


    public static <A, B> B foldLeft(Stream<A> a, B z,
                                                      BiFunction<A, B, B> biFunction) {
        B b = z;
        List<A> l = a.parallel().collect(Collectors.toList());
        for(A e : l) {
            b = biFunction.apply(e, b);
        }
        return b;
    }

    public static void main(String args[]) {

        ArrayList<Integer> a = new ArrayList<>();
        for (int i  = 0; i<=10; i++) {
            a.add(i);
        }

        BiFunction<Integer, Integer, Integer> sumFunction = (b, c) -> b+c;
        out.println(foldLeft(a.stream(), 10, (b, c) -> b+c));
        out.println(sliding(new Vector<>(a), 22 ));
    }
}
