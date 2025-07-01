package ifsc.poo;
import java.awt.Color;

public abstract class ObjetoDeDesenho {
    private double x, y;
    private Color cor;

    public ObjetoDeDesenho(double x, double y, Color cor){
        this.x = Math.floor(x);
        this.y = Math.floor(y);
        this.cor = cor;
       
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public abstract void desenhar(Canvas canvas);

}
