package mx.edu.utez.SP_JPA.modules.region;

import jakarta.persistence.*;
import mx.edu.utez.SP_JPA.modules.cedi.BeanCedi;
import mx.edu.utez.SP_JPA.modules.verificentro.BeanVerificentro;

import java.util.List;

@Entity
@Table(name = "regiones")
public class BeanRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegion;
    
    @Column(nullable = false, length = 100)
    private String nombreRegion;
    
    @Column(columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean activo;
    
    // Relaciones
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanCedi> cedis;
    
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanVerificentro> verificentros;
    
    // Getters y Setters
    public Integer getIdRegion() { return idRegion; }
    public void setIdRegion(Integer idRegion) { this.idRegion = idRegion; }
    
    public String getNombreRegion() { return nombreRegion; }
    public void setNombreRegion(String nombreRegion) { this.nombreRegion = nombreRegion; }
    
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    
    public List<BeanCedi> getCedis() { return cedis; }
    public void setCedis(List<BeanCedi> cedis) { this.cedis = cedis; }
    
    public List<BeanVerificentro> getVerificentros() { return verificentros; }
    public void setVerificentros(List<BeanVerificentro> verificentros) { this.verificentros = verificentros; }
}

