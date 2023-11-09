package PhysicsSrc.Game;

import AppMainSrc.App;
import AppMainSrc.BasicButton;
import AppMainSrc.RoundPanel;

import javax.swing.*;
import java.awt.*;

public class GameMenu extends RoundPanel {

    private JLabel titulo = new JLabel("Menu");

    private JLabel score = new JLabel("Score:");

    private Game game;

    private GameSeccion gs;

    BasicButton[] botones = new BasicButton[4];

    public GameMenu(Game game) {
        super(30);
        this.game = game;
        setTam(200,240);
        setBackground(new Color(46,46,46));
        setLayout(null);
        initComps();
        setLocation(437, 280);
        setOpaque(false);
        setVisible(false);
    }

    public void initComps(){
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        titulo.setBounds( 0,0,200,50);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setForeground(Color.white);
        add(titulo);

        score.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        score.setBounds( 25,60,150,40);
        score.setHorizontalAlignment(JLabel.CENTER);
        score.setForeground(Color.white);
        add(score);
        score.setVisible(false);


        botones[0] = new BasicButton(150,40,"Reanudar") {
            @Override
            public void clickEvent() {
                reanudarGame();
            }
        };
        botones[0].setColor(new Color(18, 227, 46));
        botones[0].setLocation(25,60);
        botones[0].getText().setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        botones[0].getText().setVerticalAlignment(JLabel.CENTER);
        add(botones[0]);

        botones[1] = new BasicButton(150,40,"Reintentar") {
            @Override
            public void clickEvent() {
                GameMenu.this.setVisible(false);
                GameMenu.this.game.setDefault();
                GameMenu.this.game.setGamePause(false);
                GameMenu.this.botones[3].setVisible(true);
            }
        };
        botones[1].setColor(new Color(18, 227, 46));
        botones[1].setLocation(25,120);
        botones[1].getText().setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        botones[1].getText().setVerticalAlignment(JLabel.CENTER);
        add(botones[1]);

        botones[2] = new BasicButton(150,40,"Salir") {
            @Override
            public void clickEvent() {
                endGame();
            }
        };
        botones[2].setColor(new Color(18, 227, 46));
        botones[2].setLocation(25,180);
        botones[2].getText().setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        botones[2].getText().setVerticalAlignment(JLabel.CENTER);
        add(botones[2]);
        
        botones[3] = new BasicButton(50,50,"||") {
            @Override
            public void clickEvent() {
                pauseGame();
                setVisible(false);
            }
        };
        botones[3].setColor(new Color(84,84,84));
        botones[3].setLocation(0,0);
        botones[3].getText().setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        botones[3].getText().setVerticalAlignment(JLabel.CENTER);
        App.lateralBar.add(botones[3]);
    }

    public void gameOverMode(){
        setVisible(true);
        game.setGamePause(true);
        titulo.setText("Game Over");
        botones[0].setVisible(false);
        score.setText("Score: " + game.getJugador().getScore());
        score.setVisible(true);
    }

    public void winMode(){
        setVisible(true);
        game.setGamePause(true);
        titulo.setText("Ganaste!!!");
        botones[0].setVisible(false);
        botones[1].setText("Volver a Jugar");
        botones[1].getText().setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        score.setText("Score: " + game.getJugador().getScore());
        score.setVisible(true);
    }

    public void pauseGame(){
        setVisible(true);
        game.setGamePause(true);
        titulo.setText("Pausa");
        botones[0].setVisible(true);
        score.setVisible(false);
    }

    public void endGame(){
        App.lateralBar.getComponent(0).setVisible(true);
        App.lateralBar.getComponent(1).setVisible(true);
        App.lateralBar.remove(botones[3]);
        game.setVisible(false);
        game.setGameRun(false);
        gs.getApp().remove(game);
        gs.getApp().removeKeyListener(game.getTeclas());
        gs.setVisible(true);
    }
    
     public void pricipalMenuMode(){
        setVisible(true);
        game.setGamePause(true);
        titulo.setText("Menu");
        botones[0].setVisible(true);
        botones[0].setText("Jugar");
        botones[1].setVisible(false);
        score.setVisible(false);
    }

    public void reanudarGame(){
        GameMenu.this.setVisible(false);
        GameMenu.this.game.setGamePause(false);
        botones[3].setVisible(true);
    }

    public void setGs(GameSeccion gs) {
        this.gs = gs;
    }
}
