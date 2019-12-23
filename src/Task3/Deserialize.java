package Task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Deserialize {
    private String path;
    public Deserialize(String path) {
        this.path = path;
    }

    public <T> T deserial(Class<?> cl) throws IllegalAccessException, InstantiationException {
        String data = "";
        T result = (T) cl.newInstance();
        Field[] fields = cl.getDeclaredFields();
        try (Scanner in = new Scanner(new File(this.path))) {
            while (in.hasNext())
                data += in.nextLine() + ":";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] res = data.split(":");
        int i = 0;
        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
            }
            if(field.getType() == int.class) {
                if(field.getName().equals(res[i])){
                    field.set(result,Integer.parseInt(res[i+1]));
                    i=i+2;
                    continue;
                }
            }
            if (field.getType() == String.class) {
                if(field.getName().equals(res[i])){
                    field.set(result,res[i+1]);
                    i=i+2;
                    continue;
                }

            }
            i=i+2;
        }
        return result;
    }
}
