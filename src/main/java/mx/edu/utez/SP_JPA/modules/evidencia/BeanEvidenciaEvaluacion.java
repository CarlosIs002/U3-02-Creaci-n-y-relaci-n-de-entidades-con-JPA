package mx.edu.utez.SP_JPA.modules.evidencia;

import jakarta.persistence.*;
import mx.edu.utez.SP_JPA.modules.evaluacion.BeanEvaluacion;

import java.time.LocalDateTime;

@Entity
@Table(name = "evidencias_evaluacion")
public class BeanEvidenciaEvaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvidencia;
    
    @Column(nullable = false, length = 100)
    private String campoEvaluado;
    
    @Lob
    @Column(columnDefinition = "LONGBLOB", nullable = false)
    private byte[] foto;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaSubida;
    
    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_evaluacion")
    private BeanEvaluacion evaluacion;
    
    @PrePersist
    protected void onCreate() {
        fechaSubida = LocalDateTime.now();
    }
    
    // Getters y Setters
    public Integer getIdEvidencia() { return idEvidencia; }
    public void setIdEvidencia(Integer idEvidencia) { this.idEvidencia = idEvidencia; }
    
    public String getCampoEvaluado() { return campoEvaluado; }
    public void setCampoEvaluado(String campoEvaluado) { this.campoEvaluado = campoEvaluado; }
    
    public byte[] getFoto() { return foto; }
    public void setFoto(byte[] foto) { this.foto = foto; }
    
    public LocalDateTime getFechaSubida() { return fechaSubida; }
    public void setFechaSubida(LocalDateTime fechaSubida) { this.fechaSubida = fechaSubida; }
    
    public BeanEvaluacion getEvaluacion() { return evaluacion; }
    public void setEvaluacion(BeanEvaluacion evaluacion) { this.evaluacion = evaluacion; }
}

