package ifsc.poo.figuras;
import ifsc.poo.Canvas;
import ifsc.poo.ObjetoDeDesenho;
import java.awt.Color;

public class Circulo extends ObjetoDeDesenho{
    private double raio;
    private boolean preenchido;
    private Color cor;

    public Circulo(double raio, double x, double y, Color cor, boolean preenchido){
        super(x, y, cor);
        this.raio = raio;
        this.preenchido = preenchido;
    } 
    
    @Override
    public void desenhar(Canvas canva){
        if(preenchido){
            canva.draw.setPenColor();
            canva.draw.setPenColor(Color.BLACK);
            canva.draw.filledCircle(getX(), getY(), raio);
            canva.draw.setPenColor(cor);
            canva.draw.filledCircle(getX(), getY(), raio * 0.95);
        }else{
            canva.draw.circle(getX(), getY(), raio);
        }
    }
}

