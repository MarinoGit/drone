package com.marino.drone;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by
 *
 * @author marinovilchez
 * @soundtrack Quique Gonzalez - Doble fila
 * @since 19/5/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class DroneRoutesTests {

    List<String> idUrbanizacionesRango_1 = Arrays.asList("id urbanización7", "id urbanización8", "id urbanización9", "id urbanización12", "id urbanización13", "id urbanización14", "id urbanización17", "id urbanización18", "id urbanización19"); // size 9
    List<String> idUrbanizacionesRango_2 = Arrays.asList("Larry", "Moe", "Curly"); // size 24
    List<String> idUrbanizacionesRango_3 = Arrays.asList("Larry", "Moe", "Curly"); // size 48

    @Test
    public void obtenerUrbanizaciones() {
        Drone drone = new Drone();
        Set<String> lista1 = drone.obtenerUrbanizaciones(38.56889, 40.511107, 1);
        Assert.assertTrue("la lista de urbanizaciones es igual", lista1.size() == idUrbanizacionesRango_1.size());
        Set<String> lista2 = drone.obtenerUrbanizaciones(38.56889, 40.511107, 2);
        Assert.assertTrue("la lista de urbanizaciones es igual", lista2.size() == 24);
        Set<String> lista3 = drone.obtenerUrbanizaciones(38.56889, 40.511107, 3);
        Assert.assertTrue("la lista de urbanizaciones es igual", lista3.size() == 48);
        Set<String> lista4 = drone.obtenerUrbanizaciones(38.56889, 40.511107, 4);

    }
}
