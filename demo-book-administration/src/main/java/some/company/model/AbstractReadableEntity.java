package some.company.model;

import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractReadableEntity {

    String title;
    String isbn;
    Set<String> authors;


    AbstractReadableEntity(final List<String> rowData, final Map<String, Integer> headers) {
        title = getParamSafe(rowData, headers, "\uFEFFtitle");
        isbn = getParamSafe(rowData, headers, "isbn");
        authors = new HashSet<>(
            Splitter.on(',').omitEmptyStrings().splitToList(
                getParamSafe(rowData, headers, "authors")));
    }

    static String getParamSafe(
        final List<String> rowData, final Map<String, Integer> headers, final String header) {

        String result = null;

        final Integer headerIdx = headers.get(header);
        if (headerIdx != null) {
            if (headerIdx >= 0 && headerIdx < rowData.size()) {
                result = rowData.get(headerIdx);
            }
        }

        return result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractReadableEntity that = (AbstractReadableEntity) o;
        return Objects.equal(title, that.title) &&
            Objects.equal(isbn, that.isbn) &&
            Objects.equal(authors, that.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, isbn, authors);
    }

}
