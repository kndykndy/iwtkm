package some.company.repositories.impl;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import some.company.Utilities;
import some.company.model.AbstractReadableEntity;
import some.company.repositories.BooksRepository;
import some.company.repositories.readers.impl.BooksReader;
import some.company.repositories.readers.impl.MagazinesReader;

public class ResourceBooksRepository
    implements BooksRepository<AbstractReadableEntity> {

    private final Set<AbstractReadableEntity> readableEntities = new HashSet<>();


    @Override
    public boolean isEmpty() {
        return readableEntities.isEmpty();
    }

    @Override
    public List<AbstractReadableEntity> findAllBooks() {
        return Lists.newLinkedList(readableEntities);
    }

    @Override
    public List<AbstractReadableEntity> findAllBooksOrdered() {
        return findAllBooks().stream()
            .sorted(Comparator.comparing(AbstractReadableEntity::getTitle))
            .collect(Collectors.toList());
    }

    @Override
    public List<AbstractReadableEntity> findBooksByAuthor(String author) {
        return readableEntities.stream().
            filter(readableEntity -> {
                Set<String> authors = readableEntity.getAuthors();
                return authors != null && !authors.isEmpty() && authors.contains(author);
            }).collect(Collectors.toList());
    }

    @Override
    public AbstractReadableEntity findBookByIsbn(final String isbn) {
        if (Strings.isNullOrEmpty(isbn)) {
            return null;
        }

        final List<AbstractReadableEntity> booksByIsbn = readableEntities.stream()
            .filter(readableEntity -> isbn.equalsIgnoreCase(readableEntity.getIsbn()))
            .collect(Collectors.toList());
        if (booksByIsbn.size() == 1) {
            return booksByIsbn.get(0);
        } else if (booksByIsbn.isEmpty()) {
            return null;
        } else {
            throw new RuntimeException(isbn + " ISBN code is not unique.");
        }
    }

    @Override
    public void readContents() {
        new BooksReader().read(
            Utilities.getResourceFileOrNull("some/company/assessment/data/books.csv"),
            readableEntities);
        new MagazinesReader().read(
            Utilities.getResourceFileOrNull("some/company/assessment/data/magazines.csv"),
            readableEntities);
    }

}
