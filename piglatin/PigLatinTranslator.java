package piglatin;

public class PigLatinTranslator {

    public static Book translate(Book input) {
        Book translatedBook = new Book();

        for (int i = 0; i < input.getLineCount(); i++) {
            String line = input.getLine(i);
            String translatedLine = translate(line);
            translatedBook.appendLine(translatedLine);
        }

        return translatedBook;
    }

    public static String translate(String input) {
        if (input.trim().isEmpty()) return "";

        // Split sentence into words while keeping punctuation attached
        String[] words = input.split(" ");
        StringBuilder translatedSentence = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String translatedWord = translateWord(word);
            translatedSentence.append(translatedWord);

            // Add space between words (but not after last)
            if (i < words.length - 1) {
                translatedSentence.append(" ");
            }
        }

        return translatedSentence.toString();
    }

    // Helper: translate a *single word* to Pig Latin
    private static String translateWord(String input) {
        if (input.trim().isEmpty()) return "";

        // Separate punctuation (.,!?)
        String punctuation = "";
        if (!Character.isLetterOrDigit(input.charAt(input.length() - 1))) {
            punctuation = input.substring(input.length() - 1);
            input = input.substring(0, input.length() - 1);
        }

        // Save capitalization pattern
        boolean[] caps = new boolean[input.length()];
        for (int i = 0; i < input.length(); i++) {
            caps[i] = Character.isUpperCase(input.charAt(i));
        }

        // Lowercase for processing
        String lower = input.toLowerCase();

        // Find first vowel
        int firstVowel = -1;
        for (int i = 0; i < lower.length(); i++) {
            if ("aeiou".indexOf(lower.charAt(i)) != -1) {
                firstVowel = i;
                break;
            }
        }

        String result;
        if (firstVowel == 0) {
            result = lower + "ay";
        } else if (firstVowel > 0) {
            result = lower.substring(firstVowel) + lower.substring(0, firstVowel) + "ay";
        } else {
            result = lower + "ay"; // no vowel
        }

        // Restore capitalization pattern (wrap around if necessary)
      StringBuilder finalWord = new StringBuilder();
for (int i = 0; i < result.length(); i++) {
    char c = result.charAt(i);
    if (Character.isLetter(c)) {
        // Map capitalization from original word (loop if result is longer)
        int sourceIndex = i % caps.length;
        // Keep "ay" always lowercase
        if (i >= result.length() - 2 && result.endsWith("ay")) {
            finalWord.append(Character.toLowerCase(c));
        } else {
            finalWord.append(caps[sourceIndex] ? Character.toUpperCase(c) : Character.toLowerCase(c));
        }
    } else {
        finalWord.append(c);
    }
}
        return finalWord.toString() + punctuation;
    }
}