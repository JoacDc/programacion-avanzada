# Programación Avanzada

Este repositorio contiene ejercicios y prácticas de **programación avanzada** utilizando Git y GitHub.  
Se sigue una **estrategia de ramificación estructurada** para mantener el proyecto organizado:

- `main`: rama principal y estable.
- `develop`: rama de integración para desarrollo general.
- `feature/*`: ramas de funcionalidades específicas.

---

## Inicializar el proyecto

Para crear un repositorio local y conectarlo con GitHub:

```bash
# Inicializar el repositorio Git local
git init

# Crear y moverse a la rama principal 'main'
git branch -M main

# Agregar el repositorio remoto
git remote add origin https://github.com/JoacDc/programacion-avanzada.git

# Subir la rama main al remoto
git push -u origin main

# Crear la rama de desarrollo 'develop'
git branch develop
git push -u origin develop

## CREAR UNA RAMA DE FUNCIONALIDAD
# Cambiar a la rama develop
git checkout develop

# Crear y moverse a la rama de funcionalidad
git checkout -b feature/functionAgregate

# Subir la rama de funcionalidad al remoto
git push -u origin feature/functionAgregate

## Crear y modificar archivos
# Primera modificación: agregar archivo1
git add archivo1.txt
git commit -m "Agregar archivo1 con contenido inicial"

# Segunda modificación: agregar archivo2
git add archivo2.txt
git commit -m "Agregar archivo2 con contenido inicial"

# Tercera modificación: actualizar archivo1
git add archivo1.txt
git commit -m "Actualizar contenido de archivo1"

# Cuarta modificación: actualizar archivo2
git add archivo2.txt
git commit -m "Actualizar contenido de archivo2"

## SUBIR CAMBIO
# Subir todos los commits de la rama de funcionalidad
git push origin feature/functionAgregate

# Commit adicional sugerido por el profesor
git add .
git commit -m "SUGERENCIA DEL PROFE"
git push origin feature/functionAgregate


