package com.yfy.beem.serverv2.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
public class RequestInterceptor implements HandlerInterceptor {
    private FileWriter writer;

    public RequestInterceptor()  {
        try {
            writer = new FileWriter("accessedIps.txt", true);
        } catch (IOException e) {
            log.error("error in creating FileWriter", e);
        }
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        writer.write("req at " + LocalDateTime.now() + " : " + request.getRemoteAddr() + " " + request.getRemotePort() + "\n");
        writer.flush();
        log.info("accessed by : {}" + request.getRemoteAddr());
        return true;
    }


}
