package ifsc.poo;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.DrawListener;
import ifsc.poo.figuras.Circulo;
import edu.princeton.cs.algs4.Draw;


public class Desenhista implements DrawListener{

    private Canvas canva;
    private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA};

    private int tamanhoinicial = 50, indexCor = 0;
    private String tipoDeFigura;

    
    private List<ObjetoDeDesenho> figuras = new LinkedList<>();
    private boolean preenchido = true;

    public Desenhista(Canvas c){
        this.canva = c;
        c.desenharTela();
    }
    

     public void mousePressed(double x, double y) {
        ObjetoDeDesenho figura = null;

        switch(tipoDeFigura){
            case "CIRCULO": 
                figura = new Circulo(tamanhoinicial, x, y, colors[indexCor], preenchido);
            case "QUADRADO": 
                //figura = new Circulo(tamanhoinicial, x, y, colors[indexCor]);
            case "HEXÁGONO": 
                //figura = new Circulo(tamanhoinicial, x, y, colors[indexCor]);
            case "PENTÁGONO": 
                //figura = new Circulo(tamanhoinicial, x, y, colors[indexCor]);
        
            }

            if(figura != null){
                figuras.add(figura);
                figura.desenhar(canva);
            }
    }

    //F1 - CÍRCULO - 0x70
    //F2 - QUADRADO - 0x71 
    //F3 - HEXAGONO - 0x72
    //F4 - PENTAGONO - 0x73
    public void keyPressed(int tecla){
        switch(tecla){
            case 0x70: 
                System.out.println("Figura: Círculo");
                tipoDeFigura = "CIRCULO";
                break;
            case 0x71:
                System.out.println("Figura: Quadrado");
                tipoDeFigura = "QUADRADO";
                break;
            case 0x72:
                System.out.println("Figura: Hexágono");
                tipoDeFigura = "HEXÁGONO";
                break;
            case 0x73:
                System.out.println("Figura: Pentágono");
                tipoDeFigura = "PENTÁGONO";
                break;
        }
    }


}
