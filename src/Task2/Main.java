package Task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        TextContainer textContainer = new TextContainer("Hello,World!!!!");
        final Class<?> cls = TextContainer.class;
        try {
            Method method =  cls.getMethod("save", String.class);
            SaveTo save = cls.getAnnotation(SaveTo.class);
            Method[] methods = cls.getMethods();
            for (Method meth: methods) {
                if(meth.isAnnotationPresent(Saver.class)){
                    meth.invoke(textContainer,save.someString());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Well done!");
        }
    }
}
