package p09;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String line = in.nextLine();
        String[] str = line.split(" ");
        int[] flowerbed = new int[str.length];
        for (int i = 0; i < str.length; i++) flowerbed[i] = Integer.parseInt(str[i]);

        int n = in.nextInt();

        System.out.println(new Solution().canPlaceFlowers(flowerbed, n));
    }
}

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; ) {
            if (flowerbed[i] == 1) i += 2;  // 当前为1，说明下一格也不能种花。也同时说明，下一个格子是0
            else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                n--;    // 由于跳格都是2格以上的，所以可以保证，前一个格子必然是0。这个可以有第一个if保证！
                i += 2;
            }
            else i += 3;
        }

        return n <= 0;
    }
}
