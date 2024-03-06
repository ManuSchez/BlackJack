import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    ArrayList<Carta> cartas;
    //Creamos un metodo en el que mediante un doble for se va a ir ampliando las cartas
    //mientras sea igual a 1 o menor de 13
    public Mazo() {
        cartas = new ArrayList<>();
        for (Carta.palo palo : Carta.palo.values()) {
            for (int numeroCarta = 1; numeroCarta <= 13; numeroCarta++) {
                cartas.add(new Carta(numeroCarta, palo));
            }
        }
    }
    //En el caso de que el mazo este vacio retorna null
    // en caso contrario devuelve la carta solicitada del mazo
    public Carta solicitarCarta() {
        if (cartas.isEmpty()) {
            System.out.println("El mazo está vacío.");
            return null; // Retorna null cuando el mazo está vacío
        } else {
            Carta cartaSolicitada = cartas.get(0);
            cartas.remove(0);
            return cartaSolicitada;
        }
    }
    //Con el metodo collections.shuffle podemos barajar el mazo
    public void barajar() {
        Collections.shuffle(cartas);
    }
    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    //Devolvemos la representación en cadena completa del objeto Mazo
    public String toString() {
        String result = "Mazo de Cartas:\n";
        for (int i = 0; i < cartas.size(); i++) {
            result += cartas.get(i) + "\n";
        }
        return result;
    }
}