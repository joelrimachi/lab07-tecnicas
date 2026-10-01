# Bitacora de tecnicas avanzadas

Laboratorio 07: Tecnicas Avanzadas de Prompting. Herramienta de IA usada: (escribe aqui cual usaste)
##	Ejercicio	2:	Zero-shot, one-shot y few-shot
| Tipo | Aciertos (de 5) | Formato de la respuesta | Todas con el mismo formato (Si/No) |
| --- | --- | --- | --- |
| Zero-shot |5|Lista con explicaciones en viñetas | No|
| One-shot | 5| Lista clasificando los elementos|Si |
| Few-shot | 5| Solo el tecto limpio|Si |

##	Ejercicio	3:	Chain of Thought
| Pedido | Respuesta de la IA | Muestra los pasos (Si/No) | Correcta (Si/No) |
| --- | --- | --- | --- |
| Directo | 318.60 | No | Sí |
| Paso a paso | Detalla el precio con descuento (90), con IGV (106.20) y el total (318.60) | Sí | Sí |

**¿Por qué es útil ver el razonamiento aunque la respuesta directa haya sido correcta?**  
Ver el razonamiento permite auditar la lógica empleada y detectar con precisión el origen de cualquier discrepancia o error intermedio. Además, garantiza que el resultado no sea un acierto fortuito o una alucinación del modelo.

##	Ejercicio	4:	Role prompting

| Version | Vocabulario (sencillo/tecnico) | Usa ejemplos o codigo | A quien le sirve mas |
| --- | --- | --- | --- |
| A. Sin rol | General y directo | Breve con concepto estándar | A personas que buscan algo rápido |
| B. Rol docente | Muy sencillo  | Usa etiquetas  cotidiadas  | A estudiantes principiantes  sin experiencia  |
| C. Rol senior | Técnico y preciso | Usa sintaxis Java, habla de memoria, tipos de datos y alcance | A desarrolladores y programadores experimentados |
##	Ejercicio	5:	Descomposicion

### Registro de pasos:
- **Paso 1:** La IA enumeró 5 requisitos funcionales clave (gestión de productos, registro de stock, ventas, alertas de bajo stock y reportes).
- **Paso 2:** Definió la estructura del modelo con clases como `Producto`, `Inventario`, `Venta` y sus respectivos atributos tipados.
- **Paso 3:** Generó la implementación limpia de la clase `Producto` con encapsulamiento, constructor y métodos getter/setter.
- **Paso 4:** Sugirió 3 mejoras relevantes (validación de valores negativos en setters, método `toString()` y un identificador único/UUID).

### Comparación con el pedido de una sola vez:
Mientras que el pedido directo generó una respuesta genérica y superficial, la descomposición por pasos permitió estructurar el sistema progresivamente, obteniendo un diseño modular, detallado y con código directamente funcional.
##	Ejercicio	6:	Prompt estructurado y autocritica
## Ejercicio 6: Prompt estructurado y autocritica

```text
<rol>Actua como analista de pruebas de software.</rol>
<contexto>Login web con correo y contrasena. La cuenta se bloquea despues de 3 intentos fallidos.</contexto>
<tarea>Piensa paso a paso que puede fallar y escribe 6 casos de prueba.</tarea>
<formato>Tabla con las columnas: ID, escenario, datos de entrada, resultado esperado.</formato>

Autocrítica solicitada:
Revisa tu tabla: faltan casos limite como campos vacios, correo sin @ o contrasena con espacios? Agrega los que falten e indica cuales agregaste.
```

| Qué revisar | Cumple (Sí / No) |
| --- | --- |
| ¿Tiene las 4 columnas pedidas? | Sí |
| ¿Incluye el bloqueo después de 3 intentos? | Sí |
| ¿Incluye casos con campos vacíos? | Sí |
| ¿Indica qué casos agregó en la autocrítica? | Sí |
| ¿Hay algún caso repetido o que no tenga sentido? | No |
