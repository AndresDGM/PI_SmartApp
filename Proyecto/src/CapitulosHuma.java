/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USUARIO
 */
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author suare
 */
public class CapitulosHuma extends JPanel{
    
    private String[] texts = {"<div align = 'center'><font face='Times New Roman'size='4'>Educacion de calidad #4 1</font></div><br>" +
        "<strong>",
                                    "<div align = 'center'><font face='Times New Roman'size='4'>Educacion de calidad #4 2</font></div><br>" +
        "<strong>",
                                    "<div align = 'center'><font face='Times New Roman'size='4'>Educacion de calidad #4 3</font></div><br>" +
        "<strong>",
                                    "<div align = 'center'><font face='Times New Roman'size='4'>Educacion de calidad #4 4</font></div><br>" +
        "<strong>",
                                    "<div align = 'center'><font face='Times New Roman'size='4'>Educacion de calidad #4 5</font></div><br>" +
        "<strong>",
                                    "<div align = 'center'><font face='Times New Roman'size='4'>Educacion de calidad #4 6</font></div><br>" +
        "<strong>",
                                    "<div align = 'center'><font face='Times New Roman'size='4'>Educacion de calidad #4 7</font></div><br>" +
        "<strong>",
                                    "<div align = 'center'><font face='Times New Roman'size='4'>Educacion de calidad #4 8</font></div><br>" +
        "<strong>",
                                    "<div align = 'center'><font face='Times New Roman'size='4'>Educacion de calidad #4 9</font></div><br>" +
        "<strong>",
                                    "<div align = 'center'><font face='Times New Roman'size='4'>Educacion de calidad #4 10</font></div><br>" +
        "<strong>"};

    private JScrollPane[] Capitulos = new JScrollPane[10];
    
    private JLabel titulo = new JLabel();
    
    private BasicButton botonSiguiente, botonAnterior;
    
    int capCont = 0;

    public CapitulosHuma() {
        setSize(1074, 800);
        setLayout(null);
        titulo.setBounds(457, 30, 160, 50);
        InitCaps();
        botonSiguiente = new BasicButton(){
            @Override
            public void clickEvent() {
                Capitulos[capCont].setVisible(false);
                if(capCont < 9){
                    Capitulos[capCont+1].setVisible(true);
                    capCont++;
                }else{
                    Capitulos[0].setVisible(true);
                    capCont = 0;
                }
            }
        };
        botonSiguiente.setLocation(50, 680);
        botonSiguiente.setText("Siguiente");
        add(botonSiguiente);
        
        botonAnterior = new BasicButton() {
            @Override
            public void clickEvent() {
                Capitulos[capCont].setVisible(false);
                if(capCont > 0){
                    Capitulos[capCont-1].setVisible(true);
                    capCont--;
                }else{
                    Capitulos[9].setVisible(true);
                    capCont = 9;
                }
            }
        };
        botonAnterior.setLocation(750, 680);
        botonAnterior.setText("Anterior");
        add(botonAnterior);
        setVisible(false);
    }
    
    public void InitCaps(){
        for (int i = 0; i < Capitulos.length; i++) {
            JEditorPane j = new JEditorPane();
            j.setBounds(187, 100, 700, 700);
            j.setContentType("text/html");
            j.setText(texts[i]);
            j.setEditable(false);
            Capitulos[i] = new JScrollPane(j);
            Capitulos[i].setBounds(100, 50, 700, 700);
            Capitulos[i].setVisible(false);
            add(Capitulos[i]);
        }
    }

    public JScrollPane[] getCapitulos() {
        return Capitulos;
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public int getCapCont() {
        return capCont;
    }

    public void setCapCont(int capCont) {
        this.capCont = capCont;
    }
    
    
}
