import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalogo catalogo = inicializarCatalogo();
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            procesarOpcion(opcion, catalogo, scanner);
            
        } while (opcion != 4);

        System.out.println("\n¡Gracias por usar el sistema! Hasta pronto.");
        scanner.close();
    }

    
    private static Catalogo inicializarCatalogo() {
        Catalogo catalogo = new Catalogo();

        catalogo.agregarDispositivo(new SensorSuelo("SS001", "Sensor Humedad A", "AgroTech", 
            0.5, "Parcela Norte", 0.3, "Capacitivo", 65.5));
        
        catalogo.agregarDispositivo(new SensorSuelo("SS002", "Sensor pH B", "SoilMaster", 
            0.4, "Parcela Sur", 0.25, "Electroquímico", 6.8));
        
        catalogo.agregarDispositivo(new SensorSuelo("SS003", "Sensor NPK C", "FarmSense", 
            0.6, "Invernadero 1", 0.35, "Óptico", 78.2));

        catalogo.agregarDispositivo(new Dron("DR001", "Dron Pulverizador Alpha", "SkyAgro", 
            2.5, "Base Central", 45, 15.0, 120.0));
        
        catalogo.agregarDispositivo(new Dron("DR002", "Dron Monitor Beta", "AirFarm", 
            2.0, "Base Este", 60, 10.0, 150.0));
        
        catalogo.agregarDispositivo(new Dron("DR003", "Dron Multiespectral Gamma", "DroneVision", 
            2.8, "Base Oeste", 40, 8.0, 100.0));

        catalogo.agregarDispositivo(new SistemaRiego("SR001", "Sistema Goteo Principal", "IrrigaTech", 
            3.5, "Sector A", 24, 180.0, 45.0));
        
        catalogo.agregarDispositivo(new SistemaRiego("SR002", "Sistema Aspersión B", "WaterPro", 
            5.0, "Sector B", 16, 250.0, 60.0));
        
        catalogo.agregarDispositivo(new SistemaRiego("SR003", "Sistema Microrriego C", "EcoWater", 
            2.2, "Invernadero 2", 32, 120.0, 35.0));
        
        catalogo.agregarDispositivo(new SistemaRiego("SR004", "Sistema Nebulización D", "MistFarm", 
            1.8, "Vivero", 12, 80.0, 50.0));

        return catalogo;
    }

    private static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GESTIÓN AGRO-TECNOLÓGICA             ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.println("1. Listar todos los equipos");
        System.out.println("2. Buscar equipo (por ID o nombre)");
        System.out.println("3. Ordenar por consumo eléctrico");
        System.out.println("4. Salir");
        System.out.print("\nSeleccione una opción: ");
    }

    private static void procesarOpcion(int opcion, Catalogo catalogo, Scanner scanner) {
        switch (opcion) {
            case 1:
                listarEquipos(catalogo);
                break;
            case 2:
                buscarEquipo(catalogo, scanner);
                break;
            case 3:
                ordenarPorConsumo(catalogo);
                break;
            case 4:
                break;
            default:
                System.out.println("\n⚠ Opción inválida. Intente nuevamente.");
        }
    }

    private static void listarEquipos(Catalogo catalogo) {
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("LISTADO COMPLETO DE EQUIPOS (" + catalogo.obtenerCantidad() + " dispositivos)");
        System.out.println("═══════════════════════════════════════════════════════════════");
        
        int contador = 1;
        for (Dispositivo d : catalogo.obtenerTodos()) {
            System.out.println("\n[" + contador + "] " + d.toString());
            
            System.out.print("    Capacidades: ");
            if (d instanceof Medible) System.out.print("✓ Medible ");
            if (d instanceof Accionable) System.out.print("✓ Accionable ");
            if (d instanceof Registrable) System.out.print("✓ Registrable");
            System.out.println();
            
            contador++;
        }
        System.out.println("\n═══════════════════════════════════════════════════════════════");
    }

    private static void buscarEquipo(Catalogo catalogo, Scanner scanner) {
        System.out.println("\n--- BÚSQUEDA DE EQUIPOS ---");
        System.out.println("1. Buscar por ID");
        System.out.println("2. Buscar por nombre");
        System.out.print("Seleccione tipo de búsqueda: ");
        int tipoBusqueda = scanner.nextInt();
        scanner.nextLine();

        if (tipoBusqueda == 1) {
            System.out.print("Ingrese el ID: ");
            String id = scanner.nextLine();
            Dispositivo d = catalogo.buscarPorId(id);
            
            if (d != null) {
                System.out.println("\n✓ Equipo encontrado:");
                System.out.println(d.toString());
                
                if (d instanceof Medible) {
                    System.out.println("  → " + ((Medible) d).obtenerMedicion());
                }
            } else {
                System.out.println("\n✗ No se encontró ningún equipo con ese ID.");
            }
            
        } else if (tipoBusqueda == 2) {
            System.out.print("Ingrese el nombre (parcial): ");
            String nombre = scanner.nextLine();
            ArrayList<Dispositivo> resultados = catalogo.buscarPorNombre(nombre);
            
            if (resultados.isEmpty()) {
                System.out.println("\n✗ No se encontraron equipos con ese nombre.");
            } else {
                System.out.println("\n✓ Se encontraron " + resultados.size() + " equipos:");
                for (Dispositivo d : resultados) {
                    System.out.println("  • " + d.toString());
                }
            }
        } else {
            System.out.println("\n⚠ Opción de búsqueda inválida.");
        }
    }

    private static void ordenarPorConsumo(Catalogo catalogo) {
        catalogo.ordenarPorConsumo();
        System.out.println("\n═══════════════════════════════════════════════════════════════");
        System.out.println("EQUIPOS ORDENADOS POR CONSUMO ELÉCTRICO (menor a mayor)");
        System.out.println("═══════════════════════════════════════════════════════════════");
        
        int posicion = 1;
        for (Dispositivo d : catalogo.obtenerTodos()) {
            System.out.printf("\n[%d] %s\n", posicion, d.getNombre());
            System.out.printf("    Consumo: %.2f kW/h | Ubicación: %s\n", 
                            d.getConsumoElectrico(), d.getUbicacion());
            posicion++;
        }
        System.out.println("\n═══════════════════════════════════════════════════════════════");
    }
}
