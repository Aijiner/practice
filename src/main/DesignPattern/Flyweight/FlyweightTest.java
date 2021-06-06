package main.DesignPattern.Flyweight;

import java.util.HashMap;

/**
 * @author Aijiner
 * @date 2021/6/2 21:06
 */
public class FlyweightTest {
    public static void main(String[] args) {
        FlyweightFactory ff = new FlyweightFactory();
        ff.getFlyweight("A").operation(new UnsharedConcreteFlyweight("A1"));
        ff.getFlyweight("A").operation(new UnsharedConcreteFlyweight("A2"));
        ff.getFlyweight("B").operation(new UnsharedConcreteFlyweight("B1"));
        ff.getFlyweight("B").operation(new UnsharedConcreteFlyweight("B2"));

    }
}
// 非享元角色
class UnsharedConcreteFlyweight {
    private String info;

    public UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

// 抽象享元角色
interface Flyweight {
    void operation(UnsharedConcreteFlyweight usf);
}

// 具体享元角色
class ConcreteFlyweight implements Flyweight{
    private String key;

    public ConcreteFlyweight(String key) {
        System.err.println("[" + key + "] Flyweight created");
        this.key = key;
    }

    @Override
    public void operation(UnsharedConcreteFlyweight usf) {
        System.err.println("Flyweight key is [" + key + "]");
        System.err.println("UnsharedConcreteFlyweight info is [" + usf.getInfo() + "]");
    }
}

// 享元工厂角色
class FlyweightFactory {
    private HashMap<String, Flyweight> flyweightHashMap = new HashMap<>();
    public Flyweight getFlyweight(String key) {
        if (flyweightHashMap.containsKey(key)) {
            System.err.println("Flyweight key[" + key + "] exist");
            return flyweightHashMap.get(key);
        } else {
            Flyweight flyweight = new ConcreteFlyweight(key);
            flyweightHashMap.put(key, flyweight);
            return flyweight;
        }
    }
}


