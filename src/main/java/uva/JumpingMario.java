package uva;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;

class Pair<A, B> {
    A _1;
    B _2;

    Pair(A _1, B _2) {
        this._1 = _1;
        this._2 = _2;
    }

    @Override
    public String toString() {
        return _1 + " " + _2;
    }
}

public class JumpingMario {

    public static <T> void loopWithIndex(int n, Function<Integer, T> function) {
        IntStream.range(1, n + 1).forEach(e -> out.println(function.apply(e)));
    }

    public static <A> Vector<Vector<A>> sliding(Vector<A> c, Integer n) {
        int size = c.size();
        Vector<Vector<A>> v = new Vector<>(size - 1);
        for (int i = 0; i <= size - n; i++) {
            v.add(new Vector<>(c.subList(i, i + n)));
        }
        if (v.isEmpty()) {
            v.add(c);
            return v;
        }
        return v;
    }

    public static <A, B> B foldLeft(Stream<A> a, B z,
                                    BiFunction<A, B, B> biFunction) {
        B b = z;
        List<A> l = a.collect(Collectors.toList());
        for (A e : l) {
            b = biFunction.apply(e, b);
        }
        return b;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        BiFunction<Pair<Integer, Integer>, Pair<Integer, Integer>, Pair<Integer, Integer>> bF = (lpair, pair) -> {
            if (lpair._1 == lpair._2) return pair;
            else {
                return (lpair._1 < lpair._2) ? new Pair(pair._1 + 1, pair._2) : new Pair(pair._1, pair._2 + 1);
            }
        };

        Function<Integer, String> f = integer -> {
            int n = Integer.parseInt(sc.nextLine());
            Stream<Integer> s = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt);
            Vector<Vector<Integer>> v = sliding(new Vector<>(s.collect(Collectors.toList())), 2);
            if (v.size() == 1) {
                return ("Case " + integer + ": " + 0 + " " + 0);
            } else {
                Stream<Pair<Integer, Integer>> sP = v.stream().map(e -> new Pair(e.firstElement(), e.get(1)));
                Pair<Integer, Integer> res = foldLeft(sP, new Pair<>(0, 0), bF);
                return ("Case " + integer + ": " + res._1 + " " + res._2);
            }
        };

        loopWithIndex(t, f);
    }
}