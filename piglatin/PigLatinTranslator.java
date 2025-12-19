package piglatin;

public class PigLatinTranslator {
public static Book translate(Book input) {

Book translatedBook = new Book();

int len = input.getLineCount();
for(int i = 0; i < len; i++) {
String line = input.getLine(i);
String translatedLine = translate(line);
translatedBook.appendLine(translatedLine);
}
return translatedBook;
}

public static String translate(String input) {
System.out.println(" -> translate('" + input + "')");

String result = "";

// Split input into seperate words
for(String word : input.split(" ")) {
result += " " + translateWord(word);
}

return result.trim();
}

private static String translateWord(String input) {
System.out.println(" -> translateWord('" + input + "')");

String result = "";

// Check for empty string
if (input == null || input.trim().length() == 0){
return "";
}

// All the variables
int vowelIndex = 0;
int puncIndex = 0;
boolean hasPunc = false;
String firstLetter = input.substring(0, 1);

if (isVowel(firstLetter)){
result = input + "ay";
}
// Find first vowel
for (int i = 0; i < input.length(); i++){
if (isVowel(input.substring(i, i + 1))){
vowelIndex = i;
break;
}
}

// Translates to pig latin
String start = input.substring(0, vowelIndex);
String rest = input.substring(vowelIndex);
result = rest + start.toLowerCase() + "ay";

// Check for punctuation
if (result.indexOf(".") != -1){
hasPunc = true;
puncIndex = result.indexOf(".");
} else if (result.indexOf("!") != -1){
hasPunc = true;
puncIndex = result.indexOf("!");
} else if (result.indexOf("?") != -1){
hasPunc = true;
puncIndex = result.indexOf("?");
} else if (result.indexOf(",") != -1){
hasPunc = true;
puncIndex = result.indexOf(",");
} else if (result.indexOf(";") != -1){
hasPunc = true;
puncIndex = result.indexOf(";");
} else if (result.indexOf(":") != -1){
hasPunc = true;
puncIndex = result.indexOf(":");
}

// Punctuaction
if (hasPunc){
result = result.substring(0, puncIndex) + result.substring(puncIndex + 1) + result.charAt(puncIndex);
}
// Capitalization
if (Character.isUpperCase(input.charAt(0))){
result = result.substring(0, 1).toUpperCase() + result.substring(1);
}
return result;
}

// Check if letter is a vowel
public static boolean isVowel(String letter){
String vowels = "aeiouAEIOU";
if (vowels.indexOf(letter) != -1) {
return true;
}
return false;
}

// Check if letter is a punctuation
public static boolean isPunc(String letter){
String punc = ".!?";
if (punc.indexOf(letter) != -1){
return true;
}
return false;
}
}