package pe.edu.idat.examen3_web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.examen3_web.Model.BonificacionModel;
import pe.edu.idat.examen3_web.Model.CategoriaModel;
import pe.edu.idat.examen3_web.Model.ComisionModel;
import pe.edu.idat.examen3_web.Model.DescuentoModel;

@Controller
public class CategoriaController {

    @GetMapping("/examen")
    public String mostrarFormulario(Model model) {
        model.addAttribute("bonificacionmodel", new BonificacionModel());
        model.addAttribute("descuentomodel", new DescuentoModel());
        model.addAttribute("comisionmodel", new ComisionModel());
        model.addAttribute("categoriamodel", new CategoriaModel());
        return "examen";
    }

    @PostMapping("/calcularCategoria")
    public String calcularCategoria(@ModelAttribute("categoriamodel") CategoriaModel categoria, Model model) {
        String cat = categoria.getCategoria();
        double monto = categoria.getTotalPagar();

        if (monto < 0) {
            model.addAttribute("error", "El precio no puede ser negativo.");
            return "examen";
        }

        double descuento = 0.0;
        if (cat.equalsIgnoreCase("ELECTRONICA")) {
            descuento = monto * 0.15;
        } else if (cat.equalsIgnoreCase("ALIMENTOS")) {
            descuento = monto * 0.05;
        } else if (cat.equalsIgnoreCase("ROPA")) {
            descuento = monto * 0.08;
        } else if (cat.equalsIgnoreCase("MUEBLES")) {
            descuento = monto * 0.10;
        }

        double categoriaCalculada = monto - descuento; // Se RESTA el descuento
        categoria.setTotalPagar(categoriaCalculada);

        model.addAttribute("categoriamodel", categoria);
        model.addAttribute("descuento", descuento);
        model.addAttribute("bonificacionmodel", new BonificacionModel());
        model.addAttribute("descuentomodel", new DescuentoModel());
        model.addAttribute("comisionmodel", new ComisionModel());

        return "examen";
    }
}
