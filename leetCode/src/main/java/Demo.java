import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        for(Animal a : Animal.values()){
            Class<?> server = a.getValue();
            Object object = server.newInstance();
            Method method = server.getMethod(a.getMethod(),Object.class);
            method.invoke(object,a.getName());
            
        }
    }
}

interface BaseClient{
    void call(Object s);
    void hit(Object s);
}


class DogClient implements BaseClient{

    public void call(Object s) {
        System.out.println(String.format("I am a %s,I can wang wang wang", (String)s));
    }

    public void hit(Object s) {
        System.out.println(String.format("I am a %s,I hit dog", (String)s));
    }
}

class CatClient implements BaseClient{

    public void call(Object s) {
        System.out.println(String.format("I am a %s,I can miao miao miao", (String)s));
    }

    public void hit(Object s) {
        System.out.println(String.format("I am a %s,I hit cat", (String)s));
    }
}

enum Animal{
    DOG("dog","DogClient","call"),CAT("cat","CatClient","hit");

    private String name;
    private String value;
    private String method;

    Animal(String name, String value,String method) {
        this.name = name;
        this.value = value;
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public Class<?> getValue() throws ClassNotFoundException {
        return Class.forName(value);
    }

    public String getMethod() {
        return method;
    }

    public void setValue(String value) {
        this.value = value;
    }
}