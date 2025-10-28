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
        System.out.println("  -> translateWord('" + input + "')");
    if (input == null || input.isEmpty()) return input;
        String result = "";
        //standized to lowercase
        String word = input.toLowerCase();

        // defineing vowels
        String vowels = "aeiou";

        //if first letter vowel
        if (vowels.indexOf(word.charAt(0)) != -1) {
            return word + "way";
        }

        //or find where vowel appears
        int firstVowelIndex = -1;
        for (int i = 0; i < word.length(); i++ ) {
            if (vowels.indexOf(word.charAt(i)) != -1) {
                firstVowelIndex = i;
                break;
            }
        }

        // if no vowel
        if ( firstVowelIndex == -1) {
            return word + "ay";
        }

        String s = word.substring(0, firstVowelIndex);
        String e = word.substring(firstVowelIndex);
    
        return e + s + "ay";
    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
