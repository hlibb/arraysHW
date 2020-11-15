package WorkWithStrings;

import java.util.Scanner;

public class StringTasks {
    private static final char[] abc = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static int countOf(String s, String needle) {
        if (s.isEmpty()) {
            return -999999;
        }
        int countOfNeedle = 0;
        while (s.contains(needle)) {
            int last = s.indexOf(needle) + needle.length();
            s = s.substring(last);
            s = s.trim();
            countOfNeedle++;
            System.out.println(s);
        }
        return countOfNeedle;
    }

    public static String input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        return sc.nextLine();
    }

    public static String needleInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to look for:");
        return sc.nextLine();
    }

    public static String cesarCrypt(String s, int key) {

        char[] sIn = s.toCharArray();
        String abcStr = new String(abc);
        char[] codedString = new char[0];
        for (char c : sIn) {
            if (c == ' ') addCharToArray(codedString, ':');
            for (int j = 0; j < abc.length; j++) {
                if (c == abc[j]) {
                    if ((j + key) >= abc.length) {
                        codedString = addCharToArray(codedString, abcStr.charAt((abc.length - 2)/*25*/ - (j)));
                    } else if ((j + key) < 0) {
                        codedString = addCharToArray(codedString, abcStr.charAt(abc.length + (j + key)));
                    } else codedString = addCharToArray(codedString, abcStr.charAt(j + key));
                }
            }
        }

        String sAnswer = new String (codedString).replaceAll(":", " ");
        return sAnswer;
    }

    private static char[] addCharToArray(char[] arr, char addingChar) {
        char[] buf = arr;
        arr = new char[arr.length + 1];
        for (int i = 0; i < buf.length; i++) {
            arr[i] = buf[i];
        }
        arr[arr.length - 1] = addingChar;
        return arr;
    }

    public static int intKey() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Key");
        return sc.nextInt();
    }
}