package com.cuentaMovimiento.service.controladores;

import com.cuentaMovimiento.service.entidades.EstadoCuenta;
import com.cuentaMovimiento.service.excepciones.CuentasNotFoundException;
import com.cuentaMovimiento.service.servicios.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<EstadoCuenta>> generarReporte(
            @RequestParam(name = "fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(name = "fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(name = "cliente") Long idCliente) {

//        List<EstadoCuenta> estadoCuentaList = reporteService.generarReporte(fechaInicio, fechaFin, idCliente);
//        return ResponseEntity.ok(estadoCuentaList);
        try {
            List<EstadoCuenta> estadoCuentaList = reporteService.generarReporte(fechaInicio, fechaFin, idCliente);
            return ResponseEntity.ok(estadoCuentaList);
        } catch (CuentasNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }
}
