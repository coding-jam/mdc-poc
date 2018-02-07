package it.codingjam.mdcpoc.filters;

import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

@WebFilter(urlPatterns = "*")
public class LogEnricherFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            String logData = String.format("[IP: %s | REQ_ID: %s]", servletRequest.getRemoteAddr(), UUID.randomUUID().toString());
            MDC.put("logData", logData);
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.clear();
        }
    }

    @Override
    public void destroy() {

    }
}
