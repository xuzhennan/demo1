package xzn;

import java.util.Arrays;

public class test {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "11"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int min = Math.min(len1, len2);
        char[] ret = new char[2 * min];
        int num = 0;
        for (int i = 0; i < min; i++) {
            ret[num++] = word1.charAt(i);
            ret[num++] = word2.charAt(i);
        }

        if (len1 == len2) {
            return new String(ret);
        }

        return new String(ret) + (len1 > len2 ? word1.substring(min) : word2.substring(min));
    }

}
