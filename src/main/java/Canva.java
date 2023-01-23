import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Array;
import java.util.ArrayList;

public class Canva extends GLCanvas implements GLEventListener, KeyListener {
    private float xPos = 0.0f;
    private float yPos = -0.7f;
    private Player player; // instance of the Player class
    public ArrayList<Enemy> enemies = new ArrayList<Enemy>() ;
    private float r_speed1;
    private float x_position = -19.0f; // initial x position of the enemy
    private float direction = 0.1f; // direction of scrolling (left or right)

    public Canva() {
        this.addGLEventListener(this);
        player = new Player();
        addKeyListener(this);

    }

    ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    public void shoot() {
        float x = xPos;
        float y = yPos;
        float width = 0.1f;
        float height = 0.1f;
        Bullet bullet = new Bullet(x/2, y, width/2, height);
        bullets.add(bullet);
    }


    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        // vider les valeurs du z-buffer
        gl.glClearDepth(1.0f);
        // activer le test de profondeur
        gl.glEnable(GL2.GL_DEPTH_TEST);
        // choisir le type de test de profondeur
        gl.glDepthFunc(GL2.GL_LEQUAL);
        // choix de la meilleur correction de perspective
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        // Initialisation des Ã©tats
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);     // Clear The Screen And The Depth Buffer
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glLoadIdentity();


        // loop through the two lines of cubes
        for (int i = 0; i < 3; i++) {
            // loop through the six cubes in each line
            for (int j = 0; j < 6; j++) {
                Enemy enemy = new Enemy();
                gl.glPushMatrix();
                gl.glTranslatef(x_position + (j * 4), i * 3.5f, -35.0f);
                gl.glRotatef(r_speed1, 0.0f, 1.0f, 0.0f);
                gl.glScaled(1.0f, 1.0f, 1.0f);
                enemy.drawCube(gl);
                gl.glPopMatrix();

            }

        }

        gl.glLoadIdentity();
        gl.glTranslatef(xPos, yPos, -2);
        gl.glPushMatrix();
        player.drawPlayer(gl);
        gl.glPopMatrix();


        gl.glFlush();
        r_speed1 += 0.2f;


        // update the x position of the cubes
        x_position += direction;
        // reverse the direction when the cubes reach the edges of the window
        if (x_position > 19.0f || x_position < -19.0f) {
            direction = -direction;
        }

        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            gl.glPushMatrix();
            gl.glTranslatef(bullet.getX(), bullet.getX(), 0.0f);
            bullet.draw(gl);
            gl.glPopMatrix();
            bullet.setY(0.1f);
            if(bullet.getY() > 480) // if the bullet goes off the screen
                bullets.remove(i);

        }

    }


    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int x, int y, int width, int height) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        GLU glu = GLU.createGLU(gl);

        float aspect = (float)width / height;
        // Set the view port (display area)
        gl.glViewport(0, 0, width, height);
        // Setup perspective projection,
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0, aspect, 0.1, 100.0);
        // Enable the model-view transform
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity(); // reset

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            xPos -= 0.1;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            xPos += 0.1;
        } else if (keyCode == KeyEvent.VK_SPACE) {
            shoot();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
