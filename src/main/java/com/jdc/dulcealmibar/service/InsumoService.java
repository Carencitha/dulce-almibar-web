package com.jdc.dulcealmibar.service;

import com.jdc.dulcealmibar.entity.Insumo;
import com.jdc.dulcealmibar.repository.InsumoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsumoService {

    private final InsumoRepository insumoRepository;

    public InsumoService(InsumoRepository insumoRepository) {
        this.insumoRepository = insumoRepository;
    }

    public List<Insumo> listarTodos() {
        return insumoRepository.findAll();
    }

    public List<Insumo> listarActivos() {
        return insumoRepository.findByActivoTrue();
    }

    public Insumo guardar(Insumo insumo) {
        if (insumo.getActivo() == null) {
            insumo.setActivo(true);
        }

        return insumoRepository.save(insumo);
    }

    public Insumo buscarPorId(Long id) {
        return insumoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insumo no encontrado"));
    }

    public void eliminar(Long id) {
        Insumo insumo = buscarPorId(id);
        insumo.setActivo(false);
        insumoRepository.save(insumo);
    }
}