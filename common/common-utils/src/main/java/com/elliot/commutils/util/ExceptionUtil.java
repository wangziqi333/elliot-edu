package com.elliot.commutils.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {

  public static String getMessage(Exception e) {
    try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw);) {
      e.printStackTrace(pw);
      return sw.toString();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return null;
  }
}
