import java.awt.*;
import javax.swing.*;

/***
 *  Classe reta demonstra como denhar pixel a pixel uma reta em uma Jframe
 *  USJT_2020/1 - CCP4BN-BUA
 */
public class Reta extends JFrame{

    /***
     * No construtor vamos definir as propriedades da nossa Janela
     */
    public Reta(){
        setSize(600, 600);
        setTitle("Desenhando uma reta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
    }

    public void desenhandoReta(int x1, int y1, int x2, int y2){
        float dx, dy, m, b;
        // Cálculo do Coeficiente Angular
        dx = x2 - x1;
        dy = y2 - y1;
        m = dy/dx;

        //Calculando b que é onde a reta cruza o eixo y
        b = y1 - (m * x1);

        //Nessa parte do código estamos definindo a cor de fundo da nossa janela
        Graphics g = getGraphics();
        g.setColor(new Color(219, 219, 219));
        g.fillRect(0, 0, 600, 600);
        tempo(10);

        //Definindo cor da nossa reta em RGB(red,green,blue)
        g.setColor(new Color(255, 0, 0));

        /***
         * A cada interação do nosso loop, é incrementado um ponto em nosso x
         * e calculado nosso novo ponto Y com nosso coeficiente Angular
         * e por fim usando o metodo fillOval para desenhar um pixel em nossa tela.
         */
        for (int i = x1; i <= x2; i++) {

            //Calculando novo ponto de Y
            float result = (m * i) + b;
            int newY = (int) result;

            g.fillOval(i, newY, 1, 1);
            tempo(10);
        }
    }

    public void tempo(int time){
        try {
            Thread.sleep(time);
        } catch (Exception e) {}
    }

    public static void main(String [] args){
        Reta prog = new Reta();
        prog.tempo(30);
        /**
         * Aqui nesse trecho de código, e solicitado ao usuario para entrar com os pontos
         */
        int x1 = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Digite x1"));
        int y1 = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Digite y1"));
        int x2 = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Digite x2"));
        int y2 = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Digite y2"));
        prog.desenhandoReta(x1, y1, x2, y2);
    }
}