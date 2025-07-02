package ifsc.poo;
import edu.princeton.cs.algs4.Draw;

public class Canvas {
    public Draw draw;

    public Canvas() {
        this.draw = new Draw();
        this.draw.setCanvasSize(500, 500);
        this.draw.setXscale(0,800);
        this.draw.setYscale(0,800);
        draw.enableDoubleBuffering();
    }

    public void desenharTela(){
        draw.show();
    }

    public void limparTela(){
        this.draw.clear();
        draw.show();
    }
}