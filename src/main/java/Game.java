import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game {

    public static void main(String[] args) {
        GLCanvas canvas = new Canva();
        canvas.setPreferredSize(new Dimension(660, 480));

        canvas.setFocusable(true);
        // add animator to set the frame rate
        final FPSAnimator animator = new FPSAnimator(canvas, 300,true );

        final JFrame frame = new JFrame();
        frame.getContentPane().add(canvas);

        frame.setTitle("Shoot dat cube");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        animator.start();

    }
}
