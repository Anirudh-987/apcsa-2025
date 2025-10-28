package piglatin;

public class App {
    public static void main(String[] args)
    {
    

      


        // Run tests, comment out once they pass.
        int score = TestSuite.run();

        // Focus on TestSuite until you get a score of 5 or higher.
        if (score > 4)
        {
            // Starter book
            Book input = new Book();

            // Start with a "test" book based on a string.
            // Get this to work, and all the tests to pass first.
            input.readFromString("TestBook", "Dog\nCat\nMouse");

            // Example reading from a URL
            //input.readFromUrl("Romeo and Juliette", "https://gutenberg.pglaf.org/cache/epub/1513/pg1513.txt");

            input.printlines(0,2);
            Book output = PigLatinTranslator.translate(input);
            output.printlines(0,2);
            output.writeToFile("test.txt");
        }
    }
}

