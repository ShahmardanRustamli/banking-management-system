package util;

import java.util.Scanner;

public class InputUtil {
    public static String inputString(String title) {
        Scanner input = new Scanner(System.in);
        System.out.println(title);
        return input.nextLine();
    }

    public static long inputLong(String title) {
        Scanner input = new Scanner(System.in);
        System.out.println(title);
        return input.nextLong();
    }

    public static byte inputByte(String title) {
        Scanner input = new Scanner(System.in);
        System.out.println(title);
        return input.nextByte();
    }

    public static int inputInt(String title) {
        Scanner input = new Scanner(System.in);
        System.out.println(title);
        return input.nextInt();
    }
}