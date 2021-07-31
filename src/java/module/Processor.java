package module;

import controller.BookController;
import model.Book;
import model.Category;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Processor {

    public static void run() {

        try {

            BookController.runFirst();
            List<Book> booksTitleContainsArab = BookController.runSecond();
            List<Book> booksTitleContains100 = BookController.runThird();
            List<Book> booksByWriter = BookController.runFourth();
            Set<String> writerHasTheMostBooks = BookController.runFifth();
            Set<String> publisherHasTheMostBooks = BookController.runSixth();
            List<Book> earliestPublishedBook = BookController.runSeventh();
            List<Book> latestPublishedBook = BookController.runEighth();
            Set<Category> mostBookByCategory = BookController.runNinth();
            Set<Category> lessBookByCategory = BookController.runTenth();
            List<Book> booksRunOut = BookController.runEleventh();

            List<Book> theMostFirstCharInSentence = BookController.runExtraFirst();
            List<Book> bookListByWriter = BookController.runExtraSecondByWriter();
            List<Book> bookListByPublisher = BookController.runExtraSecondByPublisher();
            // https://www.geeksforgeeks.org/sortedset-java-examples/ insted of map!
            Map<String, List<Book>> chainByYearsAndPublisherAVersion = BookController.runExtraThirdAVersion();
            List<String> chainByYearsAndPublisherBVersion = BookController.runExtraThirdBVersion();


        } catch (IOException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
