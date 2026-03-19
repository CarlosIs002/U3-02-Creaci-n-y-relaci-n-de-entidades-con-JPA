package mx.edu.utez.SP_JPA.modules.verificacion;

import jakarta.persistence.*;
import mx.edu.utez.SP_JPA.modules.evaluacion.BeanEvaluacion;
import mx.edu.utez.SP_JPA.modules.nota.BeanNota;
import mx.edu.utez.SP_JPA.modules.vehiculo.BeanVehiculo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "verificaciones")
public class BeanVerificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVerificacion;
    
    @Enumerated(EnumType.STRING)
    private ENUM_MATERIA_VER materia;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal precio;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal multa;
    
    @Column(length = 50)
    private String folioVerificacion;
    
    private LocalDate fechaVerificacion;
    
    @Enumerated(EnumType.STRING)
    private ENUM_DICTAMEN dictamen;
    
    @Column(columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean activo;
    
    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_nota")
    private BeanNota nota;
    
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private BeanVehiculo vehiculo;
    
    @OneToMany(mappedBy = "verificacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanEvaluacion> evaluaciones;
    
    // Getters y Setters
    public Integer getIdVerificacion() { return idVerificacion; }
    public void setIdVerificacion(Integer idVerificacion) { this.idVerificacion = idVerificacion; }
    
    public ENUM_MATERIA_VER getMateria() { return materia; }
    public void setMateria(ENUM_MATERIA_VER materia) { this.materia = materia; }
    
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    
    public BigDecimal getMulta() { return multa; }
    public void setMulta(BigDecimal multa) { this.multa = multa; }
    
    public String getFolioVerificacion() { return folioVerificacion; }
    public void setFolioVerificacion(String folioVerificacion) { this.folioVerificacion = folioVerificacion; }
    
    public LocalDate getFechaVerificacion() { return fechaVerificacion; }
    public void setFechaVerificacion(LocalDate fechaVerificacion) { this.fechaVerificacion = fechaVerificacion; }
    
    public ENUM_DICTAMEN getDictamen() { return dictamen; }
    public void setDictamen(ENUM_DICTAMEN dictamen) { this.dictamen = dictamen; }
    
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    
    public BeanNota getNota() { return nota; }
    public void setNota(BeanNota nota) { this.nota = nota; }
    
    public BeanVehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(BeanVehiculo vehiculo) { this.vehiculo = vehiculo; }
    
    public List<BeanEvaluacion> getEvaluaciones() { return evaluaciones; }
    public void setEvaluaciones(List<BeanEvaluacion> evaluaciones) { this.evaluaciones = evaluaciones; }
}

