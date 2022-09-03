package p08;


import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();

        String line = in.nextLine();
        String[] arr = line.split(" ");
        int[] bills = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            bills[i] = Integer.parseInt(arr[i]);

        System.out.println(solution.lemonadeChange(bills));
    }
}

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int b : bills) {
            if (b == 5) {
                five++;
            } else if (b == 10) {
                if (five < 0) return false;
                five--;
                ten++;
            } else if (b == 20) {
                if (ten == 0) {
                    if (five < 3) return false;
                    five -= 3;
                } else {
                    if (five < 1) return false;
                    ten--;
                    five--;
                }
                twenty++;
            }
        }

        return true;
    }
}
