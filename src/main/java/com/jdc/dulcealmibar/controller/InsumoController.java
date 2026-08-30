package com.jdc.dulcealmibar.controller;

import com.jdc.dulcealmibar.entity.Insumo;
import com.jdc.dulcealmibar.service.InsumoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InsumoController {

    private final InsumoService insumoService;

    public InsumoController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    @GetMapping("/admin/insumos")
    public String listarInsumos(Model model) {
        model.addAttribute("insumos", insumoService.listarTodos());
        model.addAttribute("insumo", new Insumo());
        return "admin/insumos";
    }

    @PostMapping("/admin/insumos/guardar")
    public String guardarInsumo(@ModelAttribute Insumo insumo) {
        insumoService.guardar(insumo);
        return "redirect:/admin/insumos";
    }

    @GetMapping("/admin/insumos/editar/{id}")
    public String editarInsumo(@PathVariable Long id, Model model) {
        Insumo insumo = insumoService.buscarPorId(id);
        model.addAttribute("insumo", insumo);
        model.addAttribute("insumos", insumoService.listarTodos());
        return "admin/insumos";
    }

    @GetMapping("/admin/insumos/eliminar/{id}")
    public String eliminarInsumo(@PathVariable Long id) {
        insumoService.eliminar(id);
        return "redirect:/admin/insumos";
    }
}