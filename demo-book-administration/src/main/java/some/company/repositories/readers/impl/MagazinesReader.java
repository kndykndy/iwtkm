package some.company.repositories.readers.impl;

import java.util.Map;
import some.company.Utilities;
import some.company.model.AbstractReadableEntity;
import some.company.model.MagazineEntity;
import some.company.repositories.readers.AbstractReader;

public class MagazinesReader
    extends AbstractReader {

    @Override
    protected AbstractReadableEntity readImpl(
        final String rowStr, final Map<String, Integer> headers) {

        return MagazineEntity.fromRowData(Utilities.splitCsvRow(rowStr), headers);
    }

}
