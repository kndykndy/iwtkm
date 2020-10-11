package some.company.commands;

import some.company.model.AbstractReadableEntity;
import some.company.repositories.BooksRepository;

public interface Command {

    void execute(final BooksRepository<AbstractReadableEntity> repository);

}
