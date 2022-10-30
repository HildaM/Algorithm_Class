package p39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Description:
 * date: 2022/10/26 下午 4:21
 *
 * @author Four
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        while (in.hasNextInt()) {
            list.add(in.nextInt());
        }
        int[] nums = list.stream().mapToInt(Integer::valueOf).toArray();

        System.out.println(new Solution().candy(nums));
    }
}

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) return 1;

        int[] candys = new int[n];
        Arrays.fill(candys, 1);

        // rigth
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candys[i] = candys[i - 1] + 1;
            }
        }

        // left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candys[i] = Math.max(candys[i], candys[i + 1] + 1);
            }
        }

        return Arrays.stream(candys).sum();
    }
}



