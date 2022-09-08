package ua.ithillel.artem_kovalov;

public class Main {

    public static void main(String[] args) {
        System.out.println("findSymbolOccurance: "
                + findSymbolOccurance("Chargoggagoggmanchauggagoggchaubunagungamaugg ", 'g'));
        System.out.println("findWordPosition 'pollo': " + findWordPosition("Apollo", "pollo"));
        System.out.println("findWordPosition 'Plant': " + findWordPosition("Apple", "Plant"));
        System.out.println("stringReverse 'Hello': " + stringReverse("Hello"));
        System.out.println("isPalindrome 'ERE': " + isPalindrome("ERE"));
        System.out.println("isPalindrome 'Allo': " + isPalindrome("Allo"));
        System.out.println();
        new WordGame().startGame();
    }

    static int findSymbolOccurance(String source, char symbol) {
        int result = 0;
        for (char c : source.toCharArray()) {
            if (c == symbol) {
                result++;
            }
        }
        return result;
    }

    static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    static String stringReverse(String source) {
        StringBuilder builder = new StringBuilder(source);
        return builder.reverse().toString();
    }

    static boolean isPalindrome(String source) {
        return source.equalsIgnoreCase(stringReverse(source));
    }
}