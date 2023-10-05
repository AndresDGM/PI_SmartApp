package PhysicsSrc.Game;

import javax.swing.*;

public class Map extends JPanel{
    public Tile[][] tiles;

    public Map() {
        setSize(1074, 800);
        setLayout(null);
        tiles = new Tile[8][10];
        setOpaque(false);
        initTiles();
        setVisible(true);
    }
    
    public void initTiles(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                tiles[i][j] = new Tile();
                tiles[i][j].setLocation(j*64, i*64);
                add(tiles[i][j]);
            }            
        }
    }
}
