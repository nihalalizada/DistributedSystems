package sheet7.a7;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/start")
public class WebStart extends HttpServlet {

	public static Basket laptop;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
		laptop = new Basket("laptop");

		laptop.addItem("MacBook", 1299, 50);
		laptop.addItem("Dell", 850, 99);
		laptop.addItem("Lenovo", 700, 200);

		//HttpSession session = request.getSession(true);
		//session.setAttribute("basket", laptop);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();  //prints Text data to output Stream

		out.println("<title> Basket Management </title>" +
				"<h3> Welcome </h3> " +
				"<p> Choose a button </p>" +
				"<form action=\"search\" method=\"POST\">\n" +
				" <input type=\"submit\" value=\"Search for an Item\" /> \n </form>" +

				"<form action=\"addItem\" method=\"POST\">\n" +
				" <input type=\"submit\" value=\"Add new Item\"/> \n </form>" +

				"<form action=\"show\" method=\"POST\">\n" +
				" <input type=\"submit\" value=\"Show all Items\"/> </form>" +

				"<form action =\"change\" method=\"POST\"> \n" +
				"<input type=\"submit\" value=\"Change Quantity\" /> </form>"
		);
	}
}