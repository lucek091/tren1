import java.util.Hashtable;

/**
 * Created by kdeveloper on 11/17/16.
 */
public class ShapeCache {
    public static Hashtable<String, Shape> shapeMap=new Hashtable<String, Shape>();

    public static Shape getShape (String shapeId){
        Shape cachedShape=shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache(){
        Circle circle1=new Circle();
        circle1.setId("1");
        shapeMap.put(circle1.getId(), circle1);

        Square square1=new Square();
        square1.setId("2");
        shapeMap.put(square1.getId(), square1);

        Rectangle rectangle1=new Rectangle();
        rectangle1.setId("3");
        shapeMap.put(rectangle1.getId(), rectangle1);
    }

}
