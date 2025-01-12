package org.sparrow.common.tools.http;

import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletHttpUtil {

    public static void writeContextBody(HttpServletResponse servletResponse,String contextType,String message){
        writeContextBody(servletResponse, HttpServletResponse.SC_OK,contextType,message);
    }

    public static void writeContextBody(HttpServletResponse servletResponse,int code,String contextType,String message){
        try(PrintWriter writer = servletResponse.getWriter()) {
            servletResponse.setStatus(code);
            servletResponse.setContentType(contextType);
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
