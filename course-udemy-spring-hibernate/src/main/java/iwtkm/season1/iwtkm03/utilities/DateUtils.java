package iwtkm.season1.iwtkm03.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

  private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

  public static Date parseDate(String dateStr) {
    Date date = null;
    try {
      date = formatter.parse(dateStr);
    } catch (ParseException pe) {
      pe.printStackTrace();
    }

    return date;
  }

  public static String formatDate(Date theDate) {
    String result = null;

    if (theDate != null) {
      result = formatter.format(theDate);
    }

    return result;
  }

}
