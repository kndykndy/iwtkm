package some.company.repositories.readers;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import some.company.Utilities;
import some.company.model.AbstractReadableEntity;

public abstract class AbstractReader {

    public void read(final File file, final Set<AbstractReadableEntity> readableEntities) {
        Preconditions.checkNotNull(file);
        Preconditions.checkArgument(file.exists() && file.isFile());
        Preconditions.checkNotNull(readableEntities);

        try (final Scanner scanner = new Scanner(file)) {

            final Map<String, Integer> headers = new HashMap<>();

            int k = 0;
            String rowStr;

            while (scanner.hasNextLine()) {
                if (k++ == 0) { // skip first line
                    rowStr = scanner.nextLine();
                    if (Strings.isNullOrEmpty(rowStr)) {
                        throw new RuntimeException("First row must not be empty.");
                    }

                    int i = 0;
                    for (final String tmpHeader : Utilities.splitCsvRow(rowStr)) {
                        headers.put(tmpHeader, i++);
                    }

                    continue;
                }

                rowStr = scanner.nextLine();
                if (Strings.isNullOrEmpty(rowStr)) {
                    continue;
                }

                readableEntities.add(readImpl(rowStr, headers));
            }

            if (headers.isEmpty()) {
                throw new RuntimeException(file.getAbsolutePath() + " file is empty.");
            }
        } catch (IOException ioe) {
            throw new RuntimeException("Error while reading books.csv", ioe);
        }
    }

    protected abstract AbstractReadableEntity readImpl(String rowStr, Map<String, Integer> headers);

}
