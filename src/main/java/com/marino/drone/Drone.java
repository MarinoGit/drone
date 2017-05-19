package com.marino.drone;

import com.google.common.collect.Lists;

import java.util.List;


/**
 * Created by
 *
 * @author marinovilchez
 * @soundtrack Quique Gonzalez - Lady Drama
 * @since 19/5/17
 */
public class Drone {

    public List<String> obtenerUrbanizaciones(final double latitud, final double longitud, final int rango) {
        List<String> idUrbanizaciones = Lists.newArrayList();
        String idOrigen = obtenerIdentificadorUrbanizacion(latitud, longitud);
        idUrbanizaciones.add(idOrigen); // incluyo el centro
        int profundidad = 1; // empezamos por 1
        do {
            for (final String urbanizacion: idUrbanizaciones)
            {
                Coordenada coordenada = obtenerCoordenadas(urbanizacion);
                idUrbanizaciones.addAll(obtenerUrbanizaciones(coordenada.getLatitud(), coordenada.getLongitud(), rangoInferior));
            }
            idUrbanizaciones.add(obtenerAdyacente(idOrigen, Mapa.Direcciones.ARRIBA));
            idUrbanizaciones.add(obtenerAdyacente(obtenerAdyacente(idOrigen, Mapa.Direcciones.ARRIBA),Mapa.Direcciones.DERECHA));
            idUrbanizaciones.add(obtenerAdyacente(obtenerAdyacente(idOrigen, Mapa.Direcciones.ARRIBA),Mapa.Direcciones.IZQUIERDA));
            idUrbanizaciones.add(obtenerAdyacente(idOrigen, Mapa.Direcciones.ABAJO));
            idUrbanizaciones.add(obtenerAdyacente(obtenerAdyacente(idOrigen, Mapa.Direcciones.ABAJO),Mapa.Direcciones.DERECHA));
            idUrbanizaciones.add(obtenerAdyacente(obtenerAdyacente(idOrigen, Mapa.Direcciones.ABAJO),Mapa.Direcciones.IZQUIERDA));
            idUrbanizaciones.add(obtenerAdyacente(idOrigen, Mapa.Direcciones.DERECHA));
            idUrbanizaciones.add(obtenerAdyacente(idOrigen, Mapa.Direcciones.IZQUIERDA));
            profundidad +=1;

        } while (profundidad == rango);

        return idUrbanizaciones;

    }

    private String obtenerAdyacente(final String idOrigen, final Mapa.Direcciones direccion) {
        String resultado = "";
        if (idOrigen.equalsIgnoreCase("id urbanizacion13")) {
            switch (direccion) {
                case ARRIBA:
                    resultado = "id urbanizacion8";
                    break;
                case ABAJO:
                    resultado = "id urbanizacion18";
                    break;
                case DERECHA:
                    resultado = "id urbanizacion14";
                    break;
                case IZQUIERDA:
                    resultado = "id urbanizacion12";
                    break;
            }
        } else if (idOrigen.equalsIgnoreCase("id urbanizacion18")) {
            switch (direccion) {
                case ARRIBA:
                    resultado = "id urbanizacion13";
                    break;
                case ABAJO:
                    resultado = "id urbanizacion23";
                    break;
                case DERECHA:
                    resultado = "id urbanizacion19";
                    break;
                case IZQUIERDA:
                    resultado = "id urbanizacion17";
                    break;
            }
        }
        return resultado;
    }

    private String obtenerIdentificadorUrbanizacion(double latitud, double longitud) {
        String resultado = "";
        if (latitud==38.56889 && longitud==40.511107)
        {
            resultado =  "id urbanizacion13";
        } else if (latitud==38.572929 && longitud==40.529393) {
            resultado =  "id urbanizacion18";
        }
        return resultado;
    }

    private Coordenada obtenerCoordenadas(final String idUrbanizacion) {
        Coordenada coordenada = new Coordenada();
        if (idUrbanizacion.equalsIgnoreCase("id urbanizacion13")) {
            coordenada.setLatitud(38.56889);
            coordenada.setLongitud(40.511107);
        } else if (idUrbanizacion.equalsIgnoreCase("id urbanizacion18")) {
            coordenada.setLatitud(38.572929);
            coordenada.setLongitud(40.529393);
        }
        return coordenada;
    }
}