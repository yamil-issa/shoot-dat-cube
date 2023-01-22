import com.jogamp.opengl.GL2;
import com.jogamp.opengl.awt.GLCanvas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player  {
    public void drawPlayer(GL2 gl) {
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(0.5f, 0.5f, 0.5f);
        gl.glVertex3f(-0.0625f, -0.0625f, 0.0f);
        gl.glVertex3f(-0.0625f, -0.125f, 0.0f);
        gl.glVertex3f(0.0625f, -0.125f, 0.0f);
        gl.glVertex3f(0.0625f, -0.0625f, 0.0f);
        gl.glEnd();
    }

}
