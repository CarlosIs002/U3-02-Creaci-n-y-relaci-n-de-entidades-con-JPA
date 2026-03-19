package mx.edu.utez.SP_JPA.modules.usuario;

import jakarta.persistence.*;
import mx.edu.utez.SP_JPA.modules.costo.BeanCosto;
import mx.edu.utez.SP_JPA.modules.evaluacion.BeanEvaluacion;
import mx.edu.utez.SP_JPA.modules.nota.BeanNota;
import mx.edu.utez.SP_JPA.modules.transaccion.BeanTransaccion;

import java.util.List;

@Entity
@Table(name = "usuarios")
public class BeanUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    
    @Column(nullable = false, length = 50)
    private String nombreUsuario;
    
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    
    @Column(nullable = false, length = 255)
    private String contrasena;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ENUM_TIPO_USUARIO tipoUsuario;
    
    @Column(columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean activo;
    
    // Relaciones
    @OneToMany(mappedBy = "encargado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanCosto> costosComoEncargado;
    
    @OneToMany(mappedBy = "atencionCobro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanCosto> costosComoAtencion;
    
    @OneToMany(mappedBy = "atendio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanNota> notasAtendidas;
    
    @OneToMany(mappedBy = "reviso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanNota> notasRevisadas;
    
    @OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanEvaluacion> evaluaciones;
    
    @OneToMany(mappedBy = "revisoTransaccion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanTransaccion> transaccionesRevisadas;
    
    @OneToMany(mappedBy = "atendioTransaccion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanTransaccion> transaccionesAtendidas;
    
    // Getters y Setters
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
    
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    
    public ENUM_TIPO_USUARIO getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(ENUM_TIPO_USUARIO tipoUsuario) { this.tipoUsuario = tipoUsuario; }
    
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    
    public List<BeanCosto> getCostosComoEncargado() { return costosComoEncargado; }
    public void setCostosComoEncargado(List<BeanCosto> costosComoEncargado) { this.costosComoEncargado = costosComoEncargado; }
    
    public List<BeanCosto> getCostosComoAtencion() { return costosComoAtencion; }
    public void setCostosComoAtencion(List<BeanCosto> costosComoAtencion) { this.costosComoAtencion = costosComoAtencion; }
    
    public List<BeanNota> getNotasAtendidas() { return notasAtendidas; }
    public void setNotasAtendidas(List<BeanNota> notasAtendidas) { this.notasAtendidas = notasAtendidas; }
    
    public List<BeanNota> getNotasRevisadas() { return notasRevisadas; }
    public void setNotasRevisadas(List<BeanNota> notasRevisadas) { this.notasRevisadas = notasRevisadas; }
    
    public List<BeanEvaluacion> getEvaluaciones() { return evaluaciones; }
    public void setEvaluaciones(List<BeanEvaluacion> evaluaciones) { this.evaluaciones = evaluaciones; }
    
    public List<BeanTransaccion> getTransaccionesRevisadas() { return transaccionesRevisadas; }
    public void setTransaccionesRevisadas(List<BeanTransaccion> transaccionesRevisadas) { this.transaccionesRevisadas = transaccionesRevisadas; }
    
    public List<BeanTransaccion> getTransaccionesAtendidas() { return transaccionesAtendidas; }
    public void setTransaccionesAtendidas(List<BeanTransaccion> transaccionesAtendidas) { this.transaccionesAtendidas = transaccionesAtendidas; }
}

