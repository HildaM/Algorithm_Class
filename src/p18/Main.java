package p18;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Solution solution = new Solution();

        List<Integer> list1 = new ArrayList<>();
        String line1 = in.nextLine();
        String[] arr = line1.split(" ");
        for (String n : arr) {
            list1.add(Integer.parseInt(n));
        }
        int[] g = list1.stream().mapToInt(x -> x).toArray();

        List<Integer> list2 = new ArrayList<>();
        String line2 = in.nextLine();
        String[] arr2 = line2.split(" ");
        for (String n : arr2) {
            list2.add(Integer.parseInt(n));
        }
        int[] s = list2.stream().mapToInt(x -> x).toArray();

        System.out.println(solution.findContentChildren(g, s));
    }
}

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int ans = 0;
        int j = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (j >= 0 && s[j] >= g[i]) {
                ans++;
                j--;
            }
        }

        return ans;
    }
}
