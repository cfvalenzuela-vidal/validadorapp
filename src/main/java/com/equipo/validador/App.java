package com.equipo.validador;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    private static final Map<String, Camion> flotaCamiones = new HashMap<>();

    public static class Camion {
        private final String nombre;
        private final Ubicacion ubicacion;

        public Camion(String nombre, Ubicacion ubicacion) {
            this.nombre = nombre;
            this.ubicacion = ubicacion;
        }

        public String getNombre() {
            return nombre;
        }

        public Ubicacion getUbicacion() {
            return ubicacion;
        }
    }

    public static class Ubicacion {
        private final double lat;
        private final double lon;

        public Ubicacion(double lat, double lon) {
            this.lat = lat;
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public double getLon() {
            return lon;
        }
    }

    static {
        inicializarFlota();
    }

    public static void inicializarFlota() {
        flotaCamiones.clear();
        flotaCamiones.put("camion1", new Camion("Camión 1", new Ubicacion(-23.966792, -70.266262)));
        flotaCamiones.put("camion2", new Camion("Camión 2", new Ubicacion(-36.809805, -71.875676)));
        flotaCamiones.put("camion3", new Camion("Camión 3", new Ubicacion(-29.812288, -70.830762)));
    }

    public static Camion obtenerCamion(String id) {
        if (id == null || id.trim().isEmpty()) {
            LOGGER.warning("ID de camión no puede ser nulo o vacío");
            return null;
        }
        return flotaCamiones.get(id.toLowerCase());
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            LOGGER.severe("Debe proporcionar al menos un ID de camión");
            return;
        }

        for (String id : args) {
            mostrarInformacionCamion(id);
        }
    }

    public static void mostrarInformacionCamion(String id) {
        Camion camion = obtenerCamion(id);
        if (camion == null) {
            LOGGER.warning(() -> String.format("Camión con ID '%s' no encontrado", id));
            return;
        }

        LOGGER.info("Información del camión");
        LOGGER.info(() -> String.format("  Nombre: %s", camion.getNombre()));
        LOGGER.info(() -> String.format("  Ubicación: Lat=%.6f, Lon=%.6f", 
            camion.getUbicacion().getLat(), 
            camion.getUbicacion().getLon()));
    }
}