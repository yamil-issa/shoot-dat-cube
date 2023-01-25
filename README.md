# shoot-dat-cube
This is a basic Java game using JOGL (Java binding for the OpenGL graphics library) and Swing. The main class "Game" creates a GLCanvas (a canvas to display OpenGL graphics) with a preferred size of 660x480. It also sets the frame rate using an FPSAnimator (frames per second animator) at 300 frames per second. The game's title is "Shoot dat cube" and the game will exit when the close button is pressed.

The Canva class extends the GLCanvas class, and it implements the GLEventListener, KeyListener interfaces. It has a private field called player which is an instance of the Player class. It also has an ArrayList of enemies and another ArrayList of bullets. The class overrides the init(), dispose(), display() methods from GLEventListener, and it has its own method called shoot() which creates a new bullet and adds it to the bullets list.

The display() method is responsible for rendering the game's graphics and it includes code for drawing the player and enemies, updating their positions, and handling user input.

# How to play
- You can move the ship to the right or to the left by pressing the direction key of the keyboard
- You can shoot by pressing the space key 
