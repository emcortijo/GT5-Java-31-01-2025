import java.util.*;

import javax.swing.JOptionPane;

public class Main {
    //object
    //name
    //price
    //stock
    public static void main(String[] args) {
        ArrayList<Producto> prods = new ArrayList<Producto>();

        boolean cont = true;

        while(cont) {

            String option = JOptionPane.showInputDialog("Gestor de inventario. "
                + "Seleccione una opción:"
                + "1. Añadir un nuevo producto"
                + "2. Mostrar la lista de productos"
                + "3. Eliminar un producto de la lista"
                + "4. Modificar el precio de un producto"
                + "5. Modificar el stock de un producto"
                + "6. Salir");

            switch (option) {
                case "1": //add object
                    break;
                case "2": //list
                    break;
                case "3": //remove object
                    break;
                case "4": //modify price
                    modificarPrecio(prods);
                    break;
                case "5": //modify stock
                    modificarStock(prods);
                    break;
                case "6": // exit
                    cont = false;
                    JOptionPane.showMessageDialog(null,
                        "Muchas gracias por utilizar el gestor");
                    break;
            }
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
                int newStock = Integer.parseInt(JOptionPane.showInputDialog(
                    "Escriba el nuevo stock del producto:"));
                if(newStock < 0){
                    System.out.println("El nuevo stock del producto debe ser positivo");
                } else {
                    prods.get(i).setCantidad(newStock);
                }
                found = true;
            }
        }

        if(!found){
            System.out.println("No se ha encontrado el producto con el nombre: "
                + name);
        }
    }
}
