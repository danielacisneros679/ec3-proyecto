package pe.edu.idat.examen3_web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.idat.examen3_web.Model.BonificacionModel;
import pe.edu.idat.examen3_web.Model.ComisionModel;
import pe.edu.idat.examen3_web.Model.DescuentoModel;

@Controller
@RequestMapping("/bonificacion")
public class BonificacionController {

    @GetMapping("/examen")
    public String mostrarFormulario(Model model) {
        model.addAttribute("bonificacionmodel", new BonificacionModel());
        model.addAttribute("descuentomodel", new DescuentoModel());
        model.addAttribute("comisionmodel", new ComisionModel());
        return "examen";
    }

    @PostMapping("/calcularBonificacion")
    public String calcularBonificacion(@ModelAttribute("bonificacionmodel") BonificacionModel bonificacion, Model model) {
        String mensaje = calcularDescuento(bonificacion.getDias());
        bonificacion.setPagar(mensaje);


        model.addAttribute("bonificacionmodel", bonificacion);
        model.addAttribute("descuentomodel", new DescuentoModel());
        model.addAttribute("comisionmodel", new ComisionModel());

        return "examen";
    }


    private String calcularDescuento(Double dias) {
        if (dias == null) {
            return "Ingrese un número de días válido.";
        }

        if (dias <= 10) {
            return "Tienes un 10% de descuento en tu pago.";
        } else if (dias <= 20) {
            return "Tienes un 5% de descuento en tu pago.";
        } else {
            return "No tienes descuento en tu pago.";
        }
    }
}
