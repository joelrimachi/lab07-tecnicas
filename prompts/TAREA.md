# Tarea: Mi prompt avanzado

## Tarea elegida
Diseñar e implementar el modelo de clases y la lógica de validación para un módulo de registro de usuarios en Java, asegurando buenas prácticas de programación.

---

## Version 1: prompt basico
```text
Crea una clase en Java para registrar usuarios con nombre, correo y contraseña.
```

### Porque y que mejoro la respuesta:
- Tecnica: Ninguna
- Por qué: Es una solicitud directa básica.
- **Resultado: La IA generó un código básico sin validaciones de seguridad, sin un buen manejo de excepciones y con un formato simple.

---

## Version 2
```text
<rol>Actúa como Arquitecto de Software Java Senior.</rol>
<contexto>Estamos desarrollando el módulo de autenticación para una aplicación empresarial.</contexto>
<tarea>Diseña e implementa la clase Usuario en Java. Muestra el razonamiento paso a paso antes de entregar el código.</tarea>
<formato>Explicación del diseño seguida del código fuente Java bien documentado.</formato>
```

### Porque y que mejoro la respuesta:
- Técnica agregada: Role Prompting + Chain of Thought + Prompt Estructurado.
- Por qué: Asignar un rol senior mejora el nivel de respuesta,la cadena de pensamiento obliga a explicar la arquitectura antes de dar codigo.
- Resultado: La respuesta mejoró mucho en estructura y explicación, pero aún faltaban validaciones específicas y una autocrítica sobre seguridad.

---

## Version 3: prompt final
```text
<rol>Actúa como un Arquitecto de Software Java Senior especializado en ciberseguridad.</rol>
<contexto>Módulo de registro para una plataforma bancaria web. Se requiere validar correo, contraseña fuerte y manejo seguro de datos.</contexto>
<ejemplos>
Entrada válida: nombre="Juan Pérez", correo="juan@gmail.com", pass="C12345" -> UsuarioCreado(status=OK)
Entrada inválida: nombre="", 
</ejemplos>
<tarea>
1. Piensa paso a paso los riesgos de seguridad y las reglas de validación necesarias.
2. Implementa la clase Usuario en Java con encapsulamiento, atributos, constructor con validaciones y métodos get/set.
3. Realiza una autocrítica del código indicando posibles vulnerabilidades o puntos de mejora.
</tarea>
<formato>
- Secciones claras: ## Análisis de Seguridad, ## Código Java, ## Autocrítica y Mejoras.
</formato>
```

---

## Tecnicas usadas en el prompt final

| Técnica | Parte del prompt donde se aplica |
| --- | --- |
| Role Prompting | `<rol>Actúa como un Arquitecto de Software Java Senior especializado en ciberseguridad.</rol>` |
| Few-Shot | `<ejemplos>` con entradas válidas e inválidas y su resultado esperado. |
| Chain of Thought | `<tarea> 1. Piensa paso a paso los riesgos de seguridad y las reglas de validación necesarias.` |
| Prompt Estructurado | Uso de etiquetas  (`<rol>`, `<contexto>`, `<ejemplos>`, `<tarea>`, `<formato>`). |
| Autocrítica | Solicitud en el paso 3 de la tarea para revisar vulnerabilidades del propio código. |

---

## Evaluacion del resultado

| Criterio | Cumple (Sí / No) |
| --- | --- |
| ¿El prompt final combina al menos tres técnicas avanzadas? | Sí |
| ¿Asigna un rol específico y delimita el contexto de trabajo? | Sí |
| ¿Define el formato de respuesta mediante ejemplos y secciones? | Sí |
| ¿Incluye autocrítica sobre el código generado? | Sí |

---

## Por que elegi estas tecnicas
Elegí la combinación de Role Prompting, Prompt Estructurado, Few-Shot y Autocrítica porque el desarrollo de software seguro requiere alta precisión. El rol enfoca a la IA en un estándar profesional, las etiquetas evitan mezclar instrucciones, los ejemplos garantizan que la IA entienda el formato de entrada, salida y la autocrítica permite identificar fallos de seguridad o casos límite antes de llevar el código a producción.