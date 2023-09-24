package PhysicsSrc;

import java.awt.Color;
import javax.swing.*;

public class Map extends JPanel{
    
    public int x = 0;
    
    public int y = 0;
    
    public int w = 0;
    
    public int h = 0;
    
    public JPanel[][] tiles;

    public Map() {
        setSize(1074, 800);
        setLayout(null);
        w = getWidth();
        h = getHeight();
        tiles = new JPanel[10][8];
        initTiles();
        setVisible(true);
    }
    
    public void initTiles(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                tiles[i][j] = new JPanel();
                tiles[i][j].setBounds(i*100, j*100,100,100);
                tiles[i][j].setBackground(Color.DARK_GRAY);
                add(tiles[i][j]);
            }            
        }
    }
    
}
