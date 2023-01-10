import com.jogamp.opengl.GL2;
public class Enemy {
    public void drawCube(GL2 gl) {
        gl.glBegin(GL2.GL_QUADS);
        // Front
        gl.glColor3d(0, 1, 0);
        gl.glVertex3d(-1, -1, 1);
        gl.glVertex3d(1, -1, 1);
        gl.glVertex3d(1, 1, 1);
        gl.glVertex3d(-1, 1, 1);
        // Back
        gl.glColor3d(0, 1, 0);
        gl.glVertex3d(-1, -1, -1);
        gl.glVertex3d(1, -1, -1);
        gl.glVertex3d(1, 1, -1);
        gl.glVertex3d(-1, 1, -1);
        // Left
        gl.glColor3d(0, 1, 0);
        gl.glVertex3d(-1, -1, -1);
        gl.glVertex3d(-1, -1, 1);
        gl.glVertex3d(-1, 1,  1);
        gl.glVertex3d(-1, 1, -1);
        // Right
        gl.glColor3d(0, 1, 0);
        gl.glVertex3d(1, -1, -1);
        gl.glVertex3d(1, -1, 1);
        gl.glVertex3d(1, 1,  1);
        gl.glVertex3d(1, 1, -1);
        // Bottom
        gl.glColor3d(0, 1, 0);
        gl.glVertex3d(-1, -1, 1);
        gl.glVertex3d(1, -1, 1);
        gl.glVertex3d(1, -1, -1);
        gl.glVertex3d(-1, -1, -1);
        // Up
        gl.glColor3d(0, 1, 0);
        gl.glVertex3d(-1, 1, 1);
        gl.glVertex3d(1, 1, 1);
        gl.glVertex3d(1, 1, -1);
        gl.glVertex3d(-1, 1, -1);
        gl.glEnd();

    }

}
