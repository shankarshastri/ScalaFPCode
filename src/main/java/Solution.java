import scala.Int;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> inputArr = new ArrayList<Integer>();
        // inputArr.add(10);
        inputArr.add(2);
        inputArr.add(4);
        inputArr.add(6);
        inputArr.add(8);

        inputArr.add(10);
        inputArr.add(12);

        System.out.println(kDifference(inputArr, 2));
    }

    public static int kDifference(List<Integer> a, int k) {
        List<Integer> b = a.stream().distinct().collect(Collectors.toList());
        Map<BigInteger, BigInteger> result = new HashMap<>();
        for (int i = 0; i < b.size(); i++) {
            for (int j = i + 1; j < b.size(); j++) {
                if ((b.get(i) + k) == b.get(j) || (b.get(j) + k) == b.get(i)) {
                    result.put(BigInteger.valueOf(b.get(i)), BigInteger.valueOf(b.get(j)));
                }
            }
        }
        return result.size();
    }

}