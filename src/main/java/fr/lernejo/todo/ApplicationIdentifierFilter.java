package fr.lernejo.todo;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.UUID;

@Component
public class ApplicationIdentifierFilter implements Filter {
    String uuid;

    public ApplicationIdentifierFilter() {
        super();
        this.uuid = UUID.randomUUID().toString();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletResponse instanceof HttpServletResponse httpServletResponse) {
            httpServletResponse.setHeader("Instance-Id", uuid);
        }
    }
}
