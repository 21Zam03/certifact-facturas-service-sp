package com.certicom.certifact_facturas_service_sp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelper {

    private static final Logger log = LoggerFactory.getLogger(LogHelper.class);

    private static Logger getLogger() {
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        return LoggerFactory.getLogger(className);
    }

    public static void warnLog(String title, String currentMethod, String detail) {
        getLogger().warn(LogTemplates.WARN_LOG_TEMPLATE,
                title,
                currentMethod,
                detail);
    }

    public static void infoLog(String title, String currentMethod, String detail) {
        getLogger().info(LogTemplates.INFO_LOG_TEMPLATE,
                title,
                currentMethod,
                detail);
    }

    public static void errorLog(String title, String currentMethod, String detail, Throwable e) {
        getLogger().error(LogTemplates.ERROR_LOG_TEMPLATE,
                title,
                currentMethod,
                detail,
                e);
    }

}
