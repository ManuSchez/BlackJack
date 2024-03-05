import java.util.ArrayList;
//Creamos la clase Mano como subclase de mazo
public class Mano extends Mazo {

    public Mano() {
        super();
        cartas = new ArrayList<Carta>();
    }
    public int valorMano() {
        int total = 0;
        for (Carta carta : cartas) {
            total += carta.getValor();
        }
        return total;
    }
    //Cuando la puntuacion de la mano es superior a 21 finaliza el juego
    public boolean finDeJuego() {
        return valorMano() > 21;
    }
    //Imprimimos la puntuacion con toString
    @Override
    public String toString() {
        return "Puntuación: " + valorMano() + "\n" + super.toString();
    }
    //Creamos un metodo en el caso de que el usuario solicite una carta se añada la carta al mazo
    public void pedirCarta(Mazo mazo) {
        cartas.add(mazo.solicitarCarta());
    }
}