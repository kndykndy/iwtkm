package some.company.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.List;
import java.util.Map;

public class MagazineEntity
    extends AbstractReadableEntity {

    private String publishedAt;


    public MagazineEntity(final List<String> rowData, final Map<String, Integer> headers) {
        super(rowData, headers);
    }

    public static AbstractReadableEntity fromRowData(
        final List<String> rowData, final Map<String, Integer> headers) {

        final MagazineEntity result = new MagazineEntity(rowData, headers);

        result.setPublishedAt(getParamSafe(rowData, headers, "publishedAt"));

        return result;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
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
        MagazineEntity that = (MagazineEntity) o;
        return Objects.equal(publishedAt, that.publishedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), publishedAt);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("title", title)
            .add("isbn", isbn)
            .add("authors", authors)
            .add("publishedAt", publishedAt)
            .toString();
    }

}
