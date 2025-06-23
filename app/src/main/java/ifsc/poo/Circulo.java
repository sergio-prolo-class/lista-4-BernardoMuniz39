package ifsc.poo;
import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

public class Circulo {
    private double x;
    private double y;


    public Circulo(double x, double y) {
        this.x = Math.floor(x);
        this.y = Math.floor(y);
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = Math.floor(x);
    }

    public void setY(double y) {
        this.y = Math.floor(y);
    }

    public void desenhar(Draw desenho){
        //Color cor = (selecionado) ? Color.RED : Color.BLUE;
       // desenho.setPenColor(cor);
        desenho.filledCircle(x + 0.5, y + 0.5, .375);
    }

}
