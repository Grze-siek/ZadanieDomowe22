package PrzelicznikTekstu;

public final class TextStats {

    public static int numberOfWords(String text) {
        String[] words = text.split(" ");
        return words.length;
    }

    public static int numberOfAllChars(String text) {
        return text.length();
    }

    public static int numberOfChars(String text) {
        String textWithoutSpaces = text.replace(" ", "");
        return textWithoutSpaces.length();
    }

    public static boolean isPalindrom(String text) {
        String lowerCaseTextWithoutSpaces = text.replace(" ", "").toLowerCase();
        char[] chars = lowerCaseTextWithoutSpaces.toCharArray();
        for (int index = 0; index < chars.length/2; index++) {
            if(chars[index] != chars[chars.length - index - 1])
                return false;
        }
         return true;
    }
}
