package main.DesignPattern.Prototype;

/**
 * @author Aijiner
 * @date 2021/5/30 19:04
 * 原型模式
 */
class Realizetype implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype r1 = new Realizetype();
        Realizetype r2 = (Realizetype) r1.clone();
        System.err.println(r1 == r2);
    }
}
