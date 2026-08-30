package com.jdc.dulcealmibar.controller;

import com.jdc.dulcealmibar.entity.Usuario;
import com.jdc.dulcealmibar.service.FacturaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping("/cliente/mis-facturas")
    public String misFacturas(HttpSession session, Model model) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        if (!usuario.getRol().name().equals("CLIENTE")) {
            return "redirect:/login";
        }

        model.addAttribute("facturas", facturaService.listarPorCliente(usuario.getCorreo()));
        return "cliente/mis-facturas";
    }

    @GetMapping("/admin/facturas")
    public String facturasAdmin(HttpSession session, Model model) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        if (!usuario.getRol().name().equals("ADMIN")) {
            return "redirect:/login";
        }

        model.addAttribute("facturas", facturaService.listarTodas());
        return "admin/facturas";
    }

    @GetMapping("/factura/ver/{id}")
    public String verFactura(@PathVariable Long id,
                             HttpSession session,
                             Model model) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        model.addAttribute("factura", facturaService.buscarPorId(id));
        return "factura/ver";
    }
}