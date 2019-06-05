package by.javatr.yudenok.runner;

import by.javatr.yudenok.bean.*;
import by.javatr.yudenok.exception.ParserException;
import by.javatr.yudenok.exception.RepositoryException;
import by.javatr.yudenok.exception.ServiceException;
import by.javatr.yudenok.exception.SpecificatorException;
import by.javatr.yudenok.repository.impl.AlbumRepository;
import by.javatr.yudenok.repository.impl.BookRepository;
import by.javatr.yudenok.repository.Repository;
import by.javatr.yudenok.repository.impl.MagazineRepository;
import by.javatr.yudenok.repository.impl.albumMatch.ByAlbumAmoutOfPagesSpecification;
import by.javatr.yudenok.repository.impl.albumMatch.ByAlbumCompanysNameSpecification;
import by.javatr.yudenok.repository.impl.bookMatch.*;
import by.javatr.yudenok.repository.impl.magazineMatch.ByMagazineAmountOfPagesRangeSpecification;
import by.javatr.yudenok.repository.impl.magazineMatch.ByMagazineNameWordInTitleSpecification;
import by.javatr.yudenok.repository.impl.magazineMatch.ByMagazinePublishingHouseNameSpecification;
import by.javatr.yudenok.repository.impl.magazineMatch.ByMagazineTitleSpecification;
import by.javatr.yudenok.service.SorterService;
import by.javatr.yudenok.service.SumPagesByBookGenre;
import by.javatr.yudenok.service.factory.SorterFactory;
import by.javatr.yudenok.service.impl.sort.album.AlbumCompanysNameSort;
import by.javatr.yudenok.service.impl.sort.album.AlbumPagesAmountSort;
import by.javatr.yudenok.service.impl.sort.book.BookAuthorsSort;
import by.javatr.yudenok.service.impl.sort.book.BookPagesAmountSort;
import by.javatr.yudenok.service.impl.sort.book.BookTitleSort;
import by.javatr.yudenok.service.impl.sort.book.BookWritingYearSort;
import by.javatr.yudenok.service.impl.sort.magazine.MagazineAuthorsSort;
import by.javatr.yudenok.service.impl.sort.magazine.MagazinePagesAmountSort;
import by.javatr.yudenok.service.impl.sort.magazine.MagazinePublishingHouseSort;
import by.javatr.yudenok.service.impl.sort.magazine.MagazineTitleSort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class Run {
    public static void main(String[] args) throws RepositoryException, ParserException, IOException {
        Repository bookRepository = new BookRepository();
        Repository magazineRepository = new MagazineRepository();
        Repository albumRepository = new AlbumRepository();

        Book book = new Book(new Author("added","book"),"addedFromUser",BookGenre.COMEDY,2010,599);
        Album album = new Album("first",1499);
        Magazine magazine = new Magazine(new Author("added","magazine"),"addedFromUser",1588,"pubMag");

        try {
            System.out.println("Load from database...");

            bookRepository.read();
            magazineRepository.read();
            albumRepository.read();

            showAll();

            System.out.println("=================================");
            System.out.println("Add to repository...");

            bookRepository.add(book);
            magazineRepository.add(magazine);
            albumRepository.add(album);

            updateAll(bookRepository,albumRepository,magazineRepository);

            showAll();
            System.out.println("==============================");
            System.out.println("Remove added objects...");
            bookRepository.remove(book);
            albumRepository.remove(album);
            magazineRepository.remove(magazine);

            updateAll(bookRepository,albumRepository,magazineRepository);

            System.out.println("================================");

            try {
                System.out.println("Find books by title: ");
                System.out.println(bookRepository.find(new ByBookTitleSpecification("Methods_Of_Programming")));
                System.out.println("==========================");
                System.out.println("Find magazines by pages range: ");
                System.out.println(magazineRepository.find(new ByMagazineAmountOfPagesRangeSpecification(0,100)));
                System.out.println("===========================");
                System.out.println("Find albums by amount of Pages: ");
                System.out.println(albumRepository.find(new ByAlbumAmoutOfPagesSpecification(96)));
                System.out.println("=============================");
            }catch (SpecificatorException e){
                logger.error("Invalid specificator");
                System.err.println("Invalid specificator");
            }

            try {
                System.out.println("Sort albums by companys name: ");
                SorterFactory.sort(new AlbumCompanysNameSort());
                System.out.println(Library.getInstance().getAlbumList());
                System.out.println("=======================");
                System.out.println("Sort magazines by");
                SorterFactory.sort(new MagazineAuthorsSort());
                System.out.println(Library.getInstance().getMagazineList());
                System.out.println("======================");
                SorterFactory.sort(new BookPagesAmountSort());
                System.out.println(Library.getInstance().getBookList());
                System.out.println("=======================");
            } catch (ServiceException e) {
                logger.error("Invalid comporator");
            }

            System.out.println("=======================");
            try {
                System.out.println("Remove books where pages > 50 and < 1000");
                bookRepository.removeAll(new ByBookAmountOfPagesRangeSpecification(50,1000));
                System.out.println("Revome magazines where title contains word \"top\"");
                magazineRepository.removeAll(new ByMagazineNameWordInTitleSpecification("top"));
                System.out.println("Remove albums where amount of pages is 1499");
                albumRepository.removeAll(new ByAlbumAmoutOfPagesSpecification(1499));
                updateAll(bookRepository,albumRepository,magazineRepository);
            } catch (SpecificatorException e) {
                logger.error("Invalid specificator");
            }

            try {
                System.out.println("=======================");
                System.out.println("Sum of pages of books which have NON-FICTION genre: ");
                System.out.println(SumPagesByBookGenre.calculate(BookGenre.NONFICTION));
            } catch (ServiceException e) {
                logger.error("Unknown parameter");
            }
        } catch (RepositoryException e) {
            logger.error("Rep ex");
        } catch (IOException e) {
            logger.error("File not found");
            System.err.println("File not found");
            System.out.println(e);
        } catch (ParserException e) {
            logger.error("Wrong datas in file");
            System.err.println("Wrong datas in file");
        }
    }


    public static void updateAll(Repository bookRepository, Repository albumRepository, Repository magazineRepository) throws IOException {
        bookRepository.update();
        magazineRepository.update();
        albumRepository.update();
    }

    public static void showAll() {
        Library library = Library.getInstance();
        System.out.println("============================");
        System.out.println(library);
        System.out.println();
    }

    private static final Logger logger = LogManager.getLogger(Run.class);
}
