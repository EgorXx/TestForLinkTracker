import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();

        int n = Integer.parseInt(line);

        int[] array = new int[n];
        int size = 0;

        line = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(line);;

        for (int j = 0; j < n; j++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());

            array[size] = num;
            ascent(size, array);
            size++;
        }

        for (int i = 0; i < n; i++) {
            swap(0, size - 1, array);
            size--;
            sift(0, array, size);
        }

        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    public static void sift(int index, int[] array, int size) {
        int indexToSwap;

        while (true) {
            if (index * 2 + 1 >= size) {return;}
            else if (index * 2 + 2 >= size) {indexToSwap = index * 2 + 1;}
            else {indexToSwap = array[index * 2 + 1] > array[index * 2 + 2] ? index * 2 + 1 : index * 2 + 2;}

            if (array[indexToSwap] > array[index]) {
                swap(index, indexToSwap, array);
                index = indexToSwap;
            } else {
                return;
            }
        }
    }

    public static void ascent(int index, int[] array) {
        int indexToSwap;

        while (true) {
            indexToSwap = (index - 1) / 2;

            if (index == 0) {return;}

            if (array[indexToSwap] < array[index]) {
                swap(index, indexToSwap, array);
                index = indexToSwap;
            } else {return;}
        }
    }

    public static void swap(int index1, int index2, int[] array) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}