import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pizza-order")

public class Pizza extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/pizza.jsp").forward(req, res);
    }


    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res) {
        String crust = req.getParameter("crusttype");
        String sauce = req.getParameter("saucelevel");
        String cheese = req.getParameter("cheeseamount");
        String [] addons = req.getParameterValues("addons");


        System.out.println(crust);
        System.out.println(sauce);
        System.out.println(cheese);
        System.out.println(addons.toString());

    }

}
