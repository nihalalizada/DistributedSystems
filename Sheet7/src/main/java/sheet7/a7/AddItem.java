package sheet7.a7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addItem")
public class AddItem extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<body>\n" +
                "\n" +
                "<h2>Add new Item</h2>\n" +
                "<title>Add Items</title>\n" +
                "<form action=\"addsuccess\" method = \"POST\">\n" +
                "  <label for=\"name\">Name:</label><br>\n" +
                "  <input type=\"text\" name=\"name\" ><br>\n" +
                "  <label for=\"price\">Price</label><br>\n" +
                "  <input type=\"text\" name=\"price\" ><br>\n" +
                "   <label for=\"qty\">Quantity</label><br>\n" +
                "  <input type=\"text\" name=\"qty\" ><br><br>\n" +
                "  <input type=\"submit\" value=\"Add\">\n" +
                "</form> \n" +
                "</body>");
    }
}
