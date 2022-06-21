package servelets;

import java.io.PrintWriter;

public class Form3 {

  public void service(HttpServer)

  PrintWriter p = y.getWriter();

  p.printLn("You have entered the following");

  String name = r.getParameter("name");
  String sc = r.getParameter("school");
  
  
  p.println(name + "and "+ sc);
}
