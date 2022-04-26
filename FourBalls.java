import processing.core.PApplet;

public class FourBalls extends PApplet {
    public static final int width = 600;
    public static final int height = 600;
    Ball [] ball = new Ball[4];

    public static void main(String args[]) {
        PApplet.main("FourBalls", args);
    }

    @Override
    public void settings() {
        size(width, height);
    }

   @Override
    public void setup() {
       for (int iter = 1; iter <= 4; iter++) {
           this.ball[iter-1] = new Ball(0, (iter * height) / 5, iter);}
    }

    @Override
    public void draw() {
        for (int iter = 1; iter <= 4; iter++) {
            this.ball[iter-1].draw(this);
            this.ball[iter-1].moveBall();
        }
    }

}
class Ball extends PApplet{
    int positionX;
    int positionY;
    int speed;

    Ball(int positionX,int positionY,int speed) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
    }

    public void draw(PApplet papplet) {
        papplet.ellipse(this.positionX,this.positionY,10,10);
    }
    public void moveBall() {
        this.positionX=this.positionX + this.speed;
    }

}

