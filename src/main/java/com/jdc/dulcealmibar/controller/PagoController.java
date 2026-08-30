package com.jdc.dulcealmibar.controller;

import com.jdc.dulcealmibar.entity.Usuario;
import com.jdc.dulcealmibar.service.FacturaService;
import com.jdc.dulcealmibar.service.PagoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PagoController {

    private final PagoService pagoService;
    private final FacturaService facturaService;

    public PagoController(PagoService pagoService,
                          FacturaService facturaService) {
        this.pagoService = pagoService;
        this.facturaService = facturaService;
    }

    @GetMapping("/cliente/pago/{pedidoId}")
    public String mostrarPago(@PathVariable Long pedidoId,
                              HttpSession session,
                              Model model) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        if (!usuario.getRol().name().equals("CLIENTE")) {
            return "redirect:/login";
        }

        model.addAttribute("pedidoId", pedidoId);
        return "cliente/pago";
    }

    @PostMapping("/cliente/pago/guardar")
    public String guardarPago(
            @RequestParam Long pedidoId,
            @RequestParam String metodoPago,
            @RequestParam(required = false) String referenciaPago,
            HttpSession session,
            Model model
    ) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        try {
            pagoService.registrarPago(pedidoId, metodoPago, referenciaPago);
            facturaService.generarFactura(pedidoId);
            return "redirect:/cliente/mis-facturas";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("pedidoId", pedidoId);
            return "cliente/pago";
        }
    }
}