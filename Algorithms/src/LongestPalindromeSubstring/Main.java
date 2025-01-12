package LongestPalindromeSubstring;

public class Main {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubstringBruteForce("abbas"));
    }

    private static String longestPalindromeSubstringBruteForce(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) { //iterate over every char from the index zero.
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                //is it palindrome and is the new substring.length is bigger than the last longest one.
                if (isPalindrome(substring) && substring.length() > longest.length()) {
                    longest = substring;
                }
            }
        }
        return longest;
    }

    private static boolean isPalindrome(String s) {
        //approaching the substring from left and right.
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) { //if it's palindrome the symmetric indexes should match. for ex. a-b-a.
                return false; // if they don't return false.
            }
            left++;
            right--;
        }
        return true;
    }
}
