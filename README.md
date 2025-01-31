# 📚 BACKEND - SISTEMA ACADÉMICO

Este repositorio contiene el backend del Sistema Académico, desarrollado en Java 17 con Spring Boot y utilizando Spring Tools Suite (STS) como entorno de desarrollo.

La aplicación actúa como servidor REST y SOAP, manejando peticiones HTTP para operaciones CRUD y consultas. Una vez ejecutada, la aplicación estará disponible en:

🔗 **http://localhost:8080/**

---

## 📥 1. Descarga del Proyecto

Puedes obtener el código fuente de dos maneras:

### 📌 Opción 1: Clonar el repositorio con GIT
```bash
 git clone https://github.com/mohamarchamorro/backend-sistema-academico.git
```

### 📌 Opción 2: Descargar el archivo .ZIP
1. Accede al repositorio en GitHub.
2. Descarga el archivo **.ZIP** desde la opción "Code".
3. Extrae el contenido en la ubicación deseada.

---

## 🖥️ 2. Abrir el Proyecto


### 🔹 Opción 1: Spring Tools Suite (STS) o Eclipse
1. Abre STS o Eclipse.
2. Ve a File → Open Project from File System.
3. Haz clic en Directory y selecciona la carpeta descomprimida.
4. Haz clic en Finish.

### 🔹 Opción 2: Visual Studio Code
1. Abre **Visual Studio Code**.
2. Ve a **File** → **Open Folder**.
3. Selecciona la carpeta del proyecto descomprimida.
   
   📌 Notas Importante:
   Para un correcto funcionamiento en VS Code, asegúrate de tener instaladas las siguientes extensiones:
   - Spring Initializr Java Support
   - Spring Boot Dashboard
   - Spring Boot Tools
   - Spring Boot Extension Pack
   - Java Extension Pack


---

## 🗄3.  Configurar Base de Datos

Antes de ejecutar el proyecto, es necesario configurar la base de datos en **MySQL**.

### 📌 Crear Base de Datos y Tablas
```sql
CREATE DATABASE DB_SISTEMA_ACADEMICO;

USE DB_SISTEMA_ACADEMICO;

CREATE TABLE paises (
    id BIGINT AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    codigo_iso_2 CHAR(2) NOT NULL UNIQUE,
    PRIMARY KEY(id)
);

CREATE TABLE estudiantes (
    id BIGINT AUTO_INCREMENT NOT NULL,
    primer_nombre VARCHAR(30) NOT NULL,
    primer_apellido VARCHAR(30) NOT NULL,
    id_pais BIGINT NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (id),
    CONSTRAINT fk_pais FOREIGN KEY (id_pais) REFERENCES paises(id) ON UPDATE CASCADE
);

CREATE TABLE materias (
    id BIGINT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY(id)
);

CREATE TABLE matriculas (
    id_estudiante BIGINT NOT NULL,
    id_materia BIGINT NOT NULL,
    PRIMARY KEY (id_estudiante, id_materia),
    CONSTRAINT fk_estudiante FOREIGN KEY (id_estudiante) REFERENCES estudiantes(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_materia FOREIGN KEY (id_materia) REFERENCES materias(id) ON DELETE CASCADE ON UPDATE CASCADE,
    UNIQUE(id_estudiante, id_materia)
);
```

### 📌 Insertar Datos Importantes
```sql
INSERT INTO paises (nombre, codigo_iso_2) VALUES
("COLOMBIA", "CO"),
("MEXICO", "MX"),
("ARGENTINA", "AR"),
("CHILE", "CL"),
("VENEZUELA", "VE"),
("PARAGUAY", "PY"),
("URUGUAY", "UY"),
("BOLIVIA", "BO"),
("BRASIL", "BR"),
("ESTADOS UNIDOS", "US");

---
## 🛠 4. Configurar el archivo `application.properties`

Configura la conexión a la base de datos en el archivo `application.properties` dentro de `src/main/resources/`.

```properties
# Configuración de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/DB_SISTEMA_ACADEMICO
spring.datasource.username=TU_USUARIO_MYSQL
spring.datasource.password=TU_PASSWORD_MYSQL
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

```
---

## 🚀 5. Ejecutar el Proyecto

Para iniciar el backend, sigue estos pasos:

### 🔹 En Spring Tools Suite (STS) o Eclipse
1. Abre el proyecto.
2. En la vista de **Package Explorer**, haz clic derecho sobre el proyecto.
3. Selecciona **Run As** → **Spring Boot App**.

### 🔹 En Terminal (VS Code, IntelliJ, etc.)
1. Abre una terminal en la carpeta del proyecto.
2. Ejecuta:
   ```sh
   mvn spring-boot:run
   ```

---

## 📌 Notas Adicionales

- Por defecto, MySQL corre en el puerto **3306**. Si usa otro puerto, modifique `spring.datasource.url`.
- Asegúrese de que `DB_SISTEMA_ACADEMICO` coincida con el nombre de la base de datos creada.
- **Si el backend se ejecuta en un puerto distinto al 8080**, agregue `server.port=PUERTO_NUEVO` y también ajuste el frontend para apuntar al nuevo puerto.

---

## 🎯 Contacto
Para cualquier consulta o problema, no dudes en crear un issue en el repositorio o contactar al desarrollador.

🚀 ¡Disfruta del desarrollo! 🎉

📌 **Autor:** [Mohamar Chamorro](https://github.com/mohamarchamorro)\
📌 **Repositorio:** [backend-sistema-academico](https://github.com/mohamarchamorro/backend-sistema-academico)
