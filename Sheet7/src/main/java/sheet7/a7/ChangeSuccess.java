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


@WebServlet("/changed")
public class ChangeSuccess extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String Itemname = request.getParameter("name");
        int newQty = Integer.parseInt(request.getParameter("newQty"));
        Items item = laptop.searchItems(Itemname);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (item != null) {
            int oldQty = item.getQty();
            item.setQty(newQty); //setter of Item's qty

            out.println("<title>Change</title>\n" +
                    "<h3> Quantity was changed successfully </h3>" +
                    " <p> Quantity of " + Itemname +
                    " was changed from " + oldQty +
                    " to " + newQty + " </p>\r\n");
        }
        else {
            out.println("<title>Change</title>\n" +
                   " <h3 style='color:red;'> Error!!</h3>"+
                    "<p> No such Item in this Basket </p>"
                    );

        }
    }
}
