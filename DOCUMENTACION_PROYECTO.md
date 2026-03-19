# Documentación del Proyecto Integrador - Sistema de Gestión de Verificaciones Vehiculares

## Descripción General
Este proyecto es un sistema integral para la gestión de verificaciones vehiculares, incluyendo la administración de usuarios, clientes, vehículos, verificaciones, evaluaciones y transacciones relacionadas.

## Estructura de la Base de Datos

### 1. **USUARIOS** (BeanUsuario)
- Tabla: `usuarios`
- Descripción: Almacena información de usuarios del sistema (ADMIN y TÉCNICO)
- Relaciones:
  - **1:N con COSTOS** (como encargado y como atencionCobro)
  - **1:N con NOTAS** (como atendido y como revisado)
  - **1:N con EVALUACIONES** (como técnico)
  - **1:N con TRANSACCIONES** (como revisó y como atendió)

### 2. **REGIONES** (BeanRegion)
- Tabla: `regiones`
- Descripción: Divide el territorio en regiones geográficas
- Relaciones:
  - **1:N con CEDIS**
  - **1:N con VERIFICENTROS**

### 3. **CLIENTES** (BeanCliente)
- Tabla: `clientes`
- Descripción: Información de los clientes/empresas
- Relaciones:
  - **1:N con CEDIS**
  - **1:N con VEHICULOS**
  - **1:N con NOTAS**
  - **1:N con COSTOS**

### 4. **CEDIS** (BeanCedi)
- Tabla: `cedis`
- Descripción: Centros de distribución de clientes
- Relaciones:
  - **N:1 con CLIENTES**
  - **N:1 con REGIONES**
  - **1:N con VEHICULOS**

### 5. **VEHICULOS** (BeanVehiculo)
- Tabla: `vehiculos`
- Descripción: Vehículos de clientes a verificar
- Relaciones:
  - **N:1 con CLIENTES**
  - **N:1 con CEDIS**
  - **1:N con VERIFICACIONES**

### 6. **VERIFICENTROS** (BeanVerificentro)
- Tabla: `verificentros`
- Descripción: Centros autorizados para realizar verificaciones
- Relaciones:
  - **N:1 con REGIONES**
  - **1:N con NOTAS**

### 7. **COSTOS** (BeanCosto)
- Tabla: `costos`
- Descripción: Costos de verificación por cliente y materia
- Relaciones:
  - **N:1 con CLIENTES**
  - **N:1 con USUARIOS** (encargado)
  - **N:1 con USUARIOS** (atencionCobro)

### 8. **NOTAS** (BeanNota)
- Tabla: `notas`
- Descripción: Notas de verificación creadas en los verificentros
- Relaciones:
  - **N:1 con CLIENTES**
  - **N:1 con VERIFICENTROS**
  - **N:1 con USUARIOS** (atendió)
  - **N:1 con USUARIOS** (revisó)
  - **1:N con VERIFICACIONES**
  - **1:N con TRANSACCIONES**
  - **1:N con PEDIDOS**

### 9. **VERIFICACIONES** (BeanVerificacion)
- Tabla: `verificaciones`
- Descripción: Detalle de verificaciones en cada nota
- Relaciones:
  - **N:1 con NOTAS**
  - **N:1 con VEHICULOS**
  - **1:N con EVALUACIONES**

### 10. **EVALUACIONES** (BeanEvaluacion)
- Tabla: `evaluaciones`
- Descripción: Evaluación detallada de vehículos (luces, llantas, etc.)
- Relaciones:
  - **N:1 con VERIFICACIONES**
  - **N:1 con USUARIOS** (técnico)
  - **1:N con EVIDENCIAS_EVALUACION**

### 11. **TRANSACCIONES** (BeanTransaccion)
- Tabla: `transacciones`
- Descripción: Registro de transacciones de pago
- Relaciones:
  - **N:1 con NOTAS**
  - **N:1 con USUARIOS** (revisó)
  - **N:1 con USUARIOS** (atendió)

### 12. **PEDIDOS** (BeanPedido)
- Tabla: `pedidos`
- Descripción: Envíos y entregas de documentos
- Relaciones:
  - **N:1 con NOTAS**

### 13. **EVIDENCIAS_EVALUACION** (BeanEvidenciaEvaluacion)
- Tabla: `evidencias_evaluacion`
- Descripción: Fotos y evidencias de evaluaciones
- Relaciones:
  - **N:1 con EVALUACIONES**

## Diagrama de Relaciones (Texto)

```
USUARIOS (hub central)
├── 1:N ← COSTOS (encargado)
├── 1:N ← COSTOS (atencionCobro)
├── 1:N ← NOTAS (atendió)
├── 1:N ← NOTAS (revisó)
├── 1:N ← EVALUACIONES (técnico)
├── 1:N ← TRANSACCIONES (revisó)
└── 1:N ← TRANSACCIONES (atendió)

REGIONES (hub de localización)
├── 1:N ← CEDIS
└── 1:N ← VERIFICENTROS

CLIENTES (hub comercial)
├── 1:N ← CEDIS
├── 1:N ← VEHICULOS
├── 1:N ← NOTAS
└── 1:N ← COSTOS

CEDIS
├── N:1 → CLIENTES
├── N:1 → REGIONES
└── 1:N ← VEHICULOS

VEHICULOS
├── N:1 → CLIENTES
├── N:1 → CEDIS
└── 1:N ← VERIFICACIONES

VERIFICENTROS
├── N:1 → REGIONES
└── 1:N ← NOTAS

NOTAS (hub principal de proceso)
├── N:1 → CLIENTES
├── N:1 → VERIFICENTROS
├── N:1 → USUARIOS (atendió)
├── N:1 → USUARIOS (revisó)
├── 1:N ← VERIFICACIONES
├── 1:N ← TRANSACCIONES
└── 1:N ← PEDIDOS

VERIFICACIONES
├── N:1 → NOTAS
├── N:1 → VEHICULOS
└── 1:N ← EVALUACIONES

EVALUACIONES
├── N:1 → VERIFICACIONES
├── N:1 → USUARIOS (técnico)
└── 1:N ← EVIDENCIAS_EVALUACION

TRANSACCIONES
├── N:1 → NOTAS
├── N:1 → USUARIOS (revisó)
└── N:1 → USUARIOS (atendió)

PEDIDOS
└── N:1 → NOTAS

EVIDENCIAS_EVALUACION
└── N:1 → EVALUACIONES
```

## Flujo de Proceso Típico

1. **Registrar Cliente y Vehículos**
   - Cliente crea cuentas de usuario
   - Se registran vehículos con placa y serie

2. **Crear Nota en Verificentro**
   - Se crea una nota de verificación
   - Se asigna verificentro y cliente

3. **Registrar Verificaciones**
   - Se asocian vehículos a la nota
   - Se captura información inicial (tipo de materia, precio)

4. **Evaluación por Técnico**
   - El técnico captura detalles (luces, llantas, etc.)
   - Se suben evidencias fotográficas
   - Se genera dictamen (APROBADO/REPROBADO)

5. **Procesar Transacción**
   - Se registra el tipo de pago y monto
   - Se marca como pagado o pendiente

6. **Envío de Documentos**
   - Se crea pedido con guía de envío
   - Se adjunta evidencia fotográfica de entrega

## Características Principales

- ✅ Gestión completa de usuarios con roles (ADMIN/TÉCNICO)
- ✅ Control de regiones y ubicaciones
- ✅ Administración de clientes y sus centros de distribución
- ✅ Registro de vehículos con placas únicas
- ✅ Proceso de verificación detallado
- ✅ Evaluaciones con múltiples criterios
- ✅ Evidencias fotográficas por campo evaluado
- ✅ Gestión de transacciones y pagos
- ✅ Control de envíos y entregas
- ✅ Estados y dictámenes configurables
