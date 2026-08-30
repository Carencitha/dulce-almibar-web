package com.jdc.dulcealmibar.service;

import com.jdc.dulcealmibar.entity.DetallePedido;
import com.jdc.dulcealmibar.entity.Pedido;
import com.jdc.dulcealmibar.entity.Producto;
import com.jdc.dulcealmibar.entity.Usuario;
import com.jdc.dulcealmibar.repository.PedidoRepository;
import com.jdc.dulcealmibar.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    public PedidoService(PedidoRepository pedidoRepository,
                         ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> listarPorCliente(String correoCliente) {
        return pedidoRepository.findByCorreoCliente(correoCliente);
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    public Pedido crearPedido(
            Usuario usuario,
            Long[] productoIds,
            Integer[] cantidades,
            String observaciones
    ) {
        if (productoIds == null || cantidades == null || productoIds.length == 0) {
            throw new RuntimeException("Debe seleccionar al menos un producto");
        }

        Pedido pedido = Pedido.builder()
                .nombreCliente(usuario.getNombre())
                .correoCliente(usuario.getCorreo())
                .telefonoCliente(usuario.getTelefono())
                .direccionCliente(usuario.getDireccion())
                .observaciones(observaciones)
                .estado("PENDIENTE")
                .fechaPedido(LocalDateTime.now())
                .total(0.0)
                .build();

        double totalPedido = 0.0;

        for (int i = 0; i < productoIds.length; i++) {
            Long productoId = productoIds[i];
            Integer cantidad = cantidades[i];

            if (cantidad == null || cantidad <= 0) {
                continue;
            }

            Producto producto = productoRepository.findById(productoId)
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            if (!producto.getActivo()) {
                throw new RuntimeException("El producto " + producto.getNombre() + " no está disponible");
            }

            if (producto.getStock() < cantidad) {
                throw new RuntimeException("No hay stock suficiente para " + producto.getNombre());
            }

            double subtotal = producto.getPrecio() * cantidad;
            totalPedido += subtotal;

            DetallePedido detalle = DetallePedido.builder()
                    .productoId(producto.getId())
                    .nombreProducto(producto.getNombre())
                    .cantidad(cantidad)
                    .precioUnitario(producto.getPrecio())
                    .subtotal(subtotal)
                    .pedido(pedido)
                    .build();

            pedido.getDetalles().add(detalle);

            producto.setStock(producto.getStock() - cantidad);
            productoRepository.save(producto);
        }

        if (pedido.getDetalles().isEmpty()) {
            throw new RuntimeException("Debe ingresar cantidades válidas");
        }

        pedido.setTotal(totalPedido);

        return pedidoRepository.save(pedido);
    }

    public void cambiarEstado(Long id, String estado) {
        Pedido pedido = buscarPorId(id);
        pedido.setEstado(estado);
        pedidoRepository.save(pedido);
    }
}