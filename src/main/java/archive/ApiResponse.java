package archive;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// ApiResponse.java
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApiResponse {

    private final ResponseStrategy responseStrategy;

    public ApiResponse(ResponseStrategy responseStrategy) {
        this.responseStrategy = responseStrategy;
    }

    public void writeTo(HttpServletResponse resp) throws IOException {
        responseStrategy.writeTo(resp);
    }
}
