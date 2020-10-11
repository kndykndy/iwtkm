package some.company;

import some.company.commands.Command;
import some.company.commands.CommandLineValidator;
import some.company.model.AbstractReadableEntity;
import some.company.repositories.BooksRepository;
import some.company.repositories.impl.ResourceBooksRepository;

/**
 * MainApp entry point for the whole application. Put your code into the main method.
 *
 * Application uses command line arguments to fulfil operations.
 * - without any arguments just a list of all entries is displayed
 * - with the -showordered argument, the list of ordered entries is displayed
 * - with the -getbyauthor={author} one may search for entries by author
 * - with the -getbyisbn={idbn} one may search for entry by a unique ISBN code
 */
@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class MainApp {

    public static void main(String[] args) {
        try {
            final Command command = CommandLineValidator.INSTANCE.validate(args);

            final BooksRepository<AbstractReadableEntity> repository = new ResourceBooksRepository();
            repository.readContents();

            command.execute(repository);
        } catch (RuntimeException re) {
            System.out.println("An unrecoverable error occurred: " + re.getMessage());

            re.printStackTrace();
        }
    }

}
