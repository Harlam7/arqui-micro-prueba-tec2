package com.cuentaMovimiento.service.controladores;

import com.cuentaMovimiento.service.entidades.EstadoCuenta;
import com.cuentaMovimiento.service.modelos.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cuentaMovimiento.service.servicios.CuentaService;

import java.util.List;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<EstadoCuenta> getAllCuentas() {
        return cuentaService.getAllCuentas();
    }

    @GetMapping("/{id}")
    public EstadoCuenta getCuenta(@PathVariable Long id) {
        return cuentaService.getCuenta(id);
    }

    @PostMapping
    public Cuenta createCuenta(@RequestParam String tipoCuenta, @RequestParam BigDecimal saldoInicial, @RequestParam String estado) {
        return cuentaService.createCuenta(tipoCuenta, saldoInicial, estado);
    }

    @PutMapping("/{id}")
    public Cuenta updateCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        return cuentaService.updateCuenta(id, cuenta);
    }

    @PatchMapping("/{id}")
    public EstadoCuenta partialUpdateCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        return cuentaService.partialUpdateCuenta(id, cuenta);
    }

    @DeleteMapping("/{id}")
    public void deleteCuenta(@PathVariable Long id) {
        cuentaService.deleteCuenta(id);
    }
}


