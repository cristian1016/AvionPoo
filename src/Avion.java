
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Avion {
	
    private String modelo;
    private String fabricante;
    private int capacidadPasajeros;
    private int velocidadMaxima;
    
    public Avion() {
  
    }

    public Avion(String modelo, String fabricante, int capacidadPasajeros, int velocidadMaxima, int velocidadMax) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.capacidadPasajeros = capacidadPasajeros;
        this.velocidadMaxima = velocidadMaxima;
    }
	
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }


	public void mostrarInformacion() {
	    JOptionPane.showMessageDialog(null, "------------Información----------\n" +
	            "Modelo: " + modelo + "\n" +
	            "Fabricante: " + fabricante + "\n" +
	            "Capacidad de pasajeros: " + capacidadPasajeros + "\n" +
	            "velocidad maxima: " + velocidadMaxima + "\n" +
	            "---------------------------------");
	    System.out.println(toString());
	}
	
    public String toString() {
        return "Avion [modelo=" + modelo + ", fabricante=" + fabricante + ", capacidadPasajeros=" + capacidadPasajeros
                + ", velocidadMaxima=" + velocidadMaxima + "]";
    }
	
    public void ingresarDatos() {
        modelo = JOptionPane.showInputDialog("Ingrese el modelo ");
        fabricante = JOptionPane.showInputDialog("Ingrese el fabricante");
        capacidadPasajeros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de pasajeros"));
        velocidadMaxima = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la velocidad maxima"));
    }
    
    public static void main(String[] args) {
        ArrayList<Avion> listaAviones = new ArrayList<>();
        HashMap<String, Avion> mapAviones = new HashMap<>();

        int opcion;
        String menu = "";
        do {
            menu = "MENU\n";
            menu += "Te amo maldita estupida doga\n";
            menu += "1. Crear avion\n";
            menu += "2. Consultar avion individual\n";
            menu += "3. Consultar lista de aviones\n";
            menu += "4. Modificar una avion\n";
            menu += "5. Salir\n";
            menu += "Ingrese una opción:\n ";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    Avion avion = new Avion();
                    avion.ingresarDatos();
                    listaAviones.add(avion);
                    mapAviones.put(avion.getModelo(), avion);
                    break;
                    
                case 2:
                    String modelo = JOptionPane.showInputDialog("Ingrese el modelo del avion a consultar: ");
                    if (mapAviones.containsKey(modelo)) {
                    	Avion mascotaConsultada = mapAviones.get(modelo);
                        mascotaConsultada.mostrarInformacion();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ningun avion con la identificación ingresada.");
                    }
                    break;
                case 3:
                    String lista = "Lista de aviones:\n";
                    for (Avion avionLista : listaAviones) {
                        lista += "Modelo: " + avionLista.getModelo() + ", avion: " + avionLista.getFabricante() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, lista);
                    break;
                case 4:
                    modelo = JOptionPane.showInputDialog("Ingrese el modelo del avion a modificar: ");
                    if (mapAviones.containsKey(modelo)) {
                        Avion avionModificar = mapAviones.get(modelo);
                        avionModificar.ingresarDatos();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ningun avion con el modelo ingresado.");
                    }
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "*************Saliendo del sistema***********\n");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }
}
    