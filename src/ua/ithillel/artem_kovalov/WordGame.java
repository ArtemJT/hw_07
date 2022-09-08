package ua.ithillel.artem_kovalov;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class WordGame {
    private final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
            "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
            "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public void startGame() {
        String secretWord = words[new Random().nextInt(words.length - 1)];
        Scanner scanner = new Scanner(System.in);
        boolean isGuess = false;
        int attempt = 0;

        while (!isGuess) {
            System.out.println("GUESS THE WORD FROM THE LIST:");
            System.out.println(Arrays.toString(words).replaceAll("\\[?]?", ""));

            System.out.println("\nENTER WORD:");
            String inputWord = scanner.nextLine().toLowerCase();
            attempt++;
            if (compareWords(secretWord, inputWord)) {
                System.out.printf("CONGRATULATIONS! YOU GUESSED on %d TRY!", attempt);
                isGuess = true;
            }
        }
    }

    private boolean compareWords(String source, String input) {
        if (source.equals(input)) {
            return true;
        }

        StringBuilder result = new StringBuilder("###############");
        if (source.length() > input.length()) {
            source = source.substring(0, input.length());
        } else if (source.length() < input.length()) {
            input = input.substring(0, source.length());
        }

        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == input.charAt(i)) {
                result.insert(i, source.charAt(i));
                result.deleteCharAt(i + 1);
            }
        }
        System.out.printf("\nINCORRECT.\nGuessed letters:\n%s\n\n", result);
        return false;
    }
}
