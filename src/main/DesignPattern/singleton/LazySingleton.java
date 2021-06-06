package main.DesignPattern.singleton;

/**
 * @author Aijiner
 * @date 2021/5/30 18:38
 * 懒汉式单例
 */
public class LazySingleton {
    private static volatile LazySingleton instance = null; //保证 instance 在所有线程中同步
    private LazySingleton() {}
    public static LazySingleton getInstance() {
        if (null == instance) {
            synchronized (LazySingleton.class) {
                if (null == instance) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
