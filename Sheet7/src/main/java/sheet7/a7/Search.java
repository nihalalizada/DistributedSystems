package sheet7.a7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/search")
public class Search extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<body>\n" +
                "\n" +
                "<h2>Search Items</h2>\n" +
                "<title>Search</title>\n" +
                "<form action=\"searchresult\" method = \"POST\">\n" +
                "  <label for=\"name\">Name:</label><br>\n" +
                "  <input type=\"text\" name=\"name\" ><br>\n" +
                "  <input type=\"submit\" value=\"Search\">\n" +
                "</body"
        );
    }
}
