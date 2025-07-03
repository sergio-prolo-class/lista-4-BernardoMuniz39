package ifsc.poo;
import java.awt.Color;

import ifsc.poo.figuras.FiguraGeometrica;

public abstract class ObjetoDeDesenho implements FiguraGeometrica {
    private Ponto ponto;
    private Color cor;
    private boolean preenchido;

    public ObjetoDeDesenho(Ponto ponto, Color cor, boolean preenchido){
        this.ponto = new Ponto(Math.floor(ponto.getX()),  Math.floor(ponto.getY()));
        this.cor = cor;
        this.preenchido = preenchido;
       
    }

    public abstract void desenhar(Canvas canvas);

    public Color getCor(){
        return cor;
    }

    public boolean ehPreenchido(){
        return preenchido;
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void seMover(double x, double y){
        ponto.setX(this.ponto.getX() + x);
        ponto.setY(ponto.getY() + y);
    }

}
