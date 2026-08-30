package com.jdc.dulcealmibar.controller;

import com.jdc.dulcealmibar.entity.Usuario;
import com.jdc.dulcealmibar.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(
            @RequestParam String correo,
            @RequestParam String password,
            HttpSession session,
            Model model
    ) {
        try {
            Usuario usuario = usuarioService.validarLogin(correo, password);

            session.setAttribute("usuarioLogueado", usuario);

            if (usuario.getRol().name().equals("ADMIN")) {
                return "redirect:/admin/dashboard";
            } else {
                return "redirect:/cliente/catalogo";
            }

        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }

    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String procesarRegistro(@ModelAttribute Usuario usuario, Model model) {
        try {
            usuarioService.registrarCliente(usuario);
            model.addAttribute("exito", "Registro exitoso. Ahora puedes iniciar sesión.");
            return "login";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "registro";
        }
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}