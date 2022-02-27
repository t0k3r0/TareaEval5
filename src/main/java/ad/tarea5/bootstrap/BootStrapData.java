package ad.tarea5.bootstrap;

import ad.tarea5.domain.Partido;
import ad.tarea5.domain.Sede;
import ad.tarea5.repository.PartidoRepository;
import ad.tarea5.repository.SedeRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  @Autowired private PartidoRepository partidoRepository;
  @Autowired private SedeRepository sedeRepository;

  @Transactional
  @Override
  public void run(String... arg0) throws Exception {

    Partido partido1 = new Partido("Algeria", "Marruecos", "Octavos");
    Sede sede1 = new Sede("Al mamhama");

    partido1.setSede(sede1);
    sede1.getPartidos().add(partido1);

    sedeRepository.save(sede1);
    partidoRepository.save(partido1);
  }
}
