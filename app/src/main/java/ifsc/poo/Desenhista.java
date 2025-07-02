package ifsc.poo;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.DrawListener;
import ifsc.poo.figuras.Circulo;
import ifsc.poo.figuras.Hexagono;
import ifsc.poo.figuras.Pentagono;
import ifsc.poo.figuras.Quadrado;


public class Desenhista implements DrawListener{

    private Canvas canva;
    private Color[] colors = {Color.BLACK,  Color.RED, Color.BLUE, Color.GREEN,};

    private int tamanhoinicial = 50, indexCor = 0, tamanhoMin = 10, tamanhoMax = 300;
    private String tipoDeFigura;

    
    private List<ObjetoDeDesenho> figuras = new LinkedList<>();
    private boolean preenchido = false;
    private Estatistica e = new Estatistica();

    public Desenhista(Canvas c){
        this.canva = c;
        c.desenharTela();
        c.draw.addListener(this);
    }
    
    //Aqui eu utilizei polimorfismo, pois o mesmo objeto de desenho pode ser diferentes tipos de figuras geométricas
    public void mousePressed(double x, double y) {

        if(tipoDeFigura == null){
            System.out.println("Tipo de figura inválido! Por favor, selecione uma figura.");
            return;
        }

        ObjetoDeDesenho figura = null;

        switch(tipoDeFigura){
            case "CIRCULO": 
                figura = new Circulo(tamanhoinicial, x, y, colors[indexCor], preenchido); 
                break;
            case "QUADRADO": 
                figura = new Quadrado(tamanhoinicial, x, y, colors[indexCor], preenchido);
                break;
            case "HEXÁGONO": 
                figura = new Hexagono(tamanhoinicial, x, y, colors[indexCor], preenchido);
                break;
            case "PENTÁGONO": 
                figura = new Pentagono(tamanhoinicial, x, y, colors[indexCor], preenchido);
                break;
        }
        if(figura != null){
            figuras.add(figura);
            figura.desenhar(canva);
        }
    }

    public void keyPressed(int tecla){
        switch(tecla){
            case 112: //F1
                System.out.println("Figura: Círculo");
                tipoDeFigura = "CIRCULO";
                break;
            case 113: //F2
                System.out.println("Figura: Quadrado");
                tipoDeFigura = "QUADRADO";
                break;
            case 114: //F3
                System.out.println("Figura: Hexágono");
                tipoDeFigura = "HEXÁGONO";
                break;
            case 115: //F4
                System.out.println("Figura: Pentágono");
                tipoDeFigura = "PENTÁGONO";
                break;
            case 116: //F5
                indexCor = 0;
                System.out.println("Cor: Preto");
                break;
            case 117: //F6
                indexCor = 1;
                System.out.println("Cor: Vermelho");
                break;
            case 118: //F7
                indexCor = 2;
                System.out.println("Cor: Azul");
                break;
            case 119: //F8
                indexCor = 3;
                System.out.println("Cor: Verde");
                break;
            case 70: //F
                preenchido = !preenchido;

                if(preenchido){
                    System.out.println("Com preenchimento");
                }else{
                    System.out.println("Sem preenchimento");
                }
                break;
            case 81: //Q - AUMENTA A FIGURA DE TAMANHO
                if(tamanhoinicial < tamanhoMax){
                    tamanhoinicial += 10;
                    System.out.println("Tamanho: " + tamanhoinicial);
                }
                break;
            case 87: //W - DIMINUI A FIGURA DE TAMANHO
                if(tamanhoinicial > tamanhoMin){
                    tamanhoinicial -= 10;
                    System.out.println("Tamanho: " + tamanhoinicial);
                }
                break;
            case 67: //C - LIMPA A TELA
                figuras.clear();
                canva.limparTela();
                break;
            case 80: //P - VER ESTATÍSTICAS
                System.out.println(e.verEstatisticas(figuras));
                break;
            case 38: //UP - SETA PARA CIMA
                mover(0,20);
                break;
            case 40: //DOWN - SETA PARA BAIXO
                mover(0,-20);
                break;
            case 37: //LEFT - SETA PARA A ESQUERDA
                mover(-20,0);
                break;
            case 39: //RIGHT - SETA PARA A DIREITA
                mover(20,0);
                break;
            default:
                System.out.println("Tecla inválida!");
        }
    }

    public void mover(double x, double y){
        for( ObjetoDeDesenho figura: figuras){
            figura.setX(figura.getX() + x);
            figura.setY(figura.getY() + y);
        }
        canva.limparTela();
        for( ObjetoDeDesenho figura: figuras){
            figura.desenhar(canva);
        }
    }


}
