import java.util.ArrayList;
import java.util.Collections;

public class Catalogo {
    private ArrayList<Dispositivo> dispositivos;

    public Catalogo() {
        this.dispositivos = new ArrayList<>();
    }
    public void agregarDispositivo(Dispositivo dispositivo) {
        dispositivos.add(dispositivo);
    }

    public Dispositivo buscarPorId(String id) {
        for (Dispositivo d : dispositivos) {
            if (d.getId().equalsIgnoreCase(id)) {
                return d;
            }
        }
        return null;
    }

    public ArrayList<Dispositivo> buscarPorNombre(String nombre) {
        ArrayList<Dispositivo> resultados = new ArrayList<>();
        for (Dispositivo d : dispositivos) {
            if (d.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(d);
            }
        }
        return resultados;
    }

    public ArrayList<Dispositivo> obtenerTodos() {
        return dispositivos;
    }

    public void ordenarPorConsumo() {
        Collections.sort(dispositivos);
    }

    public int obtenerCantidad() {
        return dispositivos.size();
    }
}
