package piglatin;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Book {
    private String title;
    private ArrayList<String> text = new ArrayList<String>();

    // Default constructor
    public Book() {}

    // Print a range of lines for debugging
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

    // Getter for title
    public String getTitle() {
        return title;
    }

    // ✅ Setter for title (fix for translate method)
    public void setTitle(String title) {
        this.title = title;
    }

    // Get number of lines
    public int getLineCount() {
        return text.size();
    }

    // Get specific line safely
    public String getLine(int lineNumber) {
        if (lineNumber < 0 || lineNumber >= text.size()) {
            return ""; // return empty string instead of crashing
        }
        return text.get(lineNumber);
    }

    // Append a line manually
    public void appendLine(String line) {
        if (line != null && !line.isEmpty()) {
            text.add(line);
        }
    }

    // Read book from a string (optional manual title)
    public void readFromString(String title, String string) {
        if (title != null) {
            this.title = title; // manual title for test books
        }

        Scanner scanner = new Scanner(new StringReader(string));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                text.add(line);
            }
        }
        scanner.close();
    }

    // Read book from a URL (title detected automatically)
    public void readFromUrl(String url) {
        try {
            URL bookUrl = URI.create(url).toURL();
            Scanner scanner = new Scanner(bookUrl.openStream());

            boolean startReading = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                // Detect title automatically
                if (title == null && line.startsWith("Title:")) {
                    title = line.substring(6).trim();
                }

                // Start reading actual book
                if (line.contains("*** START OF")) {
                    startReading = true;
                    continue;
                }

                // Stop reading at end of book
                if (line.contains("*** END OF")) {
                    break;
                }

                if (startReading && !line.isEmpty()) {
                    text.add(line);
                }
            }

            scanner.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Write book to a file
    public void writeToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : text) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Book saved as " + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

