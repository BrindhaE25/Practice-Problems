import processing.core.PApplet;

public class FourBalls extends PApplet {
    public static final int width = 600;
    public static final int height = 600;
    int firstposition =0, secondposition=0, thirdposition=0, fourthposition=0;
    int first=1, second=2, third=3, fourth=4;

    public static void main(String args[]) {
        PApplet.main("FourBalls", args);
    }

    @Override
    public void settings() {
        size(width, height);
    }


    @Override
    public void draw() {
        ellipse(firstposition,(first*height)/5,10,10);
        firstposition+=first;
        ellipse(secondposition,(second*height)/5,10,10);
        secondposition+=second;
        ellipse(thirdposition,(third*height)/5,10,10);
        thirdposition+=third;
        ellipse(fourthposition,(fourth*height)/5,10,10);
        fourthposition+=fourth;
    }

}
