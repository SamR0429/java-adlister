import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/hello")

public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.getWriter().println("<h1>Enter you name below :</h1><form action='/hello'><input name='name'><button>Submit</button></form><a href='/hello'><button>Reset</button></a> ");


        String name = req.getParameter("name");
        if (name != null) {
            res.getWriter().println("<h1> Hello " + name + " !</h1>");
        } else {
            res.getWriter().println("<h1>Hello</h1>");
        }
    }
}
