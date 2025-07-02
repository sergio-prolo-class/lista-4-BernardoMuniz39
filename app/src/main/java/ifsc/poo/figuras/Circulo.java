package ifsc.poo.figuras;
import ifsc.poo.Canvas;
import ifsc.poo.ObjetoDeDesenho;
import java.awt.Color;

public class Circulo extends ObjetoDeDesenho{
    private double raio;
    
    public Circulo(double raio, double x, double y, Color cor, boolean preenchido){
        super(x, y, cor, preenchido);
        this.raio = raio;
    } 
    
    @Override
    public void desenhar(Canvas canva){
        if(this.ehPreenchido()){
            canva.draw.setPenColor(Color.BLACK);
            canva.draw.filledCircle(getX(), getY(), raio);
            canva.draw.setPenColor(this.getCor());
            canva.draw.filledCircle(getX(), getY(), raio * 0.96);
        }else{
            canva.draw.setPenColor(this.getCor());
            canva.draw.circle(getX(), getY(), raio);
        }
        canva.draw.show();
    }

    @Override
    public double calcularArea(){
        return Math.PI*Math.pow(raio, 2);
    }

    @Override
    public double calcularPerimetro(){
        return 2*Math.PI*raio;
    }
}

