package pe.edu.idat.examen3_web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComisionController {

    @GetMapping("/examen")  // Ahora responde a http://localhost:8080/examen
    public String mostrarFormulario(Model model) {
        model.addAttribute("mensaje", "Calculadora de Comisiones");
        return "examen";  // No pongas ".html"
    }
}