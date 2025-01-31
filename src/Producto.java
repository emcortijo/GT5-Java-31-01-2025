public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    private static int inventarioTotal=0;

    public Producto(String nombre,double precio,int cantidad){
        this.nombre=nombre;
        this.precio=precio;
        this.cantidad=cantidad;
        inventarioTotal+=cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void mostrarDetalles(){
        System.out.println("Nombre del producto: "+nombre);
        System.out.println("Precio: $"+String.format("%.2f",precio));
        System.out.println("Cantidad de inventario: "+cantidad);
        System.out.println("-------");
    }

    public static int getInventarioTotal(){
        return inventarioTotal;
    }
}