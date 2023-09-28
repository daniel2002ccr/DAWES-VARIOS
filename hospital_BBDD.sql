DROP DATABASE IF EXISTS hospital;
CREATE DATABASE IF NOT EXISTS hospital;
use hospital; 


-- Crear la tabla de Alergias
CREATE TABLE Alergias (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Descripcion VARCHAR(50)
);

-- Crear la tabla de EstadoCitas
CREATE TABLE EstadoCitas (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Estado VARCHAR(50)

);

-- Crear la tabla de EstadoFacturacion
CREATE TABLE EstadoFacturacion (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Estado VARCHAR(50)
);




-- Crear la tabla de Pacientes
CREATE TABLE Pacientes (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    FechaDeNacimiento DATE,
    DNI VARCHAR(50),
    Direccion VARCHAR(100),
    Telefono VARCHAR(20),
    CorreoElectronico VARCHAR(50),
    AlergiaID INT,
    HistoriaMedica TEXT,
    FOREIGN KEY (AlergiaID) REFERENCES Alergias(ID)
);

-- Crear la tabla de Médicos
CREATE TABLE Medicos (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    Especialidad VARCHAR(50),
    LicenciaMedica VARCHAR(50),
    Telefono VARCHAR(20),
    CorreoElectronico VARCHAR(50)
);

-- Crear la tabla de Citas
CREATE TABLE Citas (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    PacienteID INT,
    MedicoID INT,
    Fecha DATE,
    Hora TIME,
    EstadoID INT,
    FOREIGN KEY (PacienteID) REFERENCES Pacientes(ID),
    FOREIGN KEY (MedicoID) REFERENCES Medicos(ID),
    FOREIGN KEY (EstadoID) REFERENCES EstadoCitas(ID)
);

-- Crear la tabla de Departamentos
CREATE TABLE Departamentos (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50),
    Descripcion TEXT,
    Activo INT
);

-- Crear la tabla de HistorialMédico
CREATE TABLE HistorialMedico (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    PacienteID INT,
    MedicoID INT,
    Fecha DATE,
    Diagnostico TEXT,
    Tratamiento TEXT,
    FOREIGN KEY (PacienteID) REFERENCES Pacientes(ID),
    FOREIGN KEY (MedicoID) REFERENCES Medicos(ID)
);

-- Crear la tabla de Facturación
CREATE TABLE Facturacion (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    PacienteID INT,
    Fecha DATE,
    Monto DECIMAL(10, 2),
    EstadoID INT,
    FOREIGN KEY (PacienteID) REFERENCES Pacientes(ID),
    FOREIGN KEY (EstadoID) REFERENCES EstadoFacturacion(ID)
);

-- Crear la tabla de Farmacia
CREATE TABLE Farmacia (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50),
    Descripcion TEXT,
    CantidadDisponible INT,
    Precio DECIMAL(10, 2)
);

-- Crear la tabla de RecetasMédicas
CREATE TABLE RecetasMedicas (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    PacienteID INT,
    MedicoID INT,
    MedicamentoID INT,
    Fecha DATE,
    CantidadPrescrita INT,
    FOREIGN KEY (PacienteID) REFERENCES Pacientes(ID),
    FOREIGN KEY (MedicoID) REFERENCES Medicos(ID),
    FOREIGN KEY (MedicamentoID) REFERENCES Farmacia(ID)
);

-- Crear la tabla de Habitaciones
CREATE TABLE Habitaciones (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Tipo VARCHAR(50),
    Estado VARCHAR(50),
    CostoPorDia DECIMAL(10, 2)
);

-- Crear la tabla de Admisiones
CREATE TABLE Admisiones (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    PacienteID INT,
    HabitacionID INT,
    FechaDeIngreso DATE,
    FechaDeSalida DATE,
    Motivo TEXT,
    FOREIGN KEY (PacienteID) REFERENCES Pacientes(ID),
    FOREIGN KEY (HabitacionID) REFERENCES Habitaciones(ID)
);

-- Llenar la tabla de EstadoCitas
INSERT INTO EstadoCitas (Estado) VALUES ('Confirmada');
INSERT INTO EstadoCitas (Estado) VALUES ('Cancelada');
INSERT INTO EstadoCitas (Estado) VALUES ('Pendiente');

-- Llenar la tabla de EstadoFacturacion
INSERT INTO EstadoFacturacion (Estado) VALUES ('Pagada');
INSERT INTO EstadoFacturacion (Estado) VALUES ('Pendiente');
INSERT INTO EstadoFacturacion (Estado) VALUES ('Vencida');

-- Llenar la tabla de Alergias
INSERT INTO Alergias (Descripcion) VALUES ('Polen');
INSERT INTO Alergias (Descripcion) VALUES ('Nueces');
INSERT INTO Alergias (Descripcion) VALUES ('Mariscos');
INSERT INTO Alergias (Descripcion) VALUES ('Sin alergias');

-- Llenar la tabla de Pacientes
INSERT INTO Pacientes (Nombre, Apellido, FechaDeNacimiento, DNI, Direccion, Telefono, CorreoElectronico, AlergiaID, HistoriaMedica) 
VALUES 
('Juan', 'Perez', '1980-01-01', '123456789', 'Calle Falsa 123', '555-1234', 'juan.perez@email.com', 1, 'Ninguna'),
('Maria', 'Gonzalez', '1985-02-14', '987654321', 'Av. Principal 456', '555-5678', 'maria.gonzalez@email.com', 2, 'Ninguna'),
('Carlos', 'Lopez', '1990-06-30', '456789123', 'Calle Secundaria 789', '555-9876', 'carlos.lopez@email.com', 4, 'Ninguna');

-- Llenar la tabla de Médicos
INSERT INTO Medicos (Nombre, Apellido, Especialidad, LicenciaMedica, Telefono, CorreoElectronico) 
VALUES 
('Ana', 'Garcia', 'Cardiología', 'Lic123', '555-5678', 'ana.garcia@email.com'),
('Pedro', 'Rodriguez', 'Neurología', 'Lic456', '555-1111', 'pedro.rodriguez@email.com'),
('Sofia', 'Martinez', 'Pediatria', 'Lic789', '555-2222', 'sofia.martinez@email.com');

-- Llenar la tabla de Citas
INSERT INTO Citas (PacienteID, MedicoID, Fecha, Hora, EstadoID) 
VALUES 
(1, 1, '2023-09-20', '15:00:00', 1),
(2, 2, '2023-09-21', '10:00:00', 1),
(3, 3, '2023-09-22', '14:00:00', 2);

-- Llenar la tabla de Departamentos
INSERT INTO Departamentos (Nombre, Descripcion) 
VALUES 
('Emergencias', 'Atención de casos de emergencia'),
('Cardiología', 'Atención de enfermedades cardiovasculares'),
('Neurología', 'Atención de enfermedades del sistema nervioso');

-- Llenar la tabla de HistorialMédico
INSERT INTO HistorialMedico (PacienteID, MedicoID, Fecha, Diagnostico, Tratamiento) 
VALUES 
(1, 1, '2023-09-13', 'Gripe', 'Descanso y líquidos'),
(2, 2, '2023-09-14', 'Migraña', 'Medicación y descanso'),
(3, 3, '2023-09-15', 'Resfriado', 'Descanso y líquidos');

-- Llenar la tabla de Facturación
INSERT INTO Facturacion (PacienteID, Fecha, Monto, EstadoID) 
VALUES 
(1, '2023-09-13', 100.00, 1),
(2, '2023-09-14', 150.00, 2),
(3, '2023-09-15', 200.00, 3);

-- Llenar la tabla de Farmacia
INSERT INTO Farmacia (Nombre, Descripcion, CantidadDisponible, Precio) 
VALUES 
('Paracetamol', 'Analgésico', 100, 5.00),
('Ibuprofeno', 'Antiinflamatorio', 80, 7.00),
('Amoxicilina', 'Antibiótico', 50, 10.00);

-- Llenar la tabla de RecetasMédicas
INSERT INTO RecetasMedicas (PacienteID, MedicoID, MedicamentoID, Fecha, CantidadPrescrita) 
VALUES 
(1, 1, 1, '2023-09-13', 20),
(2, 2, 2, '2023-09-14', 30),
(3, 3, 3, '2023-09-15', 40);

-- Llenar la tabla de Habitaciones
INSERT INTO Habitaciones (Tipo, Estado, CostoPorDia) 
VALUES 
('Individual', 'Disponible', 200.00),
('Doble', 'Ocupada', 150.00),
('Suite', 'Disponible', 300.00);

-- Llenar la tabla de Admisiones
INSERT INTO Admisiones (PacienteID, HabitacionID, FechaDeIngreso, FechaDeSalida, Motivo) 
VALUES 
(1, 1, '2023-09-13', '2023-09-15', 'Observación'),
(2, 2, '2023-09-14', '2023-09-16', 'Cirugía menor'),
(3, 3, '2023-09-15', '2023-09-17', 'Exámenes médicos');


