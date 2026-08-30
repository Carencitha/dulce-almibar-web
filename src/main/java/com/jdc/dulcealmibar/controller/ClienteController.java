package com.jdc.dulcealmibar.controller;

import com.jdc.dulcealmibar.entity.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

    @GetMapping("/cliente/inicio")
    public String inicioCliente(HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        if (!usuario.getRol().name().equals("CLIENTE")) {
            return "redirect:/login";
        }

        return "redirect:/cliente/catalogo";
    }
}