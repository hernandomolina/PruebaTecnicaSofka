# Prueba Técnica QA - Finexus

## Descripción del Proyecto
Proyecto de automatización de pruebas para la página web [Sauce Demo](https://www.saucedemo.com/) implementando:
- Framework Serenity BDD
- Patrón de diseño Screenplay
- Cucumber para BDD
- Integración con Selenium WebDriver

## Escenarios Automatizados
### 1. Login
- Login exitoso con credenciales válidas
- Login fallido con credenciales inválidas

### 2. Carrito de Compras
- Agregar un producto al carrito y validar el contador, el nombre, el precio y el total de productos

### 3. Proceso de Checkout
- Validar formulario de checkout con datos válidos y avanzar al resumen
- Validar que no se permite avanzar si el formulario está incompleto (nombre, apellido o código postal faltante)
- Validar pantalla de resumen y finalizar compra exitosamente

### 4. Regresión del flujo completo
- Validar el flujo completo: login, agregar producto, checkout, resumen y confirmación de orden

## Pre-requisitos
- Java 11 o superior
- Maven 3.6.3 o superior
- Google Chrome (última versión)
- Conexión a Internet

## Estructura del Proyecto
```
src/
├── main/java/com/pruebatecnicaqa/
│   ├── tasks/           # Tareas del patrón Screenplay
│   ├── questions/       # Preguntas para validaciones
│   ├── userinterfaces/  # Page Objects y localizadores
│   ├── interactions/    # Interacciones personalizadas
│   └── utils/          # Utilidades y helpers
└── test/
    ├── java/com/pruebatecnicaqa/
    │   ├── runners/     # Runners de Cucumber
    │   └── stepdefinitions/  # Definiciones de pasos
    └── resources/
        └── features/    # Archivos .feature
```

## Instalación y Ejecución
1. Clonar el repositorio:
   ```bash
   git clone [URL_DEL_REPO]
   cd PruebaTecnicaQA
   ```

2. Instalar dependencias:
   ```bash
   mvn clean install
   ```

3. Ejecutar las pruebas:
   ```bash
   mvn clean verify
   ```

## CI/CD con GitHub Actions
El proyecto incluye configuración de CI/CD con GitHub Actions que se ejecuta automáticamente en:
- Push a ramas `main` y `develop`
- Pull requests a ramas `main` y `develop`

### Pipeline de CI/CD
- **Checkout**: Descarga del código fuente
- **Setup Java**: Configuración de JDK 11
- **Cache**: Almacenamiento en caché de dependencias Maven y reportes Serenity
- **Install Chrome**: Instalación de Chrome para pruebas headless
- **Run Tests**: Ejecución de pruebas con Maven
- **Upload Artifacts**: Subida de reportes Serenity y resultados de pruebas
- **Publish Reports**: Publicación de reportes en GitHub Pages

### Reportes en CI/CD
Los reportes de Serenity se publican automáticamente en GitHub Pages después de cada ejecución exitosa del pipeline.

## Reportes
Los reportes de Serenity se generan en:
- `target/site/serenity/index.html`

Incluyen:
- Dashboard general
- Desglose por features
- Screenshots de pasos críticos
- Métricas de ejecución

## Configuración
### serenity.properties
```properties
webdriver.driver=chrome
serenity.project.name=Prueba Tecnica QA
serenity.take.screenshots=AFTER_EACH_STEP
```

## Dependencias Principales
- Serenity BDD Core: 3.9.8
- Serenity Cucumber: 3.9.8
- Selenium WebDriver: 4.10.0
- WebDriverManager: 5.4.1
- JUnit: 4.13.2

## Buenas Prácticas Implementadas
1. Patrón Screenplay para mejor mantenibilidad
2. Page Objects para gestión de elementos UI
3. Cucumber para especificaciones ejecutables
4. Screenshots automáticos en pasos críticos
5. Manejo de esperas explícitas
6. Reportes detallados con Serenity
