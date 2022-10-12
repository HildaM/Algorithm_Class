package p31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt(), k = in.nextInt();
        List<List<Integer>> ans = new Solution().combinationSum3(n, k);
        if (ans.size() == 0) {
            System.out.print(0);
            return;
        }

        Collections.reverse(ans);
        for (List<Integer> list : ans) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }


}

class Solution {
    List<List<Integer>> ans;
    List<Integer> path;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        path = new ArrayList<>();

        recursion(k, n, 1, 0);
        return ans;
    }

    private void recursion(int k, int n, int startIndex, int sum) {
        if (path.size() == k) {
            if (sum == n) ans.add(new ArrayList(path));
            return;
        }

        for (int i = startIndex; i <= 9 && sum + i <= n; i++) {
            path.add(i);
            recursion(k, n, i + 1, sum + i);
            path.remove(path.size() - 1);
        }
    }
}