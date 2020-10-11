package some.company.repositories;

import java.util.List;
import some.company.model.AbstractReadableEntity;

public interface BooksRepository<T extends AbstractReadableEntity> {

    boolean isEmpty();

    List<T> findAllBooks();

    List<T> findAllBooksOrdered();

    List<T> findBooksByAuthor(String author);

    T findBookByIsbn(String isbn);

    void readContents();

}
