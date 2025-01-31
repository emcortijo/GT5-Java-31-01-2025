import java.util.ArrayList;

import javax.swing.*;

public class Main {

    public static void addProducto(ArrayList<Producto> productos) {
        String nombreDeProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
        double precioDeProducto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio del producto: "));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad en inventario de producto: "));

        productos.add(new Producto(nombreDeProducto, precioDeProducto, cantidad));
    }

    public static void listProductos(ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos que mostrar");
            return;
        } else {
            for (Producto producto : productos) {
                producto.mostrarDetalles();
            }
        }
    }

    public static void deleteProducto(ArrayList<Producto> productos) {
        String productoParaEliminar = JOptionPane.showInputDialog("Ingrese el nombre del producto a eliminar: ");

        boolean eliminado = false;

        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(productoParaEliminar)) {
                productos.remove(producto);
                eliminado = true;
            }
        }
        if (!eliminado) {
            System.out.println("No existe producto a eliminar");
        }
    }
}
