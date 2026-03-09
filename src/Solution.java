import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        class Pair {
            int value;
            int index;

            public Pair(int value, int index) {
                this.value = value;
                this.index = index;
            }

            @Override
            public String toString() {
                return "Pair{" +
                        "value=" + value +
                        ", index=" + index +
                        '}';
            }
        }

        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();

        int n = (int) in.nval;

        List<Integer> nums = new ArrayList<>();
        long[] prefixSum = new long[n + 1];
        int[] leftIndexes = new int[n];
        int[] rightIndexes = new int[n];

        prefixSum[0] = 0;

        Deque<Pair> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            in.nextToken();
            int num = (int) in.nval;

            while (!stack.isEmpty() && stack.peek().value >= num) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                leftIndexes[i] = Integer.MIN_VALUE;
            } else {
                leftIndexes[i] = stack.peek().index;
            }

            stack.push(new Pair(num, i));

            nums.add(num);
            prefixSum[i + 1] = prefixSum[i] + num;
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            int num = nums.get(i);

            while (!stack.isEmpty() && stack.peek().value >= num) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                rightIndexes[i] = Integer.MAX_VALUE;
            } else {
                rightIndexes[i] = stack.peek().index;
            }

            stack.push(new Pair(num, i));
        }

//        System.out.println(Arrays.toString(leftIndexes));
//        System.out.println();
//        System.out.println(Arrays.toString(rightIndexes));
//        System.out.println();
//        System.out.println(Arrays.toString(prefixSum));
//        System.out.println();

        long result = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int leftIndex = leftIndexes[i] == Integer.MIN_VALUE ? 0 : leftIndexes[i] + 1;

            int rightIndex = rightIndexes[i] == Integer.MAX_VALUE ? n : rightIndexes[i];

            long sum = (long) nums.get(i) * (prefixSum[rightIndex] - prefixSum[leftIndex]);

            if (result < sum) {
//                System.out.println(leftIndex);
//                System.out.println(rightIndex);

                result = sum;
            }
        }

        System.out.println(result);

    }
}