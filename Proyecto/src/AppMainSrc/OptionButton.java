package AppMainSrc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OptionButton extends JPanel {

    private JLabel text = new JLabel();

    private RoundBorder border;

    private RoundPanel selected;

    private boolean clicked = false;

    private OptionButton[] obs;

    public OptionButton(OptionButton[] obs){
        setSize(500,50);
        setBackground(new Color(46,46,46));
        setLayout(null);
        this.obs = obs;
        border = new RoundBorder(50,50,15,15,3);
        border.setLocation(0, 0);
        border.setBackground(new Color(0, 188, 255));
        selected = new RoundPanel(14);
        selected.setBackground(new Color(46, 46, 46));
        selected.setTam(26,26);
        selected.setLocation(12,12);
        text.setBounds(55, 0, 460, 50);
        text.setHorizontalAlignment(JLabel.LEFT);
        text.setVerticalAlignment(JLabel.CENTER);
        text.setFont(new Font("Arial",text.getFont().getStyle(),18));
        text.setForeground(Color.WHITE);
        accionMouse();
        add(selected);
        add(border);
        add(text);
        setOpaque(false);
        setVisible(true);
    }

    public void accionMouse(){
        MouseListener m = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (OptionButton c : obs) {
                    if (c.isClicked()) {
                        c.setClicked(false);
                        c.getSelected().setBackground(new Color(46, 46, 46));
                    }
                    setClicked(true);
                    getSelected().setBackground(new Color(0, 188, 255));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        addMouseListener(m);
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
        selected.setVisible(clicked);
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setObs(OptionButton[] obs) {
        this.obs = obs;
    }

    public OptionButton[] getObs() {
        return obs;
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public String getText() {
        return text.getText();
    }

    public void setBorde(RoundBorder border) {
        this.border = border;
    }

    public RoundBorder getBorde() {
        return border;
    }

    public void setSelected(RoundPanel selected) {
        this.selected = selected;
    }

    public RoundPanel getSelected() {
        return selected;
    }
}
