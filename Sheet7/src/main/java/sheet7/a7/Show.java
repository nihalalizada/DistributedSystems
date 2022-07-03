package sheet7.a7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import static sheet7.a7.WebStart.laptop;

@WebServlet("/show")
public class Show extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Basket basket = new Basket("test");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<title> Show all Items </title>"  +
                "<h2> Show all items </h2>");

        Set<Items> items = laptop.getItems();
        for (Items curItems : items) {
            out.println("<p>\n" +
                    "Name: " + curItems.getName() + "<br>\n" +
                    "Price: " + curItems.getPrice()+ "<br>\n" +
                    "Quantity: " + curItems.getQty()+  "<br>\n" +
                    "</p>");
    }
    }
}
