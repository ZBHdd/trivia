import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        for(Animal a : Animal.values()){
            Class<?> server = a.getValue();
            Object object = server.newInstance();
            Class<?>[] interfaces = server.getInterfaces();
            Method method = interfaces[0].getMethod(a.getMethod(), Object.class);
            method.invoke(object,a.getName());
            
        }
    }
}

interface Server{
    void call(Object s);
}

interface DogServer extends Server{
    void call(Object s);
}

class DogServerimpl implements DogServer{

    public void call(Object s) {
        System.out.println(String.format("I am a %s,I can wang wang wang", (String)s));
    }
}

interface CatServer extends Server{
    void call(Object s);
}

class CatServerimpl implements CatServer{

    public void call(Object s) {
        System.out.println(String.format("I am a %s,I can miao miao miao", (String)s));
    }
}

enum Animal{
    DOG("dog","DogServer","call"),CAT("cat","CatServer","call");

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

    public String getMethod() {
        return method;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getValue() throws ClassNotFoundException {
        return Class.forName(value);
    }

    public void setValue(String value) {
        this.value = value;
    }
}