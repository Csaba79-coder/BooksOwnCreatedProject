package controller;

import Util.FileHandler;
import model.Book;
import model.Category;

import java.io.IOException;
import java.util.*;

public class BookController {

    public static Map<Integer, ArrayList<Category>> categoriesMap = new HashMap<>();
    public static Map<Category, List<Book>> booksMap = new HashMap<>();
    public static Map<String, List<Book>> booksByWriter = new HashMap<>();
    public static Map<String, List<Book>> booksByPublisher = new HashMap<>();
    public static Map<Integer, List<Book>> booksByPublishedYear = new HashMap<>();
    public static Map<String, List<Book>> bookByCode = new HashMap<>();
    public static Map<Character, List<Book>> bookByTitleFirstChar = new HashMap<>();
    public static final Map<String, List<Book>> chainYearByYearAndPublisher = new HashMap<>();
    private static final String PUBLISHER = "MAECENAS KÖNYVKIADÓ KFT.";


    public static void runFirst() throws IOException {
        FileHandler.readCategories();
        FileHandler.readBooks();
        FileHandler.readBooksByWriters();
        FileHandler.readBooksByPublisher();
        FileHandler.readBooksByPublishedYears();
        FileHandler.readBooksByCodes();
        FileHandler.readBooksByTitleFirstChar();
    }

    private static List<Book> findString(String text) {
        List<Book> booksContainsText = new ArrayList<>();
        for (List<Book> booksList : booksMap.values()) {
            for (Book book : booksList) {
                if (book.getTitle().contains(text)) {
                    booksContainsText.add(book);
                }
            }
        }
        return booksContainsText;
    }

    public static List<Book> runSecond() {
        String text = "Arab";
        return findString(text);
    }

    public static List<Book> runThird() {
        int num = 100;
        String text = String.valueOf(num);
        return findString(text);
    }

    private static List<Book> findBookByWriter(Map<Category, List<Book>> booksMap, String writer) {
        List<Book> booksByWriter = new ArrayList<>();
        for (List<Book> bookList : booksMap.values()) {
            for (Book book : bookList) {
                if (book.getWriter().equals(writer)) {
                    booksByWriter.add((book));
                }
            }
        }
        return booksByWriter;
    }

    public static List<Book> runFourth() {
        String writer = "Danielle Steel";
        return findBookByWriter(booksMap, writer);
    }

    public static Set<String> runFifth() {
        Set<String> writerHasTheMostBooks = new HashSet<>();
        for (List<Book> bookList : booksByWriter.values()) {
            for (Book book : bookList) {
                int max = findMaxValueWriter();
                if (bookList.size() == max) {
                    writerHasTheMostBooks.add(book.getWriter());
                }
            }
        }
        return writerHasTheMostBooks;
    }

    private static int findMaxValueWriter() {
        int max = 0;

        for (List<Book> bookList : booksByWriter.values()) {
            if (bookList.size() > max) {
                max = bookList.size();
            }
        }
        return max;
    }

    public static Set<String> runSixth() {
        Set<String> publisherHasTheMostBooks = new HashSet<>();

        for (List<Book> bookList : booksByPublisher.values()) {
            for (Book book : bookList) {
                int max = findMaxValuePublisher();
                if (bookList.size() == max) {
                    publisherHasTheMostBooks.add(book.getPublisher());
                }
            }
        }
        return publisherHasTheMostBooks;
    }

    private static int findMaxValuePublisher() {
        int max = 0;

        for (List<Book> bookList : booksByPublisher.values()) {
            if (bookList.size() > max) {
                max = bookList.size();
            }
        }
        return max;
    }

    public static List<Book> runSeventh() {
        List<Book> earliestPublishedBook = new ArrayList<>();

        for (List<Book> bookList : booksByPublishedYear.values()) {
            for (Book book : bookList) {
                int minYear = findMinValuePublishedYear();
                if (minYear == book.getPublication()) {
                    earliestPublishedBook.add(book);
                }
            }
        }
        return earliestPublishedBook;
    }

    private static int findMinValuePublishedYear() {
        int min = Integer.MAX_VALUE;

        for (Map.Entry<Integer, List<Book>> entry : booksByPublishedYear.entrySet()) {
            if (min > entry.getKey()) {
                min = entry.getKey();
            }
        }
        return min;
    }

    public static List<Book> runEighth() {
        List<Book> latestPublishedBook = new ArrayList<>();

        for (List<Book> bookList : booksByPublishedYear.values()) {
            for (Book book : bookList) {
                int maxYear = findMaxValuePublishedYear();
                if (maxYear == book.getPublication()) {
                    latestPublishedBook.add(book);
                }
            }
        }
        return latestPublishedBook;
    }

    private static int findMaxValuePublishedYear() {
        int max = 0;

        for (Map.Entry<Integer, List<Book>> entry : booksByPublishedYear.entrySet()) {
            if (max < entry.getKey()) {
                max = entry.getKey();
            }
        }
        return max;
    }

    public static Set<Category> runNinth() {
        Set<Category> mostBookByCategory = new HashSet<>();

        for (List<Book> bookList : booksMap.values()) {
            for (Book book : bookList) {
                int max = findMostBooks();
                if (max == bookList.size()) {
                    mostBookByCategory.add(book.getCategory());
                }
            }
        }
        return mostBookByCategory;
    }

    private static int findMostBooks() {
        int max = 0;

        for (Map.Entry<Category, List<Book>> entry : booksMap.entrySet()) {
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
            }
        }
        return max;
    }

    public static Set<Category> runTenth() {
        Set<Category> lessBookByCategory = new HashSet<>();

        for (List<Book> bookList : booksMap.values()) {
            for (Book book : bookList) {
                int min = findLessBooks();
                if (min == bookList.size()) {
                    lessBookByCategory.add(book.getCategory());
                }
            }
        }
        return lessBookByCategory;
    }

    private static int findLessBooks() {
        int min = Integer.MAX_VALUE;

        for (Map.Entry<Category, List<Book>> entry : booksMap.entrySet()) {
            if (entry.getValue().size() < min) {
                min = entry.getValue().size();
            }
        }
        return min;
    }

    public static List<Book> runEleventh() {
        List<Book> booksRunOut = new ArrayList<>();
        for (List<Book> bookList : booksMap.values()) {
            for (Book book : bookList) {
                if (book.isRunOut()) {
                    booksRunOut.add(book);
                }
            }
        }
        return booksRunOut;
    }

    public static List<Book> runExtraFirst() {
        List<Book> theMostFirstCharInSentence = new ArrayList<>();

        for (List<Book> bookList : bookByTitleFirstChar.values()) {
            for (Book book : bookList) {
                int max = findMaxChar();
                if (max == bookList.size()) {
                    theMostFirstCharInSentence.add(book);
                }
            }
        }
        return theMostFirstCharInSentence;
    }

    private static int findMaxChar() {
        int max = 0;

        for (Map.Entry<Character, List<Book>> entry : bookByTitleFirstChar.entrySet()) {
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
            }
        }
        return max;
    }

    public static List<Book> runExtraSecondByWriter() {
        return createListByWriter(booksMap, "Danielle Steel");
    }

    private static List<Book> createListByWriter(Map<Category, List<Book>> booksMap, String writer) {
        List<Book> bookListByWriter = new ArrayList<>();
        for (List<Book> bookList : booksMap.values()) {
            for (Book book : bookList) {
                if (book.getWriter().contains(writer)) {
                    bookListByWriter.add(book);
                }
            }
        }
        return bookListByWriter;
    }

    public static List<Book> runExtraSecondByPublisher() {
        return createListByPublisher(booksMap, "Álomgyár Kiadó");
    }

    private static List<Book> createListByPublisher(Map<Category, List<Book>> booksMap, String publisher) {
        List<Book> bookListByPublisher = new ArrayList<>();
        for (List<Book> bookList : booksMap.values()) {
            for (Book book : bookList) {
                if (book.getPublisher().contains(publisher)) {
                    bookListByPublisher.add(book);
                }
            }
        }
        return bookListByPublisher;
    }

    private static Map<Integer, List<String>> createByYearPublisher(String publisher) {
        Map<Integer, List<String>> yearAndPublisherMap = new HashMap<>();
        for (List<Book> bookList : booksMap.values()) {
            for (Book book : bookList) {
                if (book.getPublisher().equals(publisher)) {
                    yearAndPublisherMap.putIfAbsent(book.getPublication(), new ArrayList<>());
                    yearAndPublisherMap.get(book.getPublication()).add(book.getPublisher());
                }
            }
        }
        return yearAndPublisherMap;
    }

    public static void printSortedMap() {
        Map<Integer, List<String>> yearAndPublisherMap = createByYearPublisher("MAECENAS KÖNYVKIADÓ KFT.");
        for (Map.Entry<Integer, List<String>> entry : yearAndPublisherMap.entrySet())
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    }

    public static Map<String, List<Book>> runExtraThirdAVersion() {
        return different(findFirstYear());
    }

    public static List<String> runExtraThirdBVersion() {
        return createChainByPublisher(PUBLISHER);
    }

    private static List<String> createChainByPublisher(String publisher) {
        int startingYear = findFirstYear();
        int lastYear = findLastYear();
        int year;
        HashSet<String> chainWithWhileLoop = new HashSet<>();

        for (List<Book> bookList : booksMap.values()) {
            for (Book book : bookList) {
                if (book.getPublisher().equals(PUBLISHER)) {
                    do {
                        chainWithWhileLoop.add(book.getPublication() + ": " + book.getTitle());
                    }
                    while (startingYear < lastYear && checkingYearDifferent());
                }
            }
        }
        ArrayList<String> chainList = new ArrayList<>(chainWithWhileLoop);
        Collections.sort(chainList);
        for (int i = 0; i < chainList.size(); i++) {
            System.out.println(chainList.get(i));
        }
        return chainList;
    }

    private static Map<String, List<Book>> different(int min) {
        int startingYear = findFirstYear();
        int lastYear = findLastYear();
        startingYear = min;

        for (List<Book> bookList : booksByPublisher.values()) {
            for (Book book : bookList) {
                if (book.getPublisher().equals(PUBLISHER)) {
                    if (book.getPublication() == min) {
                        chainYearByYearAndPublisher.putIfAbsent(book.getPublisher(), new ArrayList<>());
                        chainYearByYearAndPublisher.get(book.getPublisher()).add(book);
                        if (!checkingYearDifferent()) {
                            min += 1;
                            if (toStopRecursion(startingYear, lastYear)) {
                                different(min);
                            }
                        }
                    }
                }
            }
        }
        return chainYearByYearAndPublisher;
    }

    private static boolean toStopRecursion(int startingYear, int lastYear) {
        return startingYear < (lastYear + 1 );
    }

    private static int findFirstYear() {
        int startingYear = Integer.MAX_VALUE;
        for (List<Book> bookList : booksMap.values()) {
            for (Book book : bookList) {
                if (book.getPublisher().equals(PUBLISHER)) {
                    if (book.getPublication() < startingYear) {
                        startingYear = book.getPublication();
                    }
                }
            }
        }
        return startingYear;
    }

    private static int findLastYear() {
        int lastYear = 0;
        for (List<Book> bookList : booksMap.values()) {
            for (Book book : bookList) {
                if (book.getPublisher().equals(PUBLISHER)) {
                    if (book.getPublication() > lastYear) {
                        lastYear = book.getPublication();
                    }
                }
            }
        }
        return lastYear;
    }

    private static boolean checkingYearDifferent() {
        int earliestYear = findMinValuePublishedYear();
        for (List<Book> bookList : booksMap.values()) {
            for (Book book : bookList) {
                if (book.getTitle().equals(PUBLISHER)) {
                    int nextYear = book.getPublication();
                    if ( (nextYear - earliestYear) == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
