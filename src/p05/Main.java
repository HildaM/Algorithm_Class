package p05;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();

        String line = in.nextLine();
        String[] l = line.split(" ");
        int n = Integer.parseInt(l[0]), k = Integer.parseInt(l[1]);

        line = in.nextLine();
        l = line.split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(l[i]);

        System.out.println(solution.findKthLargest(arr, k));
    }
}

// 最大堆解法
// O(logN)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> b - a);
        for (int n : nums) que.add(n);
        k -= 1;
        while (k-- > 0) que.poll();
        return que.poll();
    }
}
