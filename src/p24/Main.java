package p24;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = in.nextInt(), k = in.nextInt();
        List<List<Integer>> ans = solution.combine(n, k);

        System.out.println(ans);
    }
}

class Solution {
    List<List<Integer>> ans;
    List<Integer> path;

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        if (n == 1) {
            path.add(n);
            ans.add(path);
            return ans;
        }

        traverse(n, k, 1);
        return ans;
    }

    private void traverse(int n, int k, int startIndex) {
        if (path.size() == k) {
            ans.add(new ArrayList(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            traverse(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}