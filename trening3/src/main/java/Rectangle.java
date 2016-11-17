/**
 * Created by kdeveloper on 11/17/16.
 */
public class Rectangle extends Shape {
    public Rectangle(){
        type="Rectangle";
    }

    @Override
    public void draw(){
        System.out.println("Inside Rectangle::draw() method");
    }
}
