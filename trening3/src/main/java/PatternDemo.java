/**
 * Created by kdeveloper on 11/17/16.
 */
public class PatternDemo {
    public static void main(String[] args){
        ShapeCache.loadCache();
        ShapeCache.shapeMap.forEach((k,v)->System.out.println(k+" "+v));




        Shape clonedShape1=(Shape)ShapeCache.getShape("1");
        System.out.println("Shape : "+clonedShape1.getType());

        Shape clonedShape2=(Shape)ShapeCache.getShape("2");
        System.out.println("Shape : "+clonedShape2.getType());

        Shape clonedShape3=(Shape)ShapeCache.getShape("3");
        System.out.println("Shape : "+clonedShape3.getType());
    }
}
