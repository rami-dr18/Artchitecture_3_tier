package Controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // HTML header
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Medical Cabinet</title>");
        out.println("<style>");
        out.println("body {");
        out.println("margin:0;}");
        out.println(".navbar {");
        out.println("    background-image:linear-gradient(to right, #000066 0%, #cc33ff 100%);");
        out.println("    text-align: center;");
       // out.println("    background-color: #f5f5f5;");
        out.println("    margin: 0;");
        out.println("    padding: 10px;");
        out.println("}");
        out.println(".navbar a {");
        out.println("    margin: 10px;");
        out.println("    text-decoration: none;");
        out.println("    color: white;");
        out.println("}");
        out.println("h2, p {");
        out.println("    text-align: center;");
        out.println("    font-size: 26px;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        // Navbar
        out.println("<div class=\"navbar\">");
        out.println("<h1 style=\" color:white;\">Medical Cabinet</h1>");
        out.println("<a href=\"/project3tier_part2/ord\" target=\"_blank\">Ordonnance</a>");
        out.println("<a href=\"/project3tier_part2/rdv\" target=\"_blank\">RDV</a>");
        out.println("<a href=\"/project3tier_part2/p\" target=\"_blank\">Patient</a>");
        out.println("</div>");

        // Body content
        out.println("<div class=\"medic\" style=\"margin: 200px 0 200px 0\">");
        out.println("<h2>Welcome to the Medical Cabinet!</h2>");
        out.println("<p>Here you can manage prescriptions, appointments, and patient information.</p>");
        out.println("</div>");

        // HTML footer
        out.println("</body>");
        out.println("</html>");
    }
}

