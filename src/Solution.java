import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(line);

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int root = Integer.parseInt(stringTokenizer.nextToken());

        Node[] nodes = new  Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < n; i++) {
            line = bufferedReader.readLine();
            stringTokenizer = new StringTokenizer(line);

            int leftV = Integer.parseInt(stringTokenizer.nextToken());
            int rightV = Integer.parseInt(stringTokenizer.nextToken());

            Node node = nodes[i];

            if (leftV == -1) {
                node.left = null;
            } else {
                node.left = nodes[leftV];
            }

            if (rightV == -1) {
                node.right = null;
            } else {
                node.right = nodes[rightV];
            }
        }

        int[] h = new int[n];

        dfs(nodes[root], h);

        boolean result = isAvl(nodes[root], -1, -1, h);

        System.out.println(result ? 1 : 0);
    }

    public static boolean isAvl(Node curNode, int lowerRange, int upperRange, int[] h) {
        if (curNode == null) {return true;}

        boolean depth = true;

        if (curNode.left != null && curNode.right != null) {
            depth = (h[curNode.left.val] -  h[curNode.right.val]) <= 1;
        } else if (curNode.left != null) {
            depth = h[curNode.val] <= 1;
        }  else if (curNode.right != null) {
            depth = h[curNode.val] <= 1;
        }

        boolean condition = true;

        if (lowerRange != -1 && upperRange != -1) {
            condition = curNode.val > lowerRange && curNode.val < upperRange;
        } else if (lowerRange != -1) {
            condition = curNode.val > lowerRange;
        } else if (upperRange != -1) {
            condition = curNode.val < upperRange;
        }

        int newUpperRange = Math.min(upperRange == -1 ? Integer.MAX_VALUE : upperRange, curNode.val);
        int newLowerRange = Math.max(lowerRange == -1 ? Integer.MIN_VALUE : lowerRange, curNode.val);

        return depth && condition && isAvl(curNode.left, lowerRange, newUpperRange, h) && isAvl(curNode.right, newLowerRange, upperRange, h);
    }

    public static int dfs(Node curNode, int[] h) {
        if (curNode == null) {return -1;}

        h[curNode.val] = Math.max(dfs(curNode.left, h), dfs(curNode.right, h)) + 1;

        return h[curNode.val];
    }
}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}