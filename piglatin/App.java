package piglatin;

public class App {
    public static void main(String[] args) {

        // Run tests, comment out once they pass.
        int score = TestSuite.run();

        // Focus on TestSuite until you get a score of 5 or higher.
        if (score > 4) {

            // Starter book (small test string)
            Book input = new Book();
            input.readFromString("TestBook", "Dog\nCat\nMouse");

            // Print first 3 lines of test book
            input.printlines(0, 3);

            // Translate test book
            Book output = PigLatinTranslator.translate(input);
            output.printlines(0, 3);
            output.writeToFile("test.txt");

            // Now read full book from Project Gutenberg
            Book fullBook = new Book();
            fullBook.readFromUrl("https://www.gutenberg.org/cache/epub/4363/pg4363.txt");

            // check
            fullBook.printlines(0, 10);

            // Translate the full book
            Book translatedBook = PigLatinTranslator.translate(fullBook);

            // check again
            translatedBook.printlines(0, 10);

            // Save translated book to fil
            translatedBook.writeToFile("beyondGoodandEvil_PigLatin.txt");

           
        }
    }
}
