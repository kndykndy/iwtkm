package some.company;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import java.io.File;
import java.net.URL;
import java.util.List;

public final class Utilities {

    private Utilities() {
        throw new IllegalStateException();
    }

    public static String getParamValueOrNull(final String str) {
        String result = null;

        if (!Strings.isNullOrEmpty(str)) {
            final List<String> parts = Splitter.on(Constants.PARAM_SEPARATOR).splitToList(str);
            if (parts.size() == 2) {
                result = parts.get(1);
            }
        }

        return result;
    }

    public static File getResourceFileOrNull(final String resourcePath) {
        File result = null;

        final URL resource = Utilities.class.getClassLoader().getResource(resourcePath);
        if (resource != null) {
            result = new File(resource.getFile());
        }

        return result;
    }

    public static List<String> splitCsvRow(final String csvRow) {
        return Splitter.on(Constants.CSV_SEPARATOR).trimResults().splitToList(csvRow);
    }

    public static String getCroppedString(final String str, final int maxSize) {
        if (Strings.isNullOrEmpty(str) || maxSize < 0 || maxSize > str.length()) {
            return str;
        }

        return str.substring(0, maxSize);
    }

}
