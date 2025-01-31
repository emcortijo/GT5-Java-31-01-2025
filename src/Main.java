import java.util.*;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        ArrayList<Producto> prods = new ArrayList<Producto>();

        boolean cont = true;

        while(cont) {

            String option = JOptionPane.showInputDialog("Gestor de inventario. "
                + "Seleccione una opción:\n"
                + "1. Añadir un nuevo producto\n"
                + "2. Mostrar la lista de productos\n"
                + "3. Eliminar un producto de la lista\n"
                + "4. Modificar el precio de un producto\n"
                + "5. Modificar el stock de un producto\n"
                + "6. Salir");

            switch (option) {
                case "1":
                    addProducto(prods);
                    break;
                case "2":
                    listProductos(prods);
                    break;
                case "3":
                    deleteProducto(prods);
                    break;
                case "4":
                    modificarPrecio(prods);
                    break;
                case "5":
                    modificarStock(prods);
                    break;
                case "6":
                    cont = false;
                    JOptionPane.showMessageDialog(null,
                        "Muchas gracias por utilizar el gestor");
                    break;
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

    private static void modificarPrecio(ArrayList<Producto> prods){
        String name = JOptionPane.showInputDialog("Escriba el nombre del producto"
            + "cuyo precio desea modificar:");

        boolean found = false;
        for (int i = 0; i < prods.size() && !found; i++) {
            if (prods.get(i).getNombre().equalsIgnoreCase(name)) {

                double newPrice = Double.parseDouble(JOptionPane.showInputDialog(
                    "Escriba el nuevo precio del producto:"));
                if(newPrice < 0){
                    System.out.println("El nuevo precio del producto debe ser positivo");
                } else {
                    prods.get(i).setPrecio(newPrice);
                }
                found = true;
            }
        }

        if(!found){
            System.out.println("No se ha encontrado el producto con el nombre: "
            + name);
        }
    }

    private static void modificarStock(ArrayList<Producto> prods){
        String name = JOptionPane.showInputDialog("Escriba el nombre del producto"
            + "cuyo stock desea modificar:");

        boolean found = false;
        for (int i = 0; i < prods.size() && !found; i++) {
            if (prods.get(i).getNombre().equalsIgnoreCase(name)) {
                int newStock;
                try{
                    newStock = Integer.parseInt(JOptionPane.showInputDialog("Escriba el nuevo stock del producto:"));
                    if(newStock<0) {
                        System.out.println("Introduzca una cantidad válida");
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Introduzca una cantidad válida");
                    return;
                }
                prods.get(i).setCantidad(newStock);
                found = true;
            }
        }

        if(!found){
            System.out.println("No se ha encontrado el producto con el nombre: "
                + name);
        }
    }

    public static void addProducto(ArrayList<Producto> productos) {
        String nombreDeProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
        double precioDeProducto;
        try{
            precioDeProducto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio del producto: "));
            if(precioDeProducto<0) {
                System.out.println("Introduzca un precio válido");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Introduzca un precio válido ");
            return;
        }

        int cantidad;
        try{
            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad en inventario de producto: "));
            if(cantidad<0) {
                System.out.println("Introduzca una cantidad válida");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Introduzca una cantidad ");
            return;
        }


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
}