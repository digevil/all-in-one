package org.digevil.serviceboot3.config.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class TidFilter implements Filter {

    public static final String TID_KEY = "tid";
    private static final String TRACE_ID_HEADER = "X-Trace-Id";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Get the trace ID from the request header, or generate a new one
        String traceId = httpRequest.getHeader(TRACE_ID_HEADER);
        if (traceId == null || traceId.isEmpty()) {
            traceId = UUID.randomUUID().toString();
        }

        // Set the trace ID in the MDC
        MDC.put(TID_KEY, traceId);

        try {
            chain.doFilter(request, response);
        } finally {
            // Clear the MDC after processing
            MDC.remove(TID_KEY);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
