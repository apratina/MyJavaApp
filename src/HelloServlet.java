import java.io.*;
import java.util.Date;
import java.util.Properties;
import javax.servlet.http.*;
import javax.servlet.*;

public class HelloServlet extends HttpServlet {
  public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String myPkg = getProperty("packageName");
    String myStack = getProperty("stackName");
    PrintWriter out = res.getWriter();
    Date d = new Date();
    out.println("Hello World, Welcome to CDOT powered by C.IDE!!!");
    out.println("Current Time: " + d);
    out.println("Package Name: " + myPkg);
    out.println("Stack Name: " + myStack);
    out.close();
  }
  private String getProperty(String key) {
    String result = null;
    try {
      ServletContext servletContext = getServletContext();
      InputStream is = servletContext.getResourceAsStream("/WEB-INF/resources/config.properties");
      Properties props = new Properties();
      props.load(is);
      result = props.getProperty(key);
    }
    catch(Exception e) {
      e.printStackTrace();
      System.out.print("Error reading config.properties");
    }
    return result;
  }
}