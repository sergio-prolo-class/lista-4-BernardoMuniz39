package ifsc.poo;
import edu.princeton.cs.algs4.Draw;

public class Canvas {
    public Draw draw;

    public void desenharTela(){
        this.draw = new Draw();
        this.draw.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.draw.setCanvasSize(1000, 1000);
        this.draw.setXscale(0,800);
        this.draw.setYscale(0,800);
        draw.enableDoubleBuffering();
        draw.show();
    }

    public void limparTela(){
        this.draw.clear();
        draw.show();
    }
}