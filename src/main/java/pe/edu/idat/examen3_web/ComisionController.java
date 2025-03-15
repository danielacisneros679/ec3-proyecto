package pe.edu.idat.examen3_web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComisionController {
    @GetMapping("/examen")
    public String ComisionMensual() {
        return "examen";  // Esto carga examen.html desde /templates/
    }
}

