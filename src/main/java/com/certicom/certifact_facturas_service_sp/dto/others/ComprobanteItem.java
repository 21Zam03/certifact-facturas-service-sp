package com.certicom.certifact_facturas_service_sp.dto.others;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComprobanteItem {

    private static final long serialVersionUID = 1L;

    private Long idComprobanteDetalle;
    private Long idPaymentVoucher;

    private Integer numeroItem;
    private String codigoUnidadMedida;

    private BigDecimal cantidad;
    private String descripcion;
    private String codigoProducto;
    private String codigoProductoSunat;
    private String codigoProductoGS1;
    private BigDecimal valorUnitario;
    private BigDecimal valorVenta;
    private BigDecimal descuento;
    private String codigoDescuento;
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
    private BigDecimal igv;
    private BigDecimal isc;
    private BigDecimal montoIcbper;
    private BigDecimal montoBaseIcbper;
    private BigDecimal ivap;
    private BigDecimal impuestoVentaGratuita;
    private BigDecimal otrosTributos;
    private BigDecimal porcentajeIgv;
    private BigDecimal porcentajeIvap;
    private BigDecimal porcentajeIsc;
    private BigDecimal porcentajeOtrosTributos;
    private BigDecimal porcentajeTributoVentaGratuita;
    private String codigoTipoAfectacionIGV;
    private String codigoTipoCalculoISC;
    private Long productoId;

    //DETRACCION 027

    private String detalleViajeDetraccion;
    private String ubigeoOrigenDetraccion;
    private String direccionOrigenDetraccion;
    private String ubigeoDestinoDetraccion;
    private String direccionDestinoDetraccion;
    private BigDecimal valorServicioTransporte;
    private BigDecimal valorCargaEfectiva;
    private BigDecimal valorCargaUtil;

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

    private String estado;
}
