package some.company.repositories.readers.impl;

import java.util.Map;
import some.company.Utilities;
import some.company.model.AbstractReadableEntity;
import some.company.model.BookEntity;
import some.company.repositories.readers.AbstractReader;

public class BooksReader
    extends AbstractReader {

    @Override
    protected AbstractReadableEntity readImpl(
        final String rowStr, final Map<String, Integer> headers) {

        return BookEntity.fromRowData(Utilities.splitCsvRow(rowStr), headers);
    }

}
