package longestPalindromeInString;

public class Main {
    public static void main(String[] args) {
        String s = "";

        System.out.println(longestPalindrome(s));

    }
        public static String longestPalindrome(String s) {
            String max = "";
            for (int i = 0; i < s.length(); i++) {
                String s1 = extend(s, i, i), s2 = extend(s, i, i + 1);
                if (s1.length() > max.length()) max = s1;
                if (s2.length() > max.length()) max = s2;
            }
            return max;
        }

        private static String extend(String s, int i, int j) {
            for (; 0 <= i && j < s.length(); i--, j++) {
                if (s.charAt(i) != s.charAt(j)) break;
            }
            return s.substring(i + 1, j);
        }
    }

