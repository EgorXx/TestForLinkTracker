import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String line = bufferedReader.readLine();
//        StringTokenizer stringTokenizer = new StringTokenizer(line);
//
//        int N = Integer.parseInt(stringTokenizer.nextToken());
//        int K = Integer.parseInt(stringTokenizer.nextToken());
//
//        Map<Integer, Integer> map = new TreeMap<>();
//
//        for (int i = 1; i <= N; i++) {
//            map.merge(i * i, 1, Integer::sum);
//
//            for (int j = i * (i + 1); j <= N * i; j = j + i) {
//                map.merge(j, 2, Integer::sum);
//            }
//        }
////        System.out.println(map);
//
//        for (var entry : map.entrySet()) {
////            System.out.println(entry.getKey() + " " + entry.getValue());
//            K -= entry.getValue();
//
//            if (K <= 0) {
//                System.out.println(entry.getKey());
//                break;
//            }
//
////            System.out.println(K + "\n\n");
//        }
        class Point {
            int x, y;
            Point(int x, int y) { this.x = x; this.y = y; }
            @Override public boolean equals(Object o) {
                Point p = (Point) o;
                return x == p.x && y == p.y;
            }
        }
        Set<Point> set = new HashSet<>();
        set.add(new Point(1, 2));
        set.add(new Point(1, 2));
        System.out.println(set.size());
    }


}