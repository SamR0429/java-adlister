import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/color")

public class Color extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        String colorPicked = req.getParameter("colorPicked");

        System.out.println(colorPicked);

        req.setAttribute("color",colorPicked);


    }

}
