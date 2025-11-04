package com.certicom.certifact_facturas_service_sp.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserModel {

    private Long idUser;
    private String dni;
    private Boolean enabled;
    private String estado;
    private String fullName;
    private String password;
    private String typeUser;
    private String deLogin;
    private Long codCompany;
    private Integer oficinaId;
    private Boolean changePass;
    private Boolean hidecomprobante;
    private Boolean pdfUnico;
    private LocalDateTime dateLastSeenNotifications;
    private Boolean viewCompra;

}
