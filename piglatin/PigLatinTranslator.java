package piglatin;

public class PigLatinTranslator {
    public static Book translate(Book input) {
    Book translatedBook = new Book();

    // Keep the same title but mark it as translated
    translatedBook.setTitle(input.getTitle() + " (Pig Latin)");

    // Loop through each line of the input book
    for (int i = 0; i < input.getLineCount(); i++) {
        String line = input.getLine(i);
        String translatedLine = translate(line);
        translatedBook.appendLine(translatedLine);
    }

    return translatedBook;
}
    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

    if (input == null || input.isEmpty()) return input;

    // Split the input into words (correct regex is \\s+, not //s+)
    String[] words = input.split("\\s+");

    // Use a StringBuilder to build the result string
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < words.length; i++) {
        String word = words[i];

        // Translate each word
        String processedWord = translateWord(word);
        result.append(processedWord);

        // Add space between words, but not after the last one
        if (i < words.length - 1) {
            result.append(" ");
        }
    }

    // Return the final translated string
    return result.toString();
}
    

    private static String translateWord(String input) {
       if (input == null || input.isEmpty()) return input;

    // Extract punctuation at the end
    String punctuation = "";
    if (!Character.isLetterOrDigit(input.charAt(input.length() - 1))) {
        punctuation = "" + input.charAt(input.length() - 1);
        input = input.substring(0, input.length() - 1);
    }

    boolean capitalized = Character.isUpperCase(input.charAt(0));
    String word = input.toLowerCase();
    String vowels = "aeiou";

    if (vowels.indexOf(word.charAt(0)) != -1) {
        word = word + "ay";  // vowel-start words
    } else {
        int firstVowelIndex = -1;
        for (int i = 0; i < word.length(); i++) {
            if (vowels.indexOf(word.charAt(i)) != -1) {
                firstVowelIndex = i;
                break;
            }
        }

        if (firstVowelIndex == -1) {
            word = word + "ay";  // no vowel
        } else {
            String start = word.substring(0, firstVowelIndex);
            String end = word.substring(firstVowelIndex);
            word = end + start + "ay";
        }
    }

    // Restore capitalization
    if (capitalized) {
        word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

    // Reattach punctuation
    return word + punctuation;
}

}
