package AppMainSrc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author david
 */
public class RoundComboBox extends JPanel {

    private ArrayList<Item> items = new ArrayList<>();
    
    private RoundBorder borde;

    private boolean expanded = false;
    
    private boolean painted = false;

    private JLabel icon = new JLabel(new ImageIcon("src/images/RaphaelArrowdown.png"), JLabel.CENTER);

    private int arc = 20;

    public RoundComboBox() {
        setSize(200, 50);
        setBackground(Color.WHITE);
        setLayout(null);
        borde = new RoundBorder(207, 57, arc, arc, 2);
        borde.setLocation(-4, -3);
        borde.setBackground(Color.black);
        items.add(new Item( "", this));
        items.get(0).setFocusable(true);
        items.get(0).add(icon);
        icon.setBounds(getWidth() - 50, 0, 50, 50);
        items.get(0).setLocation(0, 0);
        add(borde);
        add(items.get(0));
        setVisible(true);
    }

    private class Item extends JPanel {

        private int w, h, arc;

        private boolean last = false;

        private RoundComboBox r;

        private String dato = "";

        private Color color;
        
        private JLabel text = new JLabel("");

        public Item(String dato, RoundComboBox r) {
            this.w = r.getWidth();
            this.h = r.getHeight();
            this.arc = r.arc;
            this.dato = dato;
            this.r = r;
            setSize(w, h);
            setLayout(null);
            text.setBounds(0, 0, getWidth(), getHeight());
            text.setText(dato);
            text.setHorizontalAlignment(JLabel.CENTER);
            text.setForeground(Color.black);
            setBackground(r.getBackground());
            color = getBackground();
            add(text);
            setOpaque(false);
            accionMouse();
            setVisible(true);
        }

        public void accionMouse() {

            MouseListener m = new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (r.isExpanded()) {
                        r.items.get(0).setDato(dato);
                        r.contractBox();
                    } else {
                        expandBox();
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    int r, g, b;
                    if (getBackground().getRed() > 14) {
                        r = getBackground().getRed() - 15;
                    } else {
                        r = getBackground().getRed();
                    }

                    if (getBackground().getGreen() > 14) {
                        g = getBackground().getGreen() - 15;
                    } else {
                        g = getBackground().getGreen();
                    }

                    if (getBackground().getBlue() > 14) {
                        b = getBackground().getBlue() - 15;
                    } else {
                        b = getBackground().getBlue();
                    }

                    setBackground(new Color(r, g, b));
                }

                @Override
                public void mouseReleased(MouseEvent e) {

                    int r, g, b;
                    if (getBackground() != color) {

                        if (getBackground().getRed() < 241) {
                            r = getBackground().getRed() + 15;
                        } else {
                            r = getBackground().getRed();
                        }

                        if (getBackground().getGreen() < 241) {
                            g = getBackground().getGreen() + 15;
                        } else {
                            g = getBackground().getGreen();
                        }

                        if (getBackground().getBlue() < 241) {
                            b = getBackground().getBlue() + 15;
                        } else {
                            b = getBackground().getBlue();
                        }

                        setBackground(new Color(r, g, b));
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                    int r, g, b;
                    if (color.getRed() > 14) {
                        r = color.getRed() - 15;
                    } else {
                        r = color.getRed();
                    }

                    if (color.getGreen() > 14) {
                        g = color.getGreen() - 15;
                    } else {
                        g = color.getGreen();
                    }

                    if (color.getBlue() > 14) {
                        b = color.getBlue() - 15;
                    } else {
                        b = color.getBlue();
                    }

                    setBackground(new Color(r, g, b));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(color);
                }
            };
            addMouseListener(m);
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(getBackground());
            if (this.equals(r.items.get(0))) {
                g2d.fillRoundRect(1, 1, w - 2, h - 2, arc, arc);
            } else if (last) {
                g2d.fillRoundRect(1, -2, w-2, h-1, arc, arc);
            } else {
                g2d.fillRect(0, 0, w , h);
            }
            super.paint(g);
        }

        public void setDato(String dato) {
            this.dato = dato;
            text.setText(dato);
        }

        public RoundComboBox getR() {
            return r;
        }
        
        
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(String text) {
        if (items.size() == 1) {
            items.get(0).setDato(text);
        }
        Item i = new Item(text, this);
        i.last = true;
        for (Item item : items) {
            item.last = false;
        }
        items.add(i);
        int aux = items.indexOf(i);
        items.get(aux).setLocation(0, aux * 50);
        items.get(aux).setVisible(false);
        items.get(aux).setFocusable(true);
        add(items.get(aux));
    }

    private void contractBox() {
        for (Item item : items) {
            item.setVisible(false);
        }
        items.get(0).setVisible(true);
        setSize(getWidth(), 50);
        borde.setH(57);
        expanded = false;
    }

    private void expandBox() {
        for (Item item : items) {
            item.setVisible(true);
        }
        Thread run = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 50; i <= 50 * items.size(); i+=7) {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    setSize(getWidth(), i);
                    borde.setH(i+7);
                }
            }
        });
        run.start();
        expanded = true;
    }

    public boolean isPainted() {
        return painted;
    }

    public void setPainted(boolean painted) {
        this.painted = painted;
    }

    public boolean isExpanded() {
        return expanded;
    }
}
