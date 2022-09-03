package p19;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = in.nextInt();
        System.out.println(solution.maximum69Number(num));
    }
}


class Solution {
    public int maximum69Number (int num) {
        StringBuilder nums = new StringBuilder(num + "");
        for (int i = 0; i < nums.length(); i++) {
            if (nums.charAt(i) == '6') {
                nums.setCharAt(i, '9');
                break;
            }
        }

        return Integer.parseInt(nums.toString());
    }
}