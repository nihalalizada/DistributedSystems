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

@WebServlet("/addsuccess")
public class AddSuccess extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String ItemName = request.getParameter("name");
        double ItemPrice = Double.parseDouble(request.getParameter("price"));
        int ItemQuantity = Integer.parseInt(request.getParameter("qty"));

        laptop.addItem(ItemName, ItemPrice, ItemQuantity);

        PrintWriter out = response.getWriter();
        out.println("<body>\n" +
                "\n" +
                "<h2>Add new Item</h2>\n" +
                "<title>Added Items</title>\n" +
                "<form action=\"addsuccess\" method = \"POST\">\n" +
                "<p>Item added successfully</p>" +
                "  <p>Name: " +ItemName+ "</label><br>\n" +

                "  <p>Price: " +ItemPrice+ "</label><br>\n" +

                "   <p>Quantity: " +ItemQuantity+ "</label><br>\n" +

                "</form> \n" +
                "</body>");
    }

}

