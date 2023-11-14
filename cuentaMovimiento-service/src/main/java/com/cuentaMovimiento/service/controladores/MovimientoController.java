package com.cuentaMovimiento.service.controladores;

import com.cuentaMovimiento.service.entidades.EstadoMovimiento;
import com.cuentaMovimiento.service.excepciones.MovimientoNotFoundException;
import com.cuentaMovimiento.service.excepciones.SaldoInsuficienteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cuentaMovimiento.service.servicios.MovimientosService;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientosService movimientoService;

    @GetMapping
    public List<EstadoMovimiento> getAllMovimientos() {
        return movimientoService.getAllMovimientos();
    }

//    @GetMapping("/{id}")
//    public EstadoMovimiento getTipoMovimiento(@PathVariable Long id) {
//        // Obtener el EstadoMovimiento del repositorio según el ID
//        return movimientoRepository.findById(id)
//                .orElseThrow(() -> new MovimientoNotFoundException("Movimiento no encontrado con el ID: " + id));
//    }

    @GetMapping("/{id}")
    public EstadoMovimiento getTipoMovimiento(@PathVariable Long id) {
        return movimientoService.getTipoMovimiento(id);
    }


// Endpoint para registrar movimientos
@PostMapping("/registrar/{idCuenta}")
public ResponseEntity<String> registrarMovimiento(@RequestBody EstadoMovimiento movimiento, @PathVariable Long idCuenta) {
    try {
        movimientoService.createMovimiento(movimiento, idCuenta);
        return ResponseEntity.status(HttpStatus.CREATED).body("Movimiento registrado exitosamente");
    } catch (SaldoInsuficienteException e) {
        return ResponseEntity.badRequest().body("Saldo no disponible");
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar el movimiento: " + e.getMessage());
    }
}


    @PutMapping("/{id}")
    public EstadoMovimiento updateMovimiento(@PathVariable Long id, @RequestBody EstadoMovimiento movimiento) {
        return movimientoService.updateMovimiento(id, movimiento);
    }

    @PatchMapping("/{id}")
    public EstadoMovimiento partialUpdateMovimiento(@PathVariable Long id, @RequestBody EstadoMovimiento movimiento) {
        return movimientoService.partialUpdateMovimiento(id, movimiento);
    }

    @DeleteMapping("/{id}")
    public void deleteMovimiento(@PathVariable Long id) {
        movimientoService.deleteMovimiento(id);
    }
}

