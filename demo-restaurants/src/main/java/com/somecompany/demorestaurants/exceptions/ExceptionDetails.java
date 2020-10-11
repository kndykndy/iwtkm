package com.somecompany.demorestaurants.exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.http.HttpStatus;

public class ExceptionDetails {

  private static final SimpleDateFormat DATE_FORMAT =
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");

  private Date timestamp;
  private int code;
  private String status;
  private String details;


  public ExceptionDetails(final HttpStatus httpStatus, final String details) {
    this.timestamp = new Date();
    this.code = httpStatus.value();
    this.status = httpStatus.getReasonPhrase();
    this.details = details;
  }

  public String getTimestamp() {
    return DATE_FORMAT.format(timestamp);
  }

  public int getCode() {
    return code;
  }

  public String getStatus() {
    return status;
  }

  public String getDetails() {
    return details;
  }

}
