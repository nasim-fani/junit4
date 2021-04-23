package test1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Home
 */
public class Utils {

    public static boolean isValidEmailAddress(String emailAddress) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence) emailAddress);
        return matcher.matches();
    }

    public static int getCount(String text, String key) {
        int count = 0;
        while (text.contains(key)) {
            count++;
            text = text.substring(text.indexOf(key) + key.length());
        }
        return count;
    }

    public static String longestCommonSubstring(String s1, String s2) {
        int start = 0;
        int max = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                int x = 0;
                while (s1.charAt(i + x) == s2.charAt(j + x)) {
                    x++;
                    if (((i + x) >= s1.length()) || ((j + x) >= s2.length())) {
                        break;
                    }
                }
                if (x > max) {
                    max = x;
                    start = i;
                }
            }
        }
        return s1.substring(start, (start + max));
    }
}
