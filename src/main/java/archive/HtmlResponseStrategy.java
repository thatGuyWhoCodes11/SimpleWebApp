package archive;

// HtmlResponseStrategy.java
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HtmlResponseStrategy implements ResponseStrategy {

    private final String content;

    public HtmlResponseStrategy(String content) {
        this.content = content;
    }

    @Override
    public void writeTo(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head></head>");
        writer.println("<body>");
        writer.println(content);
        writer.println("</body>");
        writer.println("</html>");
    }
}
