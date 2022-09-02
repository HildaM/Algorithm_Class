package p28;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Solution solution = new Solution();

        String digits = in.next();
        System.out.println(solution.letterCombinations(digits));
    }
}


class Solution {
    String[] strs =  {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0 || digits == null) return ans;
        recursion(digits, 0);
        return ans;
    }

    private void recursion(String digits, int startIndex) {
        if (startIndex == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String str = strs[digits.charAt(startIndex) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            recursion(digits, startIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}