package ifsc.poo;
import edu.princeton.cs.algs4.Draw;

public class Canvas {
    public Draw draw;

    public void desenharTela(){
        this.draw = new Draw();
        this.draw.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.draw.setCanvasSize(800, 1000);
        this.draw.setXscale(0,1000);
        this.draw.setYscale(0,600);
        draw.enableDoubleBuffering();
        draw.show();
    }
}