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

        for (int i = 0; i < prods.size(); i++) {
            if (prods.get(i).getNombre().equalsIgnoreCase(name)) {
                double newPrice = Double.parseDouble(JOptionPane.showInputDialog(
                    "Escriba el nuevo precio del producto:"));
                prods.get(i).setPrecio(newPrice);
                break;
            }
        }
    }

    private static void modificarStock(ArrayList<Producto> prods){
        String name = JOptionPane.showInputDialog("Escriba el nombre del producto"
            + "cuyo stock desea modificar:");

        for (int i = 0; i < prods.size(); i++) {
            if (prods.get(i).getNombre().equalsIgnoreCase(name)) {
                double newStock = Double.parseDouble(JOptionPane.showInputDialog(
                    "Escriba el nuevo stock del producto:"));
                prods.get(i).setCantidad(newStock);
                break;
            }
        }
    }
}
