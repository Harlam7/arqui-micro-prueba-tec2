-- Insertar Persona
INSERT INTO Persona (nombre, genero, edad, id, direccion, telefono)
VALUES ('Nico', 'hombre', 28, '11112785', 'calle falsa', '333333335');

-- Insertar Cliente
INSERT INTO Cliente (clienteid, contrasena, estado)
VALUES (11112785, '1234', 'Activo');

-- Insertar Cuenta
INSERT INTO Cuenta (tipo_cuenta, saldo_inicial, estado, numero_cuenta)
VALUES ('Ahorros', 1000.00, 'Activa', 11112785);

-- Insertar Movimiento
INSERT INTO Movimientos (fecha, tipo_movimiento, valor, saldo, id)
VALUES (CURRENT_TIMESTAMP, 'Depósito', 500.00, 1500.00, 11112785);
