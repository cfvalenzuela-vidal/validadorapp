package com.equipo.validador;

import junit.framework.TestCase;

public class AppManualTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        App.inicializarFlota();
    }

    public void testObtenerCamionExistente() {
        App.Camion camion = App.obtenerCamion("camion1");
        assertNotNull("Camion debe existir", camion);
        assertEquals("Camión 1", camion.getNombre());
    }

    public void testObtenerCamionInexistente() {
        App.Camion camion = App.obtenerCamion("noexiste");
        assertNull("Camion no debe existir", camion);
    }

    public void testObtenerCamionNuloOVacio() {
        assertNull("ID null debe retornar null", App.obtenerCamion(null));
        assertNull("ID vacío debe retornar null", App.obtenerCamion(""));
    }

    public void testMostrarInformacionCamionNoLanzaExcepcion() {
        try {
            App.mostrarInformacionCamion("camion2");
            App.mostrarInformacionCamion("noexiste");
        } catch (Exception e) {
            fail("mostrarInformacionCamion lanzó excepción inesperada");
        }
    }
}
