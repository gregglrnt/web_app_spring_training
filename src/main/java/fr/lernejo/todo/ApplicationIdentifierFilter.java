package fr.lernejo.todo;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.UUID;

@Component
public class ApplicationIdentifierFilter implements Filter {
    String uuid = UUID.randomUUID().toString();

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        /** on appelle le filtre suivant en lui passant servletRequest
            et il récupère ensuite le return du filtre suivant
         *          x --------> F1 --------> F2 --------> Servlet
         *            <-------     <--------    <--------
         */

        if (servletResponse instanceof HttpServletResponse httpResponse) {
            httpResponse.setHeader("Instance-Id", uuid);
            /* revient à : ((HttpServletResponse) servletResponse).addHeader...
             mais sans cast */
        }

        filterChain.doFilter(servletRequest, servletResponse);


    }
}
