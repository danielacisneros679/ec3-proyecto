package pe.edu.idat.examen3_web.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.examen3_web.Model.DescuentoModel;

@Controller
public class DescuentoController {

    @GetMapping("/examen")
    public String mostrarFormulario(Model model) {
        model.addAttribute("descuentomodel", new DescuentoModel());
        return "examen";
    }

    @PostMapping("/calcularDescuento")
    public String calcularDescuento(@ModelAttribute("descuentomodel") DescuentoModel descuentomodel, Model model) {
        double precio = descuentomodel.getProducto();
        int acliente = descuentomodel.getTiempoComprando();
        double descuento = 0;


        if (acliente < 1) {
            descuento = 0.02;
        } else if (acliente < 3) {
            descuento = 0.05;
        } else if (acliente < 5) {
            descuento = 0.08;
        } else if (acliente > 5) {
            descuento = 0.12;
        }

        double montoDescuento = (precio * descuento) / 100;
        double totalPagar = precio - montoDescuento;


        model.addAttribute("descuento", descuento + "%");
        model.addAttribute("totalPagar", "$" + totalPagar);

        return "examen";
    }
}
