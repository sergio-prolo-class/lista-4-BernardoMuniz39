package ifsc.poo.figuras;

import ifsc.poo.Canvas;
import ifsc.poo.ObjetoDeDesenho;
import java.awt.Color;

public class Pentagono extends ObjetoDeDesenho{
    private double lado;

    public Pentagono(double lado, double x, double y, Color cor, boolean preenchido){
        super(x, y, cor, preenchido);
        this.lado = lado;
    }
        
    @Override
    public void desenhar(Canvas canva){
        double[] x = new double[5];
        double[] y = new double[5];

        for(int i = 0; i < 5; i++){
            x[i] = getX() + lado * Math.cos(2 * Math.PI * i / 5);
            y[i] = getY() + lado * Math.sin(2 * Math.PI * i / 5);
        }

        if(this.ehPreenchido()){
            canva.draw.setPenColor(Color.BLACK);
            canva.draw.filledPolygon(x, y);

            for(int i = 0; i < 5; i++){
                x[i] = getX() + (lado*0.96) * Math.cos(2 * Math.PI * i / 5);
                y[i] = getY() + (lado*0.96) * Math.sin(2 * Math.PI * i / 5);
            }

            canva.draw.setPenColor(this.getCor());
            canva.draw.filledPolygon(x, y);
        }else{
            canva.draw.setPenColor(this.getCor());
            canva.draw.polygon(x, y);
        }
        canva.draw.show();
    }
    
    @Override
    public double calcularArea(){
        double apotema = lado/(2*Math.tan(Math.PI/5)); //tg(36°)
        return (5*lado*apotema)/2;
    }

    @Override
    public double calcularPerimetro(){
        return 5*lado;
    }
    
}
