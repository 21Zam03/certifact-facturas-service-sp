package com.certicom.certifact_facturas_service_sp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailsPaymentVoucherEntity {

    private Long idComprobanteDetalle;
    private Long idPaymentVoucher;

    private Integer numeroItem;
    private BigDecimal cantidad;
    private String codigoUnidadMedida;

    private String descripcion;
    private String codigoProductoSunat;
    private String codigoProducto;
    private String codigoProductoGS1;

    private BigDecimal valorUnitario;

    private BigDecimal precioVentaUnitario;
    private BigDecimal valorReferencialUnitario;

    private BigDecimal montoBaseIgv;
    private BigDecimal montoBaseIvap;
    private BigDecimal montoBaseExportacion;
    private BigDecimal montoBaseExonerado;
    private BigDecimal montoBaseInafecto;
    private BigDecimal montoBaseGratuito;
    private BigDecimal montoBaseIsc;
    private BigDecimal montoBaseOtrosTributos;

    private BigDecimal tributoVentaGratuita;
    private BigDecimal otrosTributos;
    private BigDecimal ivap;


    private BigDecimal montoIcbper;
    private BigDecimal montoBaseIcbper;

    //hace referencia al tributo 1000
    private BigDecimal afectacionIGV;
    //hace referencia al tributo 2000
    private BigDecimal sistemaISC;

    private BigDecimal porcentajeIgv;
    private BigDecimal porcentajeIvap;
    private BigDecimal porcentajeIsc;
    private BigDecimal porcentajeOtrosTributos;
    private BigDecimal porcentajeTributoVentaGratuita;

    private String codigoTipoSistemaISC;
    private String codigoTipoAfectacionIGV;

    private BigDecimal valorVenta;
    private BigDecimal descuento;
    private String codigoDescuento;
    private String estado;

    //DETRACCION 027
    private String detalleViajeDetraccion;
    private String ubigeoOrigenDetraccion;
    private String direccionOrigenDetraccion;
    private String ubigeoDestinoDetraccion;
    private String direccionDestinoDetraccion;
    private BigDecimal valorServicioTransporte;
    private BigDecimal valorCargaEfectiva;
    private BigDecimal valorCargaUtil;

    //CAMPOS HIDROBIOLOGICOS
    private String hidroMatricula;
    private String hidroEmbarcacion;
    private String hidroDescripcionTipo;
    private String hidroLugarDescarga;
    private String hidroFechaDescarga;
    private String hidroCantidad;
    private String unidadManejo;
    private String instruccionesEspeciales;
    private String marca;
    private String adicional;

}
