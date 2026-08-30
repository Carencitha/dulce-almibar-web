package com.jdc.dulcealmibar.service;

import com.jdc.dulcealmibar.entity.Proveedor;
import com.jdc.dulcealmibar.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public List<Proveedor> listarTodos() {
        return proveedorRepository.findAll();
    }

    public List<Proveedor> listarActivos() {
        return proveedorRepository.findByActivoTrue();
    }

    public Proveedor guardar(Proveedor proveedor) {
        if (proveedor.getActivo() == null) {
            proveedor.setActivo(true);
        }

        return proveedorRepository.save(proveedor);
    }

    public Proveedor buscarPorId(Long id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    public void eliminar(Long id) {
        Proveedor proveedor = buscarPorId(id);
        proveedor.setActivo(false);
        proveedorRepository.save(proveedor);
    }
}