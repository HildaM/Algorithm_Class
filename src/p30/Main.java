package p30;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt(), k = in.nextInt();
        boolean flag = false;

        for (int i = 0; i <= 20; i++) {

            for (int j = 0; j <= 33; j++) {

                for (int t = 0; t <= 100; t++) {

                    if (t % 3 == 0 && n - 5*i - 3*j - t/3 == 0 && i + j + t == k) {
                        flag = true;
                        System.out.println(i + " " + j + " " + t);
                    }
                }
            }
        }

        if (!flag) System.out.println(0);
    }
}
