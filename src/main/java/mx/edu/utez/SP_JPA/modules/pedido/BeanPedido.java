package mx.edu.utez.SP_JPA.modules.pedido;

import jakarta.persistence.*;
import mx.edu.utez.SP_JPA.modules.nota.BeanNota;

import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
public class BeanPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;
    
    private LocalDate fechaEnvio;
    
    @Column(length = 100)
    private String numeroGuia;
    
    @Column(length = 100)
    private String recibio;
    
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] fotoEvidencia;
    
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('PENDIENTE', 'ENVIADO', 'ENTREGADO', 'INCIDENCIA') DEFAULT 'PENDIENTE'")
    private ENUM_ESTATUS_ENVIO estatusEnvio;
    
    @Column(length = 500)
    private String comentario;
    
    @Column(columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean activo;
    
    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_nota")
    private BeanNota nota;
    
    // Getters y Setters
    public Integer getIdPedido() { return idPedido; }
    public void setIdPedido(Integer idPedido) { this.idPedido = idPedido; }
    
    public LocalDate getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDate fechaEnvio) { this.fechaEnvio = fechaEnvio; }
    
    public String getNumeroGuia() { return numeroGuia; }
    public void setNumeroGuia(String numeroGuia) { this.numeroGuia = numeroGuia; }
    
    public String getRecibio() { return recibio; }
    public void setRecibio(String recibio) { this.recibio = recibio; }
    
    public byte[] getFotoEvidencia() { return fotoEvidencia; }
    public void setFotoEvidencia(byte[] fotoEvidencia) { this.fotoEvidencia = fotoEvidencia; }
    
    public ENUM_ESTATUS_ENVIO getEstatusEnvio() { return estatusEnvio; }
    public void setEstatusEnvio(ENUM_ESTATUS_ENVIO estatusEnvio) { this.estatusEnvio = estatusEnvio; }
    
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    
    public BeanNota getNota() { return nota; }
    public void setNota(BeanNota nota) { this.nota = nota; }
}

