package some.company.commands.impl;

import java.util.List;
import some.company.commands.Command;
import some.company.model.AbstractReadableEntity;
import some.company.repositories.BooksRepository;

public enum FindAllBooksOrderedCommand
    implements Command {

    INSTANCE;


    @Override
    public void execute(final BooksRepository<AbstractReadableEntity> repository) {
        if (repository != null && !repository.isEmpty()) {
            final List<AbstractReadableEntity> allBooksOrdered = repository.findAllBooksOrdered();
            System.out
                .println("All books and magazines, ordered (" + allBooksOrdered.size() + "):");
            for (final AbstractReadableEntity readableEntity : allBooksOrdered) {
                System.out.println(readableEntity);
            }
        } else {
            System.out.println("There are neither books nor magazines.");
        }
    }

}
