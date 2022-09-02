package p26;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = in.next();
        System.out.println(solution.partition(s));
    }
}


class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        recursion(s, 0);
        return ans;
    }

    private void recursion(String s, int start) {
        if (start >= s.length()) {
            ans.add(new ArrayList(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (isValid(sub)) {
                path.add(sub);
                recursion(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}