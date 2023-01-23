import com.jogamp.opengl.GL2;

class Bullet {
    private float x;
    private float y;
    private float width;
    private float height;

    public Bullet(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(GL2 gl) {
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(x, y);
        gl.glVertex2f(x + width, y);
        gl.glVertex2f(x + width, y + height);
        gl.glVertex2f(x, y + height);
        gl.glEnd();
    }

    public float setY(float a) {
        return this.y += a;

    }

    public float setX(float a) {
        return this.x += a;

    }

    public float getX() {
        return  this.x;
    }

    public float getY() {
        return  this.y;
    }

}
