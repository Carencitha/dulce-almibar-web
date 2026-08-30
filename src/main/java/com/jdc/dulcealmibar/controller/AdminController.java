package com.jdc.dulcealmibar.controller;

import com.jdc.dulcealmibar.entity.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    public String dashboardAdmin(HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        if (!usuario.getRol().name().equals("ADMIN")) {
            return "redirect:/login";
        }

        return "admin/dashboard";
    }
}