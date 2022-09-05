package p04;

import java.util.*;

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


        int[] ans = solution.getLeastNumbers(arr, k);
        // stream 去重 Arrays.stream(ans).distinct().toArray()
        // 理解错题意了，不需要去重！
        for (int num : ans) {
            System.out.print(num + " ");
        }

    }
}

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) ans[i] = arr[i];

        return ans;
    }
}
