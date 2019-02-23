package uva;

import java.util.Scanner;

public class TexQuotes {

    public static String strToTexQuotes(String input) {
        StringBuilder texQuotedString = new StringBuilder(input);
        int length = input.length();
        Boolean texQuotes = false;
        while(texQuotedString.toString().indexOf("\"") != -1) {
            int currentIndex = texQuotedString.toString().indexOf("\"");
            if(currentIndex == length -1) {
                texQuotes = true;
                texQuotedString.deleteCharAt(currentIndex);
                texQuotedString.insert(currentIndex, "''");
            } else if(texQuotes) {
                texQuotes = false;
                texQuotedString.deleteCharAt(currentIndex);
                texQuotedString.insert(currentIndex, "''");
            } else {
                texQuotes = true;
                texQuotedString.deleteCharAt(currentIndex);
                texQuotedString.insert(currentIndex, "``");
            }
        }
        return texQuotedString.toString();
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            if(input.contains("\u001a"))  // EOF Character
                break;
            System.out.println(strToTexQuotes(sc.nextLine()));
        }
    }
}
