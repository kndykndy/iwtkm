package some.company.commands.impl;

import com.google.common.base.Strings;
import java.util.List;
import some.company.commands.Command;
import some.company.model.AbstractReadableEntity;
import some.company.repositories.BooksRepository;

public class FindBookByAuthorCommand
    implements Command {

    private final String author;


    public FindBookByAuthorCommand(final String author) {
        this.author = author;
    }

    @Override
    public void execute(final BooksRepository<AbstractReadableEntity> repository) {
        if (Strings.isNullOrEmpty(author)) {
            throw new RuntimeException("No author provided.");
        }

        final List<AbstractReadableEntity> booksByAuthor = repository.findBooksByAuthor(author);
        if (booksByAuthor != null && !booksByAuthor.isEmpty()) {
            System.out.println("All books and magazines by " + author
                + " (" + booksByAuthor.size() + "):");
            for (final AbstractReadableEntity readableEntity : booksByAuthor) {
                System.out.println(readableEntity);
            }
        } else {
            System.out.println("There are no books by " + author + ".");
        }
    }

}
