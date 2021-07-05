package com.allendowney.cote.sortAndSearch;

import java.util.Arrays;

public class ReorderLogFiles {

    public static void main(String[] args) {
        String[] input = {"dig1 8 2 3 1",
                "let1 abc cat",
                "dig1 2 5",
                "let2 good dog book",
                "let3 abc zoo" };
        String[] result = reorderLogFiles(input);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                int comp = split1[1].compareTo(split2[1]);
                if (comp == 0)
                    return split1[0].compareTo(split2[0]);
                else
                    return comp;
            } else if (isDigit1 && isDigit2) {
                return 0;
            } else if (isDigit1 && !isDigit2) {
                return 1;
            } else {
                return -1;
            }

        });

        return logs;

    }
}
