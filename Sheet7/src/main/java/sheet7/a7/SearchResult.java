package sheet7.a7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static sheet7.a7.WebStart.laptop;

@WebServlet("/searchresult")
public class SearchResult extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String Namen = request.getParameter("name");
        //HttpSession session = request.getSession();
        //Basket basket = (Basket) session.getAttribute("basket");

        Items items = laptop.searchItems(Namen);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<body>\n" +
        "\n" +
                "<h2>Search Result</h2>\n" +
                "<title>Search</title>\n" +
                "  <label for=\"name\">Name: " +items.getName()+" </label><br>\n" +
                "  <label for=\"price\">Price: " +items.getPrice()+" </label><br>\n" +
                "  <label for=\"quantity\">Quantity: " +items.getQty()+" </label><br>\n" +
                "</body");
    }
}
