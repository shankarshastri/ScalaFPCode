package uva;
/*
 * @author shankarrc
 * @date 01/09/19
 */

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.in;
import static java.util.Arrays.*;

//sbt "run-main uva.Borrowers"
class Book {
    private String authorName;
    private String bookName;
    private Boolean isBookBorrowed;
    Book(String authorName, String bookName, Boolean isBookBorrowed) {
        this.authorName = authorName;
        this.bookName = bookName;
        this.isBookBorrowed = isBookBorrowed;
    }
    Book(String authorName, String bookName) {
        this.authorName = authorName;
        this.bookName = bookName;
        this.isBookBorrowed  = false;
    }

    Book setIsBookBorrowed(Boolean isBookBorrowed) {
        this.isBookBorrowed = isBookBorrowed;
        return this;
    }
    Boolean getIsBookBorrowed() {
        return this.isBookBorrowed;
    }
}

public class Borrowers {

    public static void main(String[] args) {
        int endCount = 0;
        Scanner sc = new Scanner(in);
        TreeMap<String, Book> bookTreeMap = new TreeMap<>();
        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            if(endCount == 2)  // EOF Character
                break;
            if(input.contains("END") && sc.hasNextLine()) {
                endCount++;
                continue;
            } else if(input.contains("END") && !sc.hasNextLine()) {
                endCount++;
                continue;
            } else if(input.contains("BORROW")) {
                String [] s = input.split("BORROW");
                bookTreeMap.replace(s[1].trim(), bookTreeMap.get(s[1].trim()).setIsBookBorrowed(true));
            } else if(input.contains("RETURN")) {
                String [] s = input.split("RETURN");
                bookTreeMap.replace(s[1].trim(), bookTreeMap.get(s[1].trim()).setIsBookBorrowed(false));
            } else if(input.equals("SHELVE")) {
                List<String> l =
                        bookTreeMap
                                .keySet()
                                .stream()
                                .filter(e -> !(bookTreeMap.get(e).getIsBookBorrowed()))
                                .collect(Collectors.toList());
                if(l.size() == 1)
                    System.out.println("Put " + l.get(0) + " first");
                else {
                    for (int i = l.size() - 2; i >= 0; i--) {
                        System.out.println("Put " + l.get(i) + " after " + l.get(i+1));
                    }
                }
                System.out.println("END");
            } else {
                List<String> s = stream(input.split("by")).map(e -> e.trim()).collect(Collectors.toList());
                String book = s.get(0);
                String author = s.get(1);
                bookTreeMap.put(book, new Book(author, book));
            }
        }
    }
}