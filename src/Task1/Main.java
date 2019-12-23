package Task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Sum sum = new Sum();
        try {
            final Class<?> cls = Sum.class;
            Method method = cls.getMethod("sum", int.class, int.class);
            MyAnnotation ma = method.getAnnotation(MyAnnotation.class);
            Method[] methods = cls.getMethods();
            for (Method meth : methods) {
                if (meth.isAnnotationPresent(MyAnnotation.class)) {
                    System.out.println(meth.invoke(sum, ma.a(), ma.b()));
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
