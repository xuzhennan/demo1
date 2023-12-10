package xzn;

public class test2 {

    /**
     * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
     *
     * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
     *
     * 输入：str1 = "ABCABC", str2 = "ABC"
     * 输出："ABC"
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        int min = Math.min(str1.length(), str2.length());
        for (int i = min; i >= 1 ; i--) {
            if (l1 % i == 0 && l2 % i == 0) {
                String x = str1.substring(0, i);
                if (check(x, str1) && check(x, str2)) {
                    return x;
                }
            }
        }
        return "";
    }

    private static boolean check(String x, String str) {
        int count = str.length() / x.length();
        StringBuilder sb = new StringBuilder();

        // 拼接若干次相等
        for (int i = 0; i < count; i++) {
            sb.append(x);
        }

        return sb.toString().equals(str);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("LEET", "ABAB"));
    }
}
