package ad.tarea5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ad.tarea5.domain.Partido;
import ad.tarea5.repository.PartidoRepository;


@Controller
public class PartidoController {

  @Autowired private PartidoRepository partidoRepository;

  @GetMapping("/partidos")
  public String getPartidos(Model model) {

    model.addAttribute("partidos", partidoRepository.findAll());

    return "partidos/list";
  }
  @GetMapping("/partidos/new")
	public String initCreationForm(Model model) {
		// formularios
		Partido partido = new Partido();
		model.addAttribute("partido", partido);
		return "partidos/partidoForm";
	}
  


	@PostMapping("partidos/new/submit")
	public String submitCreationForm(@ModelAttribute Partido partido) {
		
		partidoRepository.save(partido);
		return "redirect:/partidos";
		
	}
	
	@GetMapping("partidos/edit/{id}")
	public String initEditForm(@PathVariable("id") int id, Model model) {	
		model.addAttribute("partido", partidoRepository.findById(id));
		return "partidos/partidoForm";
	}
	
	@GetMapping ("partidos/delete/{id}")
	public String initDelete(@PathVariable("id") int id) {
		
		partidoRepository.deleteById(id);
		return "redirect:/partidos";

	}
}
