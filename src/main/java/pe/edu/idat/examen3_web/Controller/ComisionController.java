package pe.edu.idat.examen3_web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.idat.examen3_web.Model.ComisionModel;
import pe.edu.idat.examen3_web.Model.DescuentoModel;

@Controller
@RequestMapping("/comision")
public class ComisionController {

    @GetMapping("/examen")
    public String mostrarFormulario(Model model) {
        model.addAttribute("comisionmodel", new ComisionModel());
        model.addAttribute("descuentomodel", new DescuentoModel()); // Asegurar que también esté en la vista
        return "examen";
    }

    @PostMapping("/calcularComision")
    public String calcularComision(@ModelAttribute("comisionmodel") ComisionModel comision, Model model) {
        double ventas = comision.getVentasMensuales();
        double comisionCalculada;

        if (ventas < 1000) {
            comisionCalculada = ventas * 0.03;
        } else if (ventas <= 5000) {
            comisionCalculada = ventas * 0.05;
        } else if (ventas <= 10000) {
            comisionCalculada = ventas * 0.07;
        } else {
            comisionCalculada = ventas * 0.10;
        }

        model.addAttribute("comisionCalculada", comisionCalculada);
        model.addAttribute("descuentomodel", new DescuentoModel()); // Mantenerlo en la vista

        return "examen"; // Se mantiene en la misma vista
    }
}
