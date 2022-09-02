package p23;

import java.util.*;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = in.nextInt();  // useless
        List<String> ans = solution.generateParenthesis(n);

        System.out.println(ans);
    }
}

class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        recursion(n * 2, 0, 0, n, "");
        return ans;
    }

    private void recursion(int n, int count,int score, int max, String path) {
        if (count == n) {
            if (score == 0) ans.add(path);
        } else {
            if (score + 1 <= max) recursion(n, count + 1, score + 1, max, path + "(");
            if (score - 1 >= 0) recursion(n, count + 1, score - 1, max, path + ")");
        }
    }
}


