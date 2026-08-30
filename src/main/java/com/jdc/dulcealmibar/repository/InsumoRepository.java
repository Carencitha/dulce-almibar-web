package com.jdc.dulcealmibar.repository;

import com.jdc.dulcealmibar.entity.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsumoRepository extends JpaRepository<Insumo, Long> {

    List<Insumo> findByActivoTrue();
}