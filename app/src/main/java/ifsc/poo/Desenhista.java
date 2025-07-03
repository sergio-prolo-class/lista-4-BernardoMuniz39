package ifsc.poo;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.DrawListener;
import ifsc.poo.figuras.Circulo;
import ifsc.poo.figuras.Hexagono;
import ifsc.poo.figuras.Pentagono;
import ifsc.poo.figuras.Quadrado;
import static ifsc.poo.Constantes.*;


public class Desenhista implements DrawListener{

    private Canvas canva;
    private String tipoDeFigura;
    private int tamanhoInicial = 50, indexCor = 0;
    
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
                figura = new Circulo(tamanhoInicial, x, y, CORES_FIGURAS[indexCor], preenchido); 
                break;
            case "QUADRADO": 
                figura = new Quadrado(tamanhoInicial, x, y, CORES_FIGURAS[indexCor], preenchido);
                break;
            case "HEXÁGONO": 
                figura = new Hexagono(tamanhoInicial, x, y, CORES_FIGURAS[indexCor], preenchido);
                break;
            case "PENTÁGONO": 
                figura = new Pentagono(tamanhoInicial, x, y, CORES_FIGURAS[indexCor], preenchido);
                break;
        }
        if(figura != null){
            figuras.add(figura);
            figura.desenhar(canva);
        }
    }

    public void keyPressed(int tecla){
        switch(tecla){
            case F1_KEY: //F1
                System.out.println("Figura: Círculo");
                tipoDeFigura = "CIRCULO";
                break;
            case F2_KEY: //F2
                System.out.println("Figura: Quadrado");
                tipoDeFigura = "QUADRADO";
                break;
            case F3_KEY: //F3
                System.out.println("Figura: Hexágono");
                tipoDeFigura = "HEXÁGONO";
                break;
            case F4_KEY: //F4
                System.out.println("Figura: Pentágono");
                tipoDeFigura = "PENTÁGONO";
                break;
            case F5_KEY: //F5
                indexCor = 0;
                System.out.println("Cor: Preto");
                break;
            case F6_KEY: //F6
                indexCor = 1;
                System.out.println("Cor: Vermelho");
                break;
            case F7_KEY: //F7
                indexCor = 2;
                System.out.println("Cor: Azul");
                break;
            case F8_KEY: //F8
                indexCor = 3;
                System.out.println("Cor: Verde");
                break;
            case F_KEY: //F
                preenchido = !preenchido;

                if(preenchido){
                    System.out.println("Com preenchimento");
                }else{
                    System.out.println("Sem preenchimento");
                }
                break;
            case Q_KEY: //Q - AUMENTA A FIGURA DE TAMANHO
                if(tamanhoInicial < TAMANHO_MAX){
                    tamanhoInicial += 10;
                    System.out.println("Tamanho: " + tamanhoInicial);
                }
                break;
            case W_KEY: //W - DIMINUI A FIGURA DE TAMANHO
                if(tamanhoInicial > TAMANHO_MIN){
                    tamanhoInicial -= 10;
                    System.out.println("Tamanho: " + tamanhoInicial);
                }
                break;
            case C_KEY: //C - LIMPA A TELA
                figuras.clear();
                canva.limparTela();
                break;
            case P_KEY: //P - VER ESTATÍSTICAS
                System.out.println(e.verEstatisticas(figuras));
                break;
            case UP_KEY: //UP - SETA PARA CIMA
                moverFiguras(0,20);
                break;
            case DOWN_KEY: //DOWN - SETA PARA BAIXO
                moverFiguras(0,-20);
                break;
            case LEFT_KEY: //LEFT - SETA PARA A ESQUERDA
                moverFiguras(-20,0);
                break;
            case RIGHT_KEY: //RIGHT - SETA PARA A DIREITA
                moverFiguras(20,0);
                break;
            default:
                System.out.println("Tecla inválida!");
        }
    }

    public void moverFiguras(double x, double y){
        for( ObjetoDeDesenho figura: figuras){
           figura.seMover(x, y);
        }
        canva.limparTela();
        for( ObjetoDeDesenho figura: figuras){
            figura.desenhar(canva);
        }
    }


}
