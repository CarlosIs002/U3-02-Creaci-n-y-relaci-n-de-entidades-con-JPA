package mx.edu.utez.SP_JPA.modules.verificentro;

import jakarta.persistence.*;
import mx.edu.utez.SP_JPA.modules.nota.BeanNota;
import mx.edu.utez.SP_JPA.modules.region.BeanRegion;

import java.util.List;

@Entity
@Table(name = "verificentros")
public class BeanVerificentro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVerificentro;
    
    @Column(length = 100)
    private String nombre;
    
    @Column(length = 50)
    private String claveVerificentro;
    
    @Column(length = 255)
    private String direccion;
    
    @Column(length = 100)
    private String responsable;
    
    @Column(length = 100)
    private String correo;
    
    @Column(length = 20)
    private String telefono;
    
    @Column(length = 20)
    private String telAlternativo;
    
    @Lob
    @Column(columnDefinition = "JSON")
    private String horario;
    
    @Column(columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean activo;
    
    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_region")
    private BeanRegion region;
    
    @OneToMany(mappedBy = "verificentro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanNota> notas;
    
    // Getters y Setters
    public Integer getIdVerificentro() { return idVerificentro; }
    public void setIdVerificentro(Integer idVerificentro) { this.idVerificentro = idVerificentro; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getClaveVerificentro() { return claveVerificentro; }
    public void setClaveVerificentro(String claveVerificentro) { this.claveVerificentro = claveVerificentro; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
    
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getTelAlternativo() { return telAlternativo; }
    public void setTelAlternativo(String telAlternativo) { this.telAlternativo = telAlternativo; }
    
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
    
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    
    public BeanRegion getRegion() { return region; }
    public void setRegion(BeanRegion region) { this.region = region; }
    
    public List<BeanNota> getNotas() { return notas; }
    public void setNotas(List<BeanNota> notas) { this.notas = notas; }
}

