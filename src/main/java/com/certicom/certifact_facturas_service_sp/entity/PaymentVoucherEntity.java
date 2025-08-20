package com.certicom.certifact_facturas_service_sp.entity;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PaymentVoucherEntity {

    private Long idPaymentVoucher;
    private String serie;
    private Integer numero;
    private String fechaEmision;
    private Date fechaEmisionDate;
    private String horaEmision;
    private String tipoComprobante;
    private String codigoMoneda;
    private String fechaVencimiento;
    private String tipoOperacion;
    private String rucEmisor;
    private String codigoLocalAnexo;
    private String tipoDocIdentReceptor;
    private String numDocIdentReceptor;
    private String denominacionReceptor;
    private String direccionReceptor;
    private String emailReceptor;
    private String codigoTipoDocumentoRelacionado;
    private String serieNumeroDocumentoRelacionado;

    private BigDecimal totalValorVentaOperacionExportada;
    private BigDecimal totalValorVentaOperacionGravada;
    private BigDecimal totalValorVentaOperacionInafecta;
    private BigDecimal totalValorVentaOperacionExonerada;
    private BigDecimal totalValorVentaOperacionGratuita;
    private BigDecimal totalValorBaseIsc;
    private BigDecimal totalValorBaseOtrosTributos;
    private BigDecimal totalValorVentaGravadaIVAP;
    private BigDecimal totalDescuento;

    private BigDecimal sumatoriaTributosOperacionGratuita;
    private BigDecimal sumatoriaIvap;
    private BigDecimal sumatoriaIGV;
    private BigDecimal sumatoriaISC;
    private BigDecimal sumatoriaOtrosTributos;

    private BigDecimal montoDescuentoGlobal;
    private BigDecimal montoSumatorioOtrosCargos;
    private BigDecimal montoImporteTotalVenta;
    private BigDecimal montoTotalAnticipos;

    //Usado para Nota Credito/Debito
    private String serieAfectado;
    private Integer numeroAfectado;
    private String tipoComprobanteAfectado;
    private String motivoNota;
    private String codigoTipoNotaCredito;
    private String codigoTipoNotaDebito;

    private String identificadorDocumento;
    private Integer estadoItem;
    private String estadoSunat;
    private String estado;

    private String estadoAnterior;
    private String mensajeRespuesta;
    private Timestamp fechaRegistro;
    private Timestamp fechaModificacion;
    private String userName;
    private String userNameModify;

    private String motivoAnulacion;
    private String uuid;
    private String ordenCompra;
    private Integer estadoAnticipo;
    private String codigosRespuestaSunat;
    private String ublVersion;
    private Boolean boletaAnuladaSinEmitir;
    private String codigoHash;
    private String codigoMedioPago;
    private String cuentaFinancieraBeneficiario;
    private String codigoBienDetraccion;
    private BigDecimal porcentajeDetraccion;
    private BigDecimal porcentajeRetencion;
    private BigDecimal montoDetraccion;
    private BigDecimal montoRetencion;
    private String detraccion;
    private Integer retencion;
    private BigDecimal tipoTransaccion;
    private BigDecimal montoPendiente;
    private BigDecimal cantidadCuotas;
    private BigDecimal pagoCuenta;
    private Boolean pagado;
    private String identificadorBaja;

    private Integer oficinaId;

    private BranchOfficeEntity oficinaEntity;
    private List<PaymentVoucherFileEntity> comprobanteArchivoEntityList;
    private List<DetailsPaymentVoucherEntity> comprobanteDetalleEntityList;
    private List<AnticipoEntity> anticipoEntityList;
    private List<CuotasPaymentVoucherEntity> cuotasEntityList;
    private List<AditionalFieldEntity> comprobanteCampoAdicionalEntityList;
    private List<GuiaRelacionadaEntity> guiaRelacionadaEntityList;

}
