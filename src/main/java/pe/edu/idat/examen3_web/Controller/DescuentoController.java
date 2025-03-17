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
@RequestMapping("/descuento")
public class DescuentoController {

    @GetMapping("/examen")
    public String mostrarFormulario(Model model) {
        model.addAttribute("descuentomodel", new DescuentoModel());
        model.addAttribute("comisionmodel", new ComisionModel()); // Asegurar que también esté en la vista
        return "examen";
    }

    @PostMapping("/calcularDescuento")
    public String calcularDescuento(@ModelAttribute("descuentomodel") DescuentoModel descuentomodel, Model model) {
        double precio = descuentomodel.getProducto();
        int acliente = descuentomodel.getTiempoComprando();
        double descuento;

        if (acliente < 1) {
            descuento = 2;
        } else if (acliente < 3) {
            descuento = 5;
        } else if (acliente < 5) {
            descuento = 8;
        } else {
            descuento = 12;
        }

        double montoDescuento = (precio * descuento) / 100;
        double totalPagar = precio - montoDescuento;

        descuentomodel.setTotalPagar(totalPagar);

        model.addAttribute("descuentomodel", descuentomodel);
        model.addAttribute("descuento", descuento);
        model.addAttribute("comisionmodel", new ComisionModel()); // Mantenerlo en la vista

        return "examen"; // Se mantiene en la misma vista
    }
}

