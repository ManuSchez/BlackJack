import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Juego {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dime tu nombre:");
        String nombre = scanner.nextLine();

        Mano manoJugador = new Mano(); // Creamos la mano del jugador

        List<Resultado> resultados = new ArrayList<>(); // Lista para guardar los resultados

        Mazo mazo = new Mazo();
        mazo.barajar();

        boolean finJuego = false;
        //Con un while vamos recorriendo los casos en los que se pida mas cartas
        //o en el caso de plantarse mostrando mientras la mano del jugador y finalmente
        //acabando el juego
        while (!finJuego) {
            System.out.println("¿Quieres otra carta? (s/n)");
            String respuesta = scanner.nextLine();

            if (respuesta.equals("s")) {
                Carta carta = mazo.solicitarCarta();
                if (carta == null) {
                    finJuego = true;
                    System.out.println("No quedan más cartas en el mazo, te has plantado con " + manoJugador.valorMano() + " puntos");
                } else {
                    manoJugador.pedirCarta(mazo);
                    System.out.println("Tu mano: " + manoJugador);

                    if (manoJugador.finDeJuego()) {
                        System.out.println("¡Has perdido!");
                        finJuego = true;
                    }
                }
            } else if (respuesta.equals("n")) {
                System.out.println("Te has plantado con " + manoJugador.valorMano() + " puntos");
                finJuego = true;
                Resultado resultado = new Resultado(nombre, manoJugador.valorMano());
                resultados.add(resultado); // Agregamos el resultado a la lista
            } else {
                System.out.println("Introduce una de las opciones solicitadas: ");
            }
        }

        // Guardamos los resultados
        for (Resultado resultado : resultados) {
            guardarResultado(resultado);
        }
    }

    private static void guardarResultado(Resultado resultado) {
        //Mediante trycatch introducimos la ruta de donde se encuentra el archivo xml en el que se
        //van a introducir los datos, en el caso contrario genera un xml nuevo con el nombre salida.xml
        try {
            File archivoXML = new File("/Users/ManuelSchez/Desktop/Trabajo/salida.xml");
            Resultados resultadosExistentes;

            if (archivoXML.exists()) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Resultados.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                resultadosExistentes = (Resultados) unmarshaller.unmarshal(archivoXML);
            } else {
                resultadosExistentes = new Resultados();
            }

            resultadosExistentes.getListaResultados().add(resultado);

            JAXBContext jaxbContext = JAXBContext.newInstance(Resultados.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(resultadosExistentes, archivoXML);

            System.out.println("Archivo XML generado exitosamente.");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

