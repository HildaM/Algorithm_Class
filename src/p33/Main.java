package p33;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = in.nextInt();

        System.out.println(new Solution().findFakeCoin(coins, 0, n - 1) + 1);
    }
}

class Solution {
    public int findFakeCoin(int[] coins, int start, int end) {
        if (start >= end) {
            return start;
        }

        int mid = (start + end) / 2;
        int left = findFakeCoin(coins, start, mid);
        int right = findFakeCoin(coins, mid + 1, end);

        return coins[left] < coins[right] ? left : right;
    }
}