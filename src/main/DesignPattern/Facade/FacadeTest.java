package main.DesignPattern.Facade;

/**
 * @author Aijiner
 * @date 2021/5/31 22:12
 */
public class FacadeTest {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.showA();
        facade.showB();
    }
}

class Facade {
    private SubSystemA subSystemA = new SubSystemA();
    private SubSystemB subSystemB = new SubSystemB();

    public void showA(){
        subSystemA.show();
    }

    public void showB() {
        subSystemB.show();
    }

}

class SubSystemA {
    public void show() {
        System.err.println("SubSystemA.show");
    }
}

class SubSystemB {
    public void show() {
        System.err.println("SubSystemB.show");
    }
}