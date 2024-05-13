package archive;
// TextResponseStrategy.java
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TextResponseStrategy implements ResponseStrategy {

    private final String answer;

    public TextResponseStrategy(String answer) {
        this.answer = answer;
    }

    @Override
    public void writeTo(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();
        writer.println(answer);
    }
}
