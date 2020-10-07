CREATE DATABASE IF NOT EXISTS HOSPITAL;
USE HOSPITAL;

CREATE TABLE IF NOT EXISTS ADMINISTRADOR(
  codigo VARCHAR(20) NOT NULL,
  DPI VARCHAR(20) NOT NULL,
  nombre VARCHAR(75) NOT NULL,
  password VARCHAR(75) NOT NULL,
  CONSTRAINT PK_ADMINISTRADOS PRIMARY KEY(codigo)
);

CREATE TABLE IF NOT EXISTS MEDICO(
  codigo VARCHAR(20) NOT NULL,
  password VARCHAR(75),
  nombre VARCHAR(75) NOT NULL,
  colegiado VARCHAR(20) NOT NULL,
  DPI VARCHAR(20) NOT NULL,
  telefono VARCHAR(12) NOT NULL,
  correo VARCHAR(75) NOT NULL,
  horario_inicio VARCHAR(25) NOT NULL,
  horario_fin VARCHAR(25),
  fecha_inicio DATE NOT NULL,
  CONSTRAINT PK_MEDICO PRIMARY KEY(codigo)
);

CREATE TABLE IF NOT EXISTS ESPECIALIDAD(
  nombre VARCHAR(60) NOT NULL,
  costo DECIMAL(9,2) DEFAULT 200.00,
  CONSTRAINT PK_ESPECIALIDAD PRIMARY KEY(nombre)
);

CREATE TABLE IF NOT EXISTS DESCRIPCION(
  codigo_medico VARCHAR(20) NOT NULL,
  nombre_especialidad VARCHAR(60) NOT NULL,
  CONSTRAINT PK_DESCRIPCION PRIMARY KEY(codigo_medico,nombre_especialidad),
  CONSTRAINT FK_DESCRIPCION_MEDICO FOREIGN KEY(codigo_medico) REFERENCES MEDICO(codigo),
  CONSTRAINT FK_DESCRIPCION_ESPECIALIDAD FOREIGN KEY(nombre_especialidad) REFERENCES ESPECIALIDAD(nombre)
);

CREATE TABLE IF NOT EXISTS PACIENTE(
  codigo VARCHAR(20) NOT NULL,
  DPI VARCHAR(20) NOT NULL,
  nombre VARCHAR(75) NOT NULL,
  sexo VARCHAR(12) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  tipo_sangre VARCHAR(15) NOT NULL,
  telefono VARCHAR(12) NOT NULL,
  peso DECIMAL(9,4) NOT NULL,
  correo VARCHAR(75) NOT NULL,
  password VARCHAR(75) NOT NULL,
  CONSTRAINT PK_PACIENTE PRIMARY KEY(codigo)
);

CREATE TABLE IF NOT EXISTS EXAMEN(
  codigo VARCHAR(20) NOT NULL,
  nombre VARCHAR(70) NOT NULL,
  orden BOOLEAN NOT NULL,
  descripcion VARCHAR(300) NOT NULL,
  costo DECIMAL(9,2) NOT NULL,
  informe VARCHAR(500) NOT NULL,
  CONSTRAINT PK_EXAMEN PRIMARY KEY(codigo)
);

CREATE TABLE IF NOT EXISTS DIAS_TRABAJO(
  codigo INT AUTO_INCREMENT,
  lunes BOOLEAN,
  martes BOOLEAN,
  miercoles BOOLEAN,
  jueves BOOLEAN,
  viernes BOOLEAN,
  sabado BOOLEAN,
  domingo BOOLEAN,
  CONSTRAINT PK_DIAS_TRABAJO PRIMARY KEY(codigo)
);

CREATE TABLE IF NOT EXISTS LABORATORISTA(
  codigo VARCHAR(20) NOT NULL,
  nombre VARCHAR(75) NOT NULL,
  registro VARCHAR(20) NOT NULL,
  DPI VARCHAR(20) NOT NULL,
  telefono VARCHAR(12) NOT NULL,
  correo VARCHAR(75) NOT NULL,
  fecha_inicio DATE NOT NULL,
  password VARCHAR(75) NOT NULL,
  codigo_examen VARCHAR(20) NOT NULL,
  dias_trabajo_codigo INT NOT NULL,
  CONSTRAINT PK_LABORATORISTA PRIMARY KEY(codigo),
  CONSTRAINT FK_LABORATORISTA_EXAMEN FOREIGN KEY(codigo_examen) REFERENCES EXAMEN(codigo),
  CONSTRAINT FK_LABORATORISTA_DIAS FOREIGN KEY(dias_trabajo_codigo) REFERENCES DIAS_TRABAJO(codigo)
);

CREATE TABLE IF NOT EXISTS CITA_MEDICA(
  codigo VARCHAR(50) NOT NULL,
  fecha DATE NOT NULL,
  hora TIME NOT NULL,
  costo DECIMAL(9,2) NOT NULL,
  codigo_medico VARCHAR(20) NOT NULL,
  codigo_paciente VARCHAR(20) NOT NULL,
  nombre_especialidad VARCHAR(60) NOT NULL,
  CONSTRAINT PK_CITA_MEDICA PRIMARY KEY(codigo),
  CONSTRAINT FK_CITA_MEDICA_MEDICO FOREIGN KEY(codigo_medico) REFERENCES MEDICO(codigo),
  CONSTRAINT FK_CITA_MEDICA_PACIENTE FOREIGN KEY(codigo_paciente) REFERENCES PACIENTE(codigo),
  CONSTRAINT FK_CITA_MEDICA_ESPECIALIDAD FOREIGN KEY(nombre_especialidad) REFERENCES ESPECIALIDAD(nombre)
);

CREATE TABLE IF NOT EXISTS INFORME(
  codigo VARCHAR(75) NOT NULL,
  informe VARCHAR(1500) NOT NULL,
  fecha DATE NOT NULL,
  hora TIME NOT NULL,
  codigo_medico VARCHAR(20) NOT NULL,
  codigo_paciente VARCHAR(20) NOT NULL,
  CONSTRAINT PK_INFORME PRIMARY KEY(codigo),
  CONSTRAINT FK_INFORME_MEDICO FOREIGN KEY(codigo_medico) REFERENCES MEDICO(codigo),
  CONSTRAINT FK_INFORME_PACIENTE FOREIGN KEY(codigo_paciente) REFERENCES PACIENTE(codigo)
);

CREATE TABLE IF NOT EXISTS ORDEN(
  codigo VARCHAR(50) NOT NULL,
  codigo_examen VARCHAR(20) NOT NULL,
  descripcion VARCHAR(500),
  archivo VARCHAR(500) NOT NULL,
  fecha_creacion DATE NOT NULL,
  codigo_paciente VARCHAR(20) NOT NULL,
  codigo_medico VARCHAR(20) NOT NULL,
  validez BOOLEAN,
  CONSTRAINT PK_ORDEN PRIMARY KEY(codigo),
  CONSTRAINT FK_CODIGO_PACIENTE FOREIGN KEY(codigo_paciente) REFERENCES PACIENTE(codigo),
  CONSTRAINT FK_CODIGO_EXAMEN FOREIGN KEY(codigo_examen) REFERENCES EXAMEN(codigo),
  CONSTRAINT FK_CODIGO_MEDICO FOREIGN KEY(codigo_medico) REFERENCES MEDICO(codigo)
);

CREATE TABLE IF NOT EXISTS CITA_LABORATORIO(
  codigo VARCHAR(70) NOT NULL,
  fecha DATE NOT NULL,
  hora TIME NOT NULL,
  costo DECIMAL(9,2) NOT NULL,
  codigo_paciente VARCHAR(20) NOT NULL,
  codigo_examen VARCHAR(20) NOT NULL,
  codigo_orden VARCHAR(50),
  CONSTRAINT PK_CITA_LABORATORIO PRIMARY KEY(codigo),
  CONSTRAINT FK_CITA_LABORATORIO_PACIENTE FOREIGN KEY(codigo_paciente) REFERENCES PACIENTE(codigo),
  CONSTRAINT FK_CITA_LABORATORIO_EXAMEN FOREIGN KEY(codigo_examen) REFERENCES EXAMEN(codigo),
  CONSTRAINT FK_CITA_LABORATORIO_ORDEN FOREIGN KEY(codigo_orden) REFERENCES ORDEN(codigo)
);

CREATE TABLE IF NOT EXISTS RESULTADO(
  codigo VARCHAR(75) NOT NULL,
  fecha DATE NOT NULL,
  hora TIME NOT NULL,
  informe VARCHAR(500) NOT NULL,
  orden VARCHAR(45),
  codigo_medico VARCHAR(20),
  codigo_laboratorista VARCHAR(20) NOT NULL,
  codigo_paciente VARCHAR(20) NOT NULL,
  codigo_examen VARCHAR(20) NOT NULL,
  codigo_cita_laboratorio VARCHAR(70),
  CONSTRAINT PK_RESULTADO PRIMARY KEY(codigo),
  CONSTRAINT FK_RESULTADO_MEDICO FOREIGN KEY(codigo_medico) REFERENCES MEDICO(codigo),
  CONSTRAINT FK_RESULTADO_LABORATORISTA FOREIGN KEY(codigo_laboratorista) REFERENCES LABORATORISTA(codigo),
  CONSTRAINT FK_RESULTADO_PACIENTE FOREIGN KEY(codigo_paciente) REFERENCES PACIENTE(codigo),
  CONSTRAINT FK_RESULTADO_EXAMEN FOREIGN KEY(codigo_examen) REFERENCES EXAMEN(codigo),
  CONSTRAINT FK_RESULTADO_CITA_LABORATORIO FOREIGN KEY(codigo_cita_laboratorio) REFERENCES CITA_LABORATORIO(codigo)
);
