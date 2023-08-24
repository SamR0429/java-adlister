import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/count")


public class CounterServlet extends HttpServlet {

    public static int views = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        views++;

        res.getWriter().println("<h1>Hello counter</h1>" + views );
    }

}
