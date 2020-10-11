package some.company;

public final class Constants {

    public static final String PARAM_SEPARATOR = "=";
    public static final char CSV_SEPARATOR = ';';
    private static final String PARAM_PREFIX = "-";
    public static final String SHOW_SORTED_ARG = PARAM_PREFIX + "showordered";
    public static final String GET_BY_AUTHOR = PARAM_PREFIX + "getbyauthor";
    public static final String GET_BY_ISBN = PARAM_PREFIX + "getbyisbn";


    private Constants() {
        throw new IllegalStateException();
    }

}
