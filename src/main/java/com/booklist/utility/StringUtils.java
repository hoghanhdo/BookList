package com.booklist.utility;

public class StringUtils {

    public static String formatTimeForView (String inputTime){
        return inputTime.substring(0,11);
    }

    public static String toHtmlString(String beforeStr) {
        StringBuilder escaped = new StringBuilder();
        for (int i = 0; i < beforeStr.length(); i++) {
            char c = beforeStr.charAt(i);
            switch (c) {
                case '&':
                    escaped.append("&amp;");
                    break;
                case '<':
                    escaped.append("&lt;");
                    break;
                case '>':
                    escaped.append("&gt;");
                    break;
                case '"':
                    escaped.append("&quot;");
                    break;
                case '\'':
                    escaped.append("&#39;");
                    break;
                case '\\':
                    escaped.append("&#38;");
                    break;
                default:
                    escaped.append(c);
                    break;
            }
        }
        return escaped.toString();
    }

    public static boolean isEmpty (String str){
        if (str == null){
            return false;
        }
        return str.length() == 0;
    }
    public static boolean checkLengthRange(String str, int minLength, int maxLength){
        if (str == null){
            return false;
        }
        return minLength <= str.length() && str.length() <= maxLength;
    }

    public static void main (String[] args){
        toHtmlString("two > & less than three");
    }
}
