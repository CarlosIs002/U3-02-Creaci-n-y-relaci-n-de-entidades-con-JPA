package mx.edu.utez.SP_JPA.modules.evaluacion;

import jakarta.persistence.*;
import mx.edu.utez.SP_JPA.modules.evidencia.BeanEvidenciaEvaluacion;
import mx.edu.utez.SP_JPA.modules.usuario.BeanUsuario;
import mx.edu.utez.SP_JPA.modules.verificacion.BeanVerificacion;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "evaluaciones")
public class BeanEvaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvaluacion;
    
    // A. LUCES
    @Column(length = 50)
    private String lucesGalibo;
    
    @Column(length = 50)
    private String lucesAltas;
    
    @Column(length = 50)
    private String lucesBajas;
    
    @Column(length = 50)
    private String lucesDemarcadorasDelanteras;
    
    @Column(length = 50)
    private String lucesDemarcadorasTraseras;
    
    @Column(length = 50)
    private String lucesIndicadoras;
    
    @Column(length = 50)
    private String faroIzquierdo;
    
    @Column(length = 50)
    private String faroDerecho;
    
    @Column(length = 50)
    private String lucesDirectionalesDelanteras;
    
    @Column(length = 50)
    private String lucesDirectionalesTraseras;
    
    // B. LLANTAS (RINES Y MASAS)
    @Column(length = 50)
    private String rinesDelanteros;
    
    @Column(length = 50)
    private String rinesTraseros;
    
    @Column(length = 50)
    private String masasDelanteras;
    
    @Column(length = 50)
    private String masasTraseras;
    
    private Integer presionIzqDel;
    private Integer presionDerDel;
    private Integer presionIzqTra1;
    private Integer presionIzqTra2;
    private Integer presionDerTra1;
    private Integer presionDerTra2;
    
    @Column
    private Double profIzqDel;
    
    @Column
    private Double profDerDel;
    
    @Column
    private Double profIzqTra1;
    
    @Column
    private Double profIzqTra2;
    
    @Column
    private Double profDerTra1;
    
    @Column
    private Double profDerTra2;
    
    @Column(length = 20)
    private String birlosIzqDelStatus;
    
    private Integer birlosIzqDelNum;
    
    @Column(length = 20)
    private String birlosDerDelStatus;
    
    private Integer birlosDerDelNum;
    
    @Column(length = 20)
    private String birlosIzqTraStatus;
    
    private Integer birlosIzqTraNum;
    
    @Column(length = 20)
    private String birlosDerTraStatus;
    
    private Integer birlosDerTraNum;
    
    @Column(length = 20)
    private String tuercasIzqDelStatus;
    
    private Integer tuercasIzqDelNum;
    
    @Column(length = 20)
    private String tuercasDerDelStatus;
    
    private Integer tuercasDerDelNum;
    
    @Column(length = 20)
    private String tuercasIzqTraStatus;
    
    private Integer tuercasIzqTraNum;
    
    @Column(length = 20)
    private String tuercasDerTraStatus;
    
    private Integer tuercasDerTraNum;
    
    // C, D, E, F. Resto de los campos
    @Column(length = 20)
    private String brazoPitman;
    
    @Column(length = 20)
    private String manijaPuertas;
    
    @Column(length = 20)
    private String chavetasStatus;
    
    private Integer chavetasNum;
    
    @Column(length = 20)
    private String compresor;
    
    @Column(length = 20)
    private String tanquesAire;
    
    private Integer airePsi;
    
    private Integer aireTiempoMin;
    
    @Column(length = 20)
    private String humo;
    
    @Column(length = 20)
    private String gobernado;
    
    @Column(length = 20)
    private String cajaDirection;
    
    @Column(length = 20)
    private String depositoAceite;
    
    @Column(length = 20)
    private String parabrisas;
    
    @Column(length = 20)
    private String limpiaparabrisas;
    
    @Column(length = 20)
    private String huelgoStatus;
    
    private Integer huelgoMm;
    
    @Column(length = 20)
    private String escape;
    
    @Lob
    @Column(columnDefinition = "TEXT")
    private String comentarios;
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCaptura;
    
    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_verificacion")
    private BeanVerificacion verificacion;
    
    @ManyToOne
    @JoinColumn(name = "id_tecnico")
    private BeanUsuario tecnico;
    
    @OneToMany(mappedBy = "evaluacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BeanEvidenciaEvaluacion> evidencias;
    
    @PrePersist
    protected void onCreate() {
        fechaCaptura = LocalDateTime.now();
    }
    
    // Getters y Setters
    public Integer getIdEvaluacion() { return idEvaluacion; }
    public void setIdEvaluacion(Integer idEvaluacion) { this.idEvaluacion = idEvaluacion; }
    
    public String getLucesGalibo() { return lucesGalibo; }
    public void setLucesGalibo(String lucesGalibo) { this.lucesGalibo = lucesGalibo; }
    
    public String getLucesAltas() { return lucesAltas; }
    public void setLucesAltas(String lucesAltas) { this.lucesAltas = lucesAltas; }
    
    public String getLucesBajas() { return lucesBajas; }
    public void setLucesBajas(String lucesBajas) { this.lucesBajas = lucesBajas; }
    
    public String getLucesDemarcadorasDelanteras() { return lucesDemarcadorasDelanteras; }
    public void setLucesDemarcadorasDelanteras(String lucesDemarcadorasDelanteras) { this.lucesDemarcadorasDelanteras = lucesDemarcadorasDelanteras; }
    
    public String getLucesDemarcadorasTraseras() { return lucesDemarcadorasTraseras; }
    public void setLucesDemarcadorasTraseras(String lucesDemarcadorasTraseras) { this.lucesDemarcadorasTraseras = lucesDemarcadorasTraseras; }
    
    public String getLucesIndicadoras() { return lucesIndicadoras; }
    public void setLucesIndicadoras(String lucesIndicadoras) { this.lucesIndicadoras = lucesIndicadoras; }
    
    public String getFaroIzquierdo() { return faroIzquierdo; }
    public void setFaroIzquierdo(String faroIzquierdo) { this.faroIzquierdo = faroIzquierdo; }
    
    public String getFaroDerecho() { return faroDerecho; }
    public void setFaroDerecho(String faroDerecho) { this.faroDerecho = faroDerecho; }
    
    public String getLucesDirectionalesDelanteras() { return lucesDirectionalesDelanteras; }
    public void setLucesDirectionalesDelanteras(String lucesDirectionalesDelanteras) { this.lucesDirectionalesDelanteras = lucesDirectionalesDelanteras; }
    
    public String getLucesDirectionalesTraseras() { return lucesDirectionalesTraseras; }
    public void setLucesDirectionalesTraseras(String lucesDirectionalesTraseras) { this.lucesDirectionalesTraseras = lucesDirectionalesTraseras; }
    
    public String getRinesDelanteros() { return rinesDelanteros; }
    public void setRinesDelanteros(String rinesDelanteros) { this.rinesDelanteros = rinesDelanteros; }
    
    public String getRinesTraseros() { return rinesTraseros; }
    public void setRinesTraseros(String rinesTraseros) { this.rinesTraseros = rinesTraseros; }
    
    public String getMasasDelanteras() { return masasDelanteras; }
    public void setMasasDelanteras(String masasDelanteras) { this.masasDelanteras = masasDelanteras; }
    
    public String getMasasTraseras() { return masasTraseras; }
    public void setMasasTraseras(String masasTraseras) { this.masasTraseras = masasTraseras; }
    
    public Integer getPresionIzqDel() { return presionIzqDel; }
    public void setPresionIzqDel(Integer presionIzqDel) { this.presionIzqDel = presionIzqDel; }
    
    public Integer getPresionDerDel() { return presionDerDel; }
    public void setPresionDerDel(Integer presionDerDel) { this.presionDerDel = presionDerDel; }
    
    public Integer getPresionIzqTra1() { return presionIzqTra1; }
    public void setPresionIzqTra1(Integer presionIzqTra1) { this.presionIzqTra1 = presionIzqTra1; }
    
    public Integer getPresionIzqTra2() { return presionIzqTra2; }
    public void setPresionIzqTra2(Integer presionIzqTra2) { this.presionIzqTra2 = presionIzqTra2; }
    
    public Integer getPresionDerTra1() { return presionDerTra1; }
    public void setPresionDerTra1(Integer presionDerTra1) { this.presionDerTra1 = presionDerTra1; }
    
    public Integer getPresionDerTra2() { return presionDerTra2; }
    public void setPresionDerTra2(Integer presionDerTra2) { this.presionDerTra2 = presionDerTra2; }
    
    public Double getProfIzqDel() { return profIzqDel; }
    public void setProfIzqDel(Double profIzqDel) { this.profIzqDel = profIzqDel; }
    
    public Double getProfDerDel() { return profDerDel; }
    public void setProfDerDel(Double profDerDel) { this.profDerDel = profDerDel; }
    
    public Double getProfIzqTra1() { return profIzqTra1; }
    public void setProfIzqTra1(Double profIzqTra1) { this.profIzqTra1 = profIzqTra1; }
    
    public Double getProfIzqTra2() { return profIzqTra2; }
    public void setProfIzqTra2(Double profIzqTra2) { this.profIzqTra2 = profIzqTra2; }
    
    public Double getProfDerTra1() { return profDerTra1; }
    public void setProfDerTra1(Double profDerTra1) { this.profDerTra1 = profDerTra1; }
    
    public Double getProfDerTra2() { return profDerTra2; }
    public void setProfDerTra2(Double profDerTra2) { this.profDerTra2 = profDerTra2; }
    
    public String getBirlosIzqDelStatus() { return birlosIzqDelStatus; }
    public void setBirlosIzqDelStatus(String birlosIzqDelStatus) { this.birlosIzqDelStatus = birlosIzqDelStatus; }
    
    public Integer getBirlosIzqDelNum() { return birlosIzqDelNum; }
    public void setBirlosIzqDelNum(Integer birlosIzqDelNum) { this.birlosIzqDelNum = birlosIzqDelNum; }
    
    public String getBirlosDerDelStatus() { return birlosDerDelStatus; }
    public void setBirlosDerDelStatus(String birlosDerDelStatus) { this.birlosDerDelStatus = birlosDerDelStatus; }
    
    public Integer getBirlosDerDelNum() { return birlosDerDelNum; }
    public void setBirlosDerDelNum(Integer birlosDerDelNum) { this.birlosDerDelNum = birlosDerDelNum; }
    
    public String getBirlosIzqTraStatus() { return birlosIzqTraStatus; }
    public void setBirlosIzqTraStatus(String birlosIzqTraStatus) { this.birlosIzqTraStatus = birlosIzqTraStatus; }
    
    public Integer getBirlosIzqTraNum() { return birlosIzqTraNum; }
    public void setBirlosIzqTraNum(Integer birlosIzqTraNum) { this.birlosIzqTraNum = birlosIzqTraNum; }
    
    public String getBirlosDerTraStatus() { return birlosDerTraStatus; }
    public void setBirlosDerTraStatus(String birlosDerTraStatus) { this.birlosDerTraStatus = birlosDerTraStatus; }

    public Integer getBirlosDerTraNum() { return birlosDerTraNum; }
    public void setBirlosDerTraNum(Integer birlosDerTraNum) { this.birlosDerTraNum = birlosDerTraNum; }
    
    public String getTuercasIzqDelStatus() { return tuercasIzqDelStatus; }
    public void setTuercasIzqDelStatus(String tuercasIzqDelStatus) { this.tuercasIzqDelStatus = tuercasIzqDelStatus; }
    
    public Integer getTuercasIzqDelNum() { return tuercasIzqDelNum; }
    public void setTuercasIzqDelNum(Integer tuercasIzqDelNum) { this.tuercasIzqDelNum = tuercasIzqDelNum; }
    
    public String getTuercasDerDelStatus() { return tuercasDerDelStatus; }
    public void setTuercasDerDelStatus(String tuercasDerDelStatus) { this.tuercasDerDelStatus = tuercasDerDelStatus; }
    
    public Integer getTuercasDerDelNum() { return tuercasDerDelNum; }
    public void setTuercasDerDelNum(Integer tuercasDerDelNum) { this.tuercasDerDelNum = tuercasDerDelNum; }
    
    public String getTuercasIzqTraStatus() { return tuercasIzqTraStatus; }
    public void setTuercasIzqTraStatus(String tuercasIzqTraStatus) { this.tuercasIzqTraStatus = tuercasIzqTraStatus; }
    
    public Integer getTuercasIzqTraNum() { return tuercasIzqTraNum; }
    public void setTuercasIzqTraNum(Integer tuercasIzqTraNum) { this.tuercasIzqTraNum = tuercasIzqTraNum; }
    
    public String getTuercasDerTraStatus() { return tuercasDerTraStatus; }
    public void setTuercasDerTraStatus(String tuercasDerTraStatus) { this.tuercasDerTraStatus = tuercasDerTraStatus; }
    
    public Integer getTuercasDerTraNum() { return tuercasDerTraNum; }
    public void setTuercasDerTraNum(Integer tuercasDerTraNum) { this.tuercasDerTraNum = tuercasDerTraNum; }
    
    public String getBrazoPitman() { return brazoPitman; }
    public void setBrazoPitman(String brazoPitman) { this.brazoPitman = brazoPitman; }
    
    public String getManijaPuertas() { return manijaPuertas; }
    public void setManijaPuertas(String manijaPuertas) { this.manijaPuertas = manijaPuertas; }
    
    public String getChavetasStatus() { return chavetasStatus; }
    public void setChavetasStatus(String chavetasStatus) { this.chavetasStatus = chavetasStatus; }
    
    public Integer getChavetasNum() { return chavetasNum; }
    public void setChavetasNum(Integer chavetasNum) { this.chavetasNum = chavetasNum; }
    
    public String getCompresor() { return compresor; }
    public void setCompresor(String compresor) { this.compresor = compresor; }
    
    public String getTanquesAire() { return tanquesAire; }
    public void setTanquesAire(String tanquesAire) { this.tanquesAire = tanquesAire; }
    
    public Integer getAirePsi() { return airePsi; }
    public void setAirePsi(Integer airePsi) { this.airePsi = airePsi; }
    
    public Integer getAireTiempoMin() { return aireTiempoMin; }
    public void setAireTiempoMin(Integer aireTiempoMin) { this.aireTiempoMin = aireTiempoMin; }
    
    public String getHumo() { return humo; }
    public void setHumo(String humo) { this.humo = humo; }
    
    public String getGobernado() { return gobernado; }
    public void setGobernado(String gobernado) { this.gobernado = gobernado; }
    
    public String getCajaDirection() { return cajaDirection; }
    public void setCajaDirection(String cajaDirection) { this.cajaDirection = cajaDirection; }
    
    public String getDepositoAceite() { return depositoAceite; }
    public void setDepositoAceite(String depositoAceite) { this.depositoAceite = depositoAceite; }
    
    public String getParabrisas() { return parabrisas; }
    public void setParabrisas(String parabrisas) { this.parabrisas = parabrisas; }
    
    public String getLimpiaparabrisas() { return limpiaparabrisas; }
    public void setLimpiaparabrisas(String limpiaparabrisas) { this.limpiaparabrisas = limpiaparabrisas; }
    
    public String getHuelgoStatus() { return huelgoStatus; }
    public void setHuelgoStatus(String huelgoStatus) { this.huelgoStatus = huelgoStatus; }
    
    public Integer getHuelgoMm() { return huelgoMm; }
    public void setHuelgoMm(Integer huelgoMm) { this.huelgoMm = huelgoMm; }
    
    public String getEscape() { return escape; }
    public void setEscape(String escape) { this.escape = escape; }
    
    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }
    
    public LocalDateTime getFechaCaptura() { return fechaCaptura; }
    public void setFechaCaptura(LocalDateTime fechaCaptura) { this.fechaCaptura = fechaCaptura; }
    
    public BeanVerificacion getVerificacion() { return verificacion; }
    public void setVerificacion(BeanVerificacion verificacion) { this.verificacion = verificacion; }
    
    public BeanUsuario getTecnico() { return tecnico; }
    public void setTecnico(BeanUsuario tecnico) { this.tecnico = tecnico; }
    
    public List<BeanEvidenciaEvaluacion> getEvidencias() { return evidencias; }
    public void setEvidencias(List<BeanEvidenciaEvaluacion> evidencias) { this.evidencias = evidencias; }
}
