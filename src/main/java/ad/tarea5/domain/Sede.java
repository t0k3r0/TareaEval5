package ad.tarea5.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sede extends BaseEntity {

  @Column private String name;

  @OneToMany
  @JoinColumn(name = "sede_id")
  List<Partido> partidos = new ArrayList<>();

  public Sede(String name) {
    super();
    this.name = name;
  }
}
