package com.certicom.certifact_facturas_service_sp.dto.model;

import com.certicom.certifact_facturas_service_sp.dto.others.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentVoucherDto {

    private Long idPaymentVoucher;

    private String tipoComprobante;
    private String serie;
    private Integer numero;
    private String fechaEmision;
    private String horaEmision;
    private String fechaVencimiento;
    private String codigoMoneda;
    private String codigoTipoOperacion;
    private String codigoTipoOperacionCatalogo51;
    private String rucEmisor;
    private String direccionOficinaEmisor;
    private String codigoLocalAnexoEmisor;
    private String tipoDocumentoReceptor;
    private String numeroDocumentoReceptor;
    private String denominacionReceptor;
    private String direccionReceptor;
    private String emailReceptor;
    private List<GuiaRelacionada> guiasRelacionadas;
    private List<DocumentoRelacionado> documentosRelacionados;
    private List<Leyenda> leyendas;
    private String serieNumeroOtroDocumentoRelacionado;
    private String codigoTipoOtroDocumentoRelacionado;
    private BigDecimal totalValorVentaExportacion;
    private BigDecimal totalValorVentaGravada;
    private BigDecimal totalValorVentaGravadaIVAP;
    private BigDecimal totalValorVentaInafecta;
    private BigDecimal totalValorVentaExonerada;
    private BigDecimal totalValorVentaGratuita;
    private BigDecimal totalValorBaseOtrosTributos;
    private BigDecimal totalValorBaseIsc;
    private BigDecimal totalIgv;
    private BigDecimal totalIvap;
    private BigDecimal totalIsc;
    private BigDecimal totalImpOperGratuita;
    private BigDecimal totalOtrostributos;
    private BigDecimal totalDescuento;
    private BigDecimal descuentoGlobales;
    private BigDecimal sumatoriaOtrosCargos;
    private BigDecimal totalAnticipos;
    private BigDecimal importeTotalVenta;
    private String serieAfectado;
    private Integer numeroAfectado;
    private String tipoComprobanteAfectado;
    private String codigoTipoNotaCredito;
    private String codigoTipoNotaDebito;
    private String motivoNota;
    private List<ComprobanteItem> items;
    private String denominacionEmisor;
    private String nombreComercialEmisor;
    private String tipoDocumentoEmisor;
    private String identificadorDocumento;
    private String ordenCompra;
    private List<Anticipo> anticipos;
    private List<CampoAdicional> camposAdicionales;
    private List<ComprobanteCuota> cuotas;
    private String codigoBienDetraccion;
    private BigDecimal porcentajeDetraccion;
    private BigDecimal porcentajeRetencion;
    private String cuentaFinancieraBeneficiario;
    private String codigoMedioPago;
    private BigDecimal montoDetraccion;
    private BigDecimal montoRetencion;
    private String detraccion;
    private String UblVersion;
    private String codigoHash;
    private Integer oficinaId;
    private Integer retencion;
    private BigDecimal tipoTransaccion;
    private BigDecimal montoPendiente;
    private BigDecimal cantidadCuotas;
    private BigDecimal pagoCuenta;

    private BranchOffice branchOffice;
    private String idpay;

    private String estado;
    private String estadoAnterior;
    private Integer estadoItem;
    private String estadoSunat;
    private String mensajeRespuesta;
    private Timestamp fechaRegistro;
    private String userName;
    private Timestamp fechaModificacion;
    private String userNameModificacion;
    private String codigoTipoDocumentoRelacionado;
    private String serieNumeroDocumentoRelacionado;
    private String Uuid;
    private Date fechaEmisionDate;

    private List<PaymentVoucherFile> paymentVoucherFileList;

}
