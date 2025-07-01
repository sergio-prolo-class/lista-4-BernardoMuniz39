package ifsc.poo;
import java.awt.Color;

public abstract class ObjetoDeDesenho {
    private double x, y;
    private Color cor;
    private boolean preenchido;

    public ObjetoDeDesenho(double x, double y, Color cor, boolean preenchido){
        this.x = Math.floor(x);
        this.y = Math.floor(y);
        this.cor = cor;
        this.preenchido = preenchido;
       
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

}
