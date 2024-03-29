package PhysicsSrc.Game;
//mapa del juego
//fase de prueba

import javax.swing.*;
import javax.vecmath.Vector2f;

public class Map extends JPanel{
    public Tile[][] tiles;

    public Map() {
        setSize(1074, 800);
        setLayout(null);
        tiles = new Tile[8][11];
        setOpaque(false);
        initTiles();
        setVisible(true);
    }

    public void initTiles(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 11; j++) {
                tiles[i][j] = new Tile();
                tiles[i][j].setLocation(j*96, i*96);
                tiles[i][j].setHitbox(new Collider(
                        new Vector2f(tiles[i][j].getX(), tiles[i][j].getY()),
                        tiles[i][j].getWidth(), tiles[i][j].getHeight(), false));
                add(tiles[i][j]);
            }
        }
    }
}
