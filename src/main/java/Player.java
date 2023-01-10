import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
public class Player {
    // fields to store the position and size of the player
    private float x;
    private float y;
    private float width;
    private float height;

    // constructor to initialize the position and size of the player
    public Player(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // method to draw the player
    public void draw(GL2 gl) {
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(0.0f, 1.0f, 0.0f); // set color to green
        gl.glVertex2f(x, y);
        gl.glVertex2f(x + width, y);
        gl.glVertex2f(x + width, y + height);
        gl.glVertex2f(x, y + height);
        gl.glEnd();
    }

    // method to move the player to the left
    public void moveLeft() {
        x -= 0.1f; // move the player 0.1 units to the left
    }

    // method to move the player to the right
    public void moveRight() {
        x += 0.1f; // move the player 0.1 units to the right
    }

    public float getX(){
        return this.x;
    }
}
