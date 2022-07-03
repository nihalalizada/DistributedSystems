package sheet7.a7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/change")
public class Change extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println( "<title>Change</title>\n" +
                        "<form action=\"changed\" method = \"POST\">\n" +
                        "  <label for=\"name\">Name:</label><br>\n" +
                        "  <input type=\"text\" name=\"name\" ><br>\n" +
                        "  <label for=\"newQty\">New Quantity:</label><br>\n" +
                        "  <input type=\"text\" name=\"newQty\" ><br>\n" +
                        "  <input type=\"submit\" value=\"Change\">\n" +
                        "</body>"
        );
    }
}
