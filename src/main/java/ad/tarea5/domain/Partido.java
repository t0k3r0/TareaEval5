package ad.tarea5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Partido extends BaseEntity {

  @Column(name = "equipo_local") private String equipoLocal;

  @Column(name = "equipo_visitante") private String equipoVisitante;

  @Column private String ronda;

  @ManyToOne @JoinColumn(name = "sede_id") private Sede sede;

  public Partido(String equipoLocal, String equipoVisitante, String ronda) {
    super();
    this.equipoLocal = equipoLocal;
    this.equipoVisitante = equipoVisitante;
    this.ronda = ronda;
  }
}
