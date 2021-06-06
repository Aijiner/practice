package main.DesignPattern.singleton;

/**
 *
 * @author Aijiner
 * @date 2021/5/30 18:47
 * 饿汉式单例
 */
public class HungrySingleton implements Cloneable {
    private static final HungrySingleton INSTANCE = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        HungrySingleton h1 = HungrySingleton.getInstance();
        HungrySingleton h2 = HungrySingleton.getInstance();
        HungrySingleton h3 = (HungrySingleton) h1.clone();

        System.err.println(h1 == h2); // true
        System.err.println(h1 == h3); // false
    }
}
