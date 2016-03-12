package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Cookies")
public class Cookies extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public Cookies() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.write("<html>");
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            out.write("<p>No cookies found!</p><br/>");
        } else {
            for (Cookie retrievedCookies : cookies) {
                String name = retrievedCookies.getName();
                String value = retrievedCookies.getValue();
                out.write("<p>name: " + name + " ,value: " + value + "</p>");
            }
        }
        Cookie cookie = new Cookie("user","Vicky");
        cookie.setMaxAge(300);
        resp.addCookie(cookie);
        out.write("<p>Cookie set.</p><br/>");
        out.write("</html>");
    }
}
