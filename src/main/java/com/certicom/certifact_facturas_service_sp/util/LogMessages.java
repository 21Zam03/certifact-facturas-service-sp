package com.certicom.certifact_facturas_service_sp.util;

public class LogMessages {

    public static final String ERROR_VALIDATION = "Error de validación";
    public static final String SUCCESS_GET = "Consulta exitosa";
    public static final String ERROR_UNEXPECTED = "Error inesperado en la capa de servicio";
    public static final String ERROR_DATABASE = "Error en base de datos";

    public static String currentMethod() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

}
