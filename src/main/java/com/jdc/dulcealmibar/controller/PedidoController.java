package com.jdc.dulcealmibar.controller;

import com.jdc.dulcealmibar.entity.Pedido;
import com.jdc.dulcealmibar.entity.Usuario;
import com.jdc.dulcealmibar.service.PedidoService;
import com.jdc.dulcealmibar.service.ProductoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PedidoController {

    private final PedidoService pedidoService;
    private final ProductoService productoService;

    public PedidoController(PedidoService pedidoService,
                            ProductoService productoService) {
        this.pedidoService = pedidoService;
        this.productoService = productoService;
    }

    @GetMapping("/cliente/pedido")
    public String mostrarFormularioPedido(HttpSession session, Model model) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        if (!usuario.getRol().name().equals("CLIENTE")) {
            return "redirect:/login";
        }

        model.addAttribute("productos", productoService.listarActivos());
        return "cliente/pedido";
    }

    @PostMapping("/cliente/pedido/guardar")
    public String guardarPedido(
            @RequestParam("productoIds") Long[] productoIds,
            @RequestParam("cantidades") Integer[] cantidades,
            @RequestParam(value = "observaciones", required = false) String observaciones,
            HttpSession session,
            Model model
    ) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        if (!usuario.getRol().name().equals("CLIENTE")) {
            return "redirect:/login";
        }

        try {
            Pedido pedido = pedidoService.crearPedido(usuario, productoIds, cantidades, observaciones);
            return "redirect:/cliente/pago/" + pedido.getId();

        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("productos", productoService.listarActivos());
            return "cliente/pedido";
        }
    }

    @GetMapping("/cliente/mis-pedidos")
    public String misPedidos(HttpSession session, Model model) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        if (!usuario.getRol().name().equals("CLIENTE")) {
            return "redirect:/login";
        }

        List<Pedido> pedidos = pedidoService.listarPorCliente(usuario.getCorreo());
        model.addAttribute("pedidos", pedidos);

        return "cliente/mis-pedidos";
    }

    @GetMapping("/admin/pedidos")
    public String pedidosAdmin(HttpSession session, Model model) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        if (!usuario.getRol().name().equals("ADMIN")) {
            return "redirect:/login";
        }

        model.addAttribute("pedidos", pedidoService.listarTodos());
        return "admin/pedidos";
    }

    @GetMapping("/admin/pedidos/estado/{id}")
    public String cambiarEstado(
            @PathVariable Long id,
            @RequestParam String estado,
            HttpSession session
    ) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login";
        }

        if (!usuario.getRol().name().equals("ADMIN")) {
            return "redirect:/login";
        }

        pedidoService.cambiarEstado(id, estado);
        return "redirect:/admin/pedidos";
    }
}