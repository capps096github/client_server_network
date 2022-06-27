package servelets;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FormServelet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String formHtml = "<!DOCTYPE html>"
        + "<html lang='en'>"
        + "<head>"
        + "<meta charset='UTF-8' />"
        + "<meta http-equiv='X-UA-Compatible' content='IE=edge' />"
        + "<meta name='viewport' content='width=device-width, initial-scale=1.0' />"
        + " <title>Java Servelet Form</title>"
        + " </head>"
        + "<body>"
        + "<h1>Java Servelet Sample</h1>"

        + "<p>Choose an option From the dropdown below</p>"
        + " <!-- form -->"
        + " <form action='#' method='post'  >"

        + "  <select id='option' name='options' title='options'>"

        + "<option value='create_session'>Create Session</option>"
        + " <option value='create_cookie'>Create Cookie</option>"
        + "<option value='check_cookie_exists'>Check if Cookie Exists</option>"
        + "<option value='remove_session_variables'> Remove Session Variables</option>"
        + " <option value='show_cookies_attributes'> Show Cookies and Session Attributes </option>"

        + " </select>"
        + " </form>"
        + " </body>"
        + "</html>";

    out.println(formHtml);
    out.close();


    //

  }

  // function to create a cookie
  public void createCookie(HttpServletRequest request, HttpServletResponse response) {
    String name = request.getParameter("height");
    if (name != null && name.length() > 0) {
      String value = request.getParameter("cookieValue");
      Cookie cookie = new Cookie(name, value);
      response.addCookie(cookie);
    }
  }

  // show cookie and session attributes
  public void showCookieSesssions() {

  }

}