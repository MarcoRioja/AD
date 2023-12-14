package org.SQL.MVC;
import java.util.List;

public class GameView {
    // Método para mostrar los clientes en la vista
    public void mostrarGames(List<Game> clientes) {
        for (Game game : clientes) {
            System.out.println(game.toString());
        }
    }
}
