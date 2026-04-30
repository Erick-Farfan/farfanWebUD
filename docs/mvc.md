# Documentación MVC - FarfanWebUD

Este proyecto implementa el patrón Model View Controller (MVC), el cual permite separar la lógica de negocio, la interfaz de usuario y el control de la aplicación.

---

## Modelo (Model)

El modelo está compuesto por las clases ubicadas en el paquete `asp.modelo`.

Clases principales:

* Persona
* Aspirante (hereda de Persona)
* ProgAcad
* AspiranteDAO
* ProgAcadDAO

Función:

El modelo se encarga de representar los datos del sistema y su estructura.
Las clases DAO almacenan la información en memoria mediante listas.

Ejemplo:

* Aspirante contiene los datos del usuario registrado
* ProgAcad representa los programas académicos

---

## Controlador (Controller)

El controlador está representado por la clase:

* AspiranteBean

Ubicación:

* paquete `asp.bean`

Función:

* Recibe los datos desde la vista
* Procesa la información
* Interactúa con el modelo
* Devuelve resultados a la vista

Ejemplo:

El método `registrar()` permite:

* Validar datos
* Asignar programa académico
* Guardar el aspirante
* Generar mensaje de confirmación

---

## Vista (View)

La vista está compuesta por archivos XHTML:

* index.xhtml
* asp.xhtml
* admin.xhtml

Función:

* Mostrar la información al usuario
* Capturar datos mediante formularios

Ejemplo:

Se utiliza JSF para enlazar la vista con el controlador:

#{asp.dto.nombres}

---

## Flujo del sistema

1. El usuario ingresa datos en el formulario (Vista)
2. JSF envía la información al AspiranteBean (Controlador)
3. El controlador procesa los datos
4. Se almacenan en el modelo (DAO)
5. La vista muestra el resultado

---

## Conclusión

El proyecto cumple con el patrón MVC al separar correctamente:

* Datos (Modelo)
* Lógica de control (Controlador)
* Interfaz gráfica (Vista)
