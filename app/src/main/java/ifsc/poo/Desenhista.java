package ifsc.poo;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.DrawListener;
import ifsc.poo.figuras.Circulo;


public class Desenhista implements DrawListener{

    private Canvas canva;
    private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

    private int tamanhoinicial = 30, indexCor = 0, tamanhoMin = 10, tamanhoMax = 200;
    private String tipoDeFigura;

    
    private List<ObjetoDeDesenho> figuras = new LinkedList<>();
    private boolean preenchido = true;

    public Desenhista(Canvas c){
        this.canva = c;
        c.desenharTela();
        c.draw.addListener(this);
    }
    

     public void mousePressed(double x, double y) {
        ObjetoDeDesenho figura = null;

        switch(tipoDeFigura){
            case "CIRCULO": 
                figura = new Circulo(tamanhoinicial, x, y, colors[indexCor], preenchido);
                break;
            case "QUADRADO": 
                //figura = new Circulo(tamanhoinicial, x, y, colors[indexCor]);
                break;
            case "HEXÁGONO": 
                //figura = new Circulo(tamanhoinicial, x, y, colors[indexCor]);
                break;
            case "PENTÁGONO": 
                //figura = new Circulo(tamanhoinicial, x, y, colors[indexCor]);
                break;
        
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
    //Q - 81
    //W - 87
    //C - 67


    /*  Seleção de cor: Usando as teclas F5-F8, o usuário pode selecionar qual cor será usada para
        imprimir a figura. Você deve disponibilizar quatro cores, uma para cada tecla. Escolha cores de alto
        contraste com o fundo da tela.

        Seleção de modo: Usando a tecla ‘F’, o usuário pode alternar entre impressão vazada ou preenchida.
        Caso vazada, a cor da borda deve ser a cor selecionada pelo usuário. Caso preenchida, a cor da
        borda deve ser preta. */

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
                System.out.println("Cor: Vermelho");
                break;
            case 117: //F6
                indexCor = 1;
                System.out.println("Cor: Verde");
                break;
            case 118: //F7
                indexCor = 2;
                System.out.println("Cor: Azul");
                break;
            case 119: //F8
                indexCor = 3;
                System.out.println("Cor: Amarelo");
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
            case 87:
                if(tamanhoinicial > tamanhoMin){
                    tamanhoinicial -= 10;
                    System.out.println("Tamanho: " + tamanhoinicial);
                }
                break;
            case 67:
                figuras.clear();
                canva.limparTela();
                break;
        }
    }


}
