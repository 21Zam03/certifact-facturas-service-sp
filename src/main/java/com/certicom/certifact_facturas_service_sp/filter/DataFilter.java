package com.certicom.certifact_facturas_service_sp.filter;

import com.certicom.certifact_facturas_service_sp.enums.LogTitle;
import com.certicom.certifact_facturas_service_sp.util.LogHelper;
import com.certicom.certifact_facturas_service_sp.util.LogMessages;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DataFilter implements Filter {

    public static final String X_RUC_CLIENT = "X-User-Ruc";
    public static final String X_ID_USER = "X-User-Id";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String ruc = request.getHeader(X_RUC_CLIENT);
        String id = request.getHeader(X_ID_USER);

        if (ruc != null) {
            MDC.put("x_user_ruc", ruc);
        }

        if (id != null) {
            MDC.put("x_user_id", id);
        }

        try {
            LogHelper.infoLog(LogTitle.INFO.getType(), LogMessages.currentMethod(), "Incoming request ["+request.getMethod()+" "+request.getRequestURI()+"]");
            filterChain.doFilter(servletRequest, servletResponse);
            LogHelper.infoLog(LogTitle.INFO.getType(), LogMessages.currentMethod(), "Completed request: duration="+(System.currentTimeMillis() - startTime)+"ms");
        } finally {
            MDC.clear();
        }
    }
}
