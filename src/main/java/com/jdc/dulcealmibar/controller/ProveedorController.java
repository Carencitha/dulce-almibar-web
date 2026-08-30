package com.jdc.dulcealmibar.controller;

import com.jdc.dulcealmibar.entity.Proveedor;
import com.jdc.dulcealmibar.service.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping("/admin/proveedores")
    public String listarProveedores(Model model) {
        model.addAttribute("proveedores", proveedorService.listarTodos());
        model.addAttribute("proveedor", new Proveedor());
        return "admin/proveedores";
    }

    @PostMapping("/admin/proveedores/guardar")
    public String guardarProveedor(@ModelAttribute Proveedor proveedor) {
        proveedorService.guardar(proveedor);
        return "redirect:/admin/proveedores";
    }

    @GetMapping("/admin/proveedores/editar/{id}")
    public String editarProveedor(@PathVariable Long id, Model model) {
        Proveedor proveedor = proveedorService.buscarPorId(id);
        model.addAttribute("proveedor", proveedor);
        model.addAttribute("proveedores", proveedorService.listarTodos());
        return "admin/proveedores";
    }

    @GetMapping("/admin/proveedores/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        proveedorService.eliminar(id);
        return "redirect:/admin/proveedores";
    }
}