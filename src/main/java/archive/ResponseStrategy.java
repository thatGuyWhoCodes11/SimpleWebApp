package archive;
// ResponseStrategy.java
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ResponseStrategy {
    void writeTo(HttpServletResponse resp) throws IOException;
}
