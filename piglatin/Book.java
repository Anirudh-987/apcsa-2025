package piglatin;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Book {
    private String title;
    private ArrayList<String> text = new ArrayList<String>();

    Book() {
        
    }

    // Helper to debug code
    // Prints out a range of lines from a book
    public void printlines(int start, int length) {
        System.out.println("Lines " + start + " to " + (start + length) + " of book: " + title);
        for (int i = start; i < start + length; i++) {
            if (i < text.size()) {
                System.out.println(i + ": " + text.get(i));
            } else {
                System.out.println(i + ": line not in book.");
            }
        }
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getLine(int lineNumber) {
        return text.get(lineNumber);
    }

    int getLineCount() {
        return text.size();
    }

    void appendLine(String line) {
        text.add(line);
    }

    public void readFromString(String title, String string) {
           this.title = title;
    Scanner scanner = new Scanner(string);

    while (scanner.hasNextLine()) {
        text.add(scanner.nextLine());
    }

    scanner.close();
    }

    public void readFromUrl(String title, String url) {
       this.title = title;


        try {
        URL bookUrl = URI.create(url).toURL();
        Scanner scanner = new Scanner(bookUrl.openStream());

        boolean startReading = false;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Start only when actual book begins
            if (line.contains("*** START OF")) {
                startReading = true;
                continue;
            }

            // Stop when book ends
            if (line.contains("*** END OF")) {
                break;
            }

            // Only add lines that are part of the book
            if (startReading) {
                text.add(line);
            }
        }
        scanner.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    }

    void writeToFile(String name) {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(name))) {
        for (String line : text) {
            writer.write(line);
            writer.newLine();
        }
        System.out.println("Book saved as " + name);
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    }
}
