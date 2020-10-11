package some.company.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;
import java.util.Map;
import some.company.Utilities;

public class BookEntity
    extends AbstractReadableEntity {

    private String description;


    public BookEntity(final List<String> rawData, final Map<String, Integer> headers) {
        super(rawData, headers);
    }

    public static AbstractReadableEntity fromRowData(
        final List<String> rowData, final Map<String, Integer> headers) {

        final BookEntity result = new BookEntity(rowData, headers);

        result.setDescription(getParamSafe(rowData, headers, "description"));

        return result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        BookEntity that = (BookEntity) o;
        return Objects.equal(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), description);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("title", title)
            .add("isbn", isbn)
            .add("authors", authors)
            .add("description", Utilities.getCroppedString(description, 50))
            .toString();
    }

}
