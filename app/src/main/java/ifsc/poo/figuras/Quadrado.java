package ifsc.poo.figuras;
import java.awt.Color;

import ifsc.poo.Canvas;
import ifsc.poo.ObjetoDeDesenho;

public class Quadrado extends ObjetoDeDesenho {
    private double lado;

    public Quadrado(double lado, double x, double y, Color cor, boolean preenchido){
        super(x, y, cor, preenchido);
        this.lado = lado;
    }

    @Override
    public void desenhar(Canvas canva){
        if(this.ehPreenchido()){
            canva.draw.setPenColor(Color.BLACK);
            canva.draw.filledSquare(getX(), getY(), lado);
            canva.draw.setPenColor(this.getCor());
            canva.draw.filledSquare(getX(), getY(), lado * 0.90);
        }else{
            canva.draw.setPenColor(this.getCor());
            canva.draw.square(getX(), getY(), lado);
        }
        canva.draw.show();
    }

}
