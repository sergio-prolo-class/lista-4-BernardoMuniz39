package ifsc.poo;
import java.awt.Color;

import ifsc.poo.figuras.FiguraGeometrica;

public abstract class ObjetoDeDesenho implements FiguraGeometrica {
    private double x, y;
    private Color cor;
    private boolean preenchido;

    public ObjetoDeDesenho(double x, double y, Color cor, boolean preenchido){
        this.x = Math.floor(x);
        this.y = Math.floor(y);
        this.cor = cor;
        this.preenchido = preenchido;
       
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public abstract void desenhar(Canvas canvas);

    public Color getCor(){
        return cor;
    }

    public boolean ehPreenchido(){
        return preenchido;
    }

    public void seMover(double x, double y){
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }

}
