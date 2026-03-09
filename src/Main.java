import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = 4;

        LinkedList<Integer> list = new LinkedList<>(List.of(1, 2, 3));

        ListIterator<Integer> first = list.listIterator(0);
        ListIterator<Integer> last = list.listIterator(list.size());

        first.add(100);
        last.add(100);

        System.out.println(list);
        System.out.println();
    }
}


