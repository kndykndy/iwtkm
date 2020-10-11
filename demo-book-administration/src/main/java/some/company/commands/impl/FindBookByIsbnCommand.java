package some.company.commands.impl;

import com.google.common.base.Strings;
import some.company.commands.Command;
import some.company.model.AbstractReadableEntity;
import some.company.repositories.BooksRepository;

public class FindBookByIsbnCommand
    implements Command {

    private final String isbn;


    public FindBookByIsbnCommand(final String isbn) {
        this.isbn = isbn;
    }

    @Override
    public void execute(final BooksRepository<AbstractReadableEntity> repository) {
        if (Strings.isNullOrEmpty(isbn)) {
            throw new RuntimeException("No ISBN code provided.");
        }

        final AbstractReadableEntity bookByIsbn = repository.findBookByIsbn(isbn);
        if (bookByIsbn != null) {
            System.out.println("Book with " + isbn + " ISBN code:");
            System.out.println(bookByIsbn);
        } else {
            System.out.println("There's no book with " + isbn + " ISBN code.");
        }
    }

}
