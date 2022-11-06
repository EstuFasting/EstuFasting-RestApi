package edu.estu.estufastingrestapi.core.api.config.request;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class RequestReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private final byte[] body;

    public RequestReaderHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        body = HttpHelper.getBodyString(request).getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() {

        final ByteArrayInputStream stream = new ByteArrayInputStream(body);

        return new ServletInputStream() {

            @Override
            public int read() {
                return stream.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
                // TODO document why this method is empty
            }
        };
    }

}