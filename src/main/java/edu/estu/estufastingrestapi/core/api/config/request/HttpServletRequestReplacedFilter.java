package edu.estu.estufastingrestapi.core.api.config.request;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HttpServletRequestReplacedFilter implements Filter {

    @Override
    public void destroy() {
        // TODO document why this method is empty
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if (request instanceof HttpServletRequest httpServletRequest)
            requestWrapper = new RequestReaderHttpServletRequestWrapper(httpServletRequest);
        // Get the stream in the request, convert the fetched string into a stream, and put it into the new request object.
        // Pass the new request object in the chain.doFiler method
        chain.doFilter(requestWrapper == null ? request : requestWrapper, response);
    }

    @Override
    public void init(FilterConfig arg0) {
        // Do nothing
    }

}