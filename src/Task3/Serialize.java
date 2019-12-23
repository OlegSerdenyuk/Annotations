package Task3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Serialize implements Serializable {
    Object object ;
    public Serialize(Object obj ){
        this.object=obj;
    }

    public void serialize() throws IllegalAccessException {
        Class<?> cl = this.object.getClass();
        Field[] fields = cl.getDeclaredFields();
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\User\\Desktop\\ser.txt")) {
            for (Field field : fields) {
                if (Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                }
                fileWriter.write(field.getName() + ":");
                if (field.getType() == int.class) {
                    fileWriter.write(field.getInt(object) +"\n");
                }
                if (field.getType() == String.class) {
                    fileWriter.write((String) field.get(object) + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
