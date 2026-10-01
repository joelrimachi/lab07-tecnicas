import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Producto {

    private String id;
    private String nombre;
    private String categoria;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private int stockActual;
    private int stockMinimo;

    public Producto(String id, String nombre, String categoria, BigDecimal precioCompra, 
                    BigDecimal precioVenta, int stockActual, int stockMinimo) {
        setId(id);
        setNombre(nombre);
        setCategoria(categoria);
        setPrecioCompra(precioCompra);
        setPrecioVenta(precioVenta);
        setStockActual(stockActual);
        setStockMinimo(stockMinimo);
    }

    // --- MEJORA 1: Métodos de dominio para gestión de stock ---

    /**
     * Incrementa el stock actual en la cantidad especificada.
     */
    public void aumentarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a ingresar debe ser mayor a cero.");
        }
        this.stockActual += cantidad;
    }

    /**
     * Reduce el stock actual verificando que exista suficiente disponibilidad.
     */
    public void disminuirStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a retirar debe ser mayor a cero.");
        }
        if (cantidad > this.stockActual) {
            throw new IllegalStateException("Stock insuficiente. Disponible: " + this.stockActual + ", solicitado: " + cantidad);
        }
        this.stockActual -= cantidad;
    }

    public boolean requiereReabastecimiento() {
        return this.stockActual <= this.stockMinimo;
    }

    // --- MEJORA 2: Métodos para cálculo de ganancia ---

    /**
     * Retorna la ganancia monetaria por unidad (Precio Venta - Precio Compra).
     */
    public BigDecimal getGananciaUnitaria() {
        return this.precioVenta.subtract(this.precioCompra);
    }

    /**
     * Retorna el porcentaje de margen sobre el costo de compra.
     */
    public double getMargenPorcentual() {
        if (precioCompra == null || precioCompra.compareTo(BigDecimal.ZERO) == 0) {
            return 0.0;
        }
        return getGananciaUnitaria()
                .divide(precioCompra, 4, RoundingMode.HALF_UP)
                .multiply(new BigDecimal("100"))
                .doubleValue();
    }

    // --- MEJORA 3: Getters y Setters con validación de datos ---

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID o código de barras no puede estar vacío.");
        }
        this.id = id.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría no puede estar vacía.");
        }
        this.categoria = categoria.trim();
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        if (precioCompra == null || precioCompra.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio de compra no puede ser nulo ni negativo.");
        }
        this.precioCompra = precioCompra;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        if (precioVenta == null || precioVenta.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio de venta no puede ser nulo ni negativo.");
        }
        this.precioVenta = precioVenta;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        if (stockActual < 0) {
            throw new IllegalArgumentException("El stock actual no puede ser negativo.");
        }
        this.stockActual = stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        if (stockMinimo < 0) {
            throw new IllegalArgumentException("El stock mínimo no puede ser negativo.");
        }
        this.stockMinimo = stockMinimo;
    }

    // --- Métodos estándar ---

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precioVenta=" + precioVenta +
                ", stockActual=" + stockActual +
                ", reabastecer=" + requiereReabastecimiento() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}