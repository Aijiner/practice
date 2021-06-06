package main.DesignPattern.AbstractFactory;

/**
 * @author Aijiner
 * @date 2021/5/30 20:25
 */
public class AbstractFactoryTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String[] strs = {"main.DesignPattern.AbstractFactory.AFarm","main.DesignPattern.AbstractFactory.BFarm"};
        for (String str : strs) {
            Farm farm = (Farm) Class.forName(str).newInstance();
            Animal animal = farm.getAnimal();
            Plant plant = farm.getPlant();
            animal.show();
            plant.show();
        }
    }
}

// 动物
interface Animal {
    void show();
}

// 马
class Horse implements Animal {
    private String farmName;
    public Horse(String farmName) {
        this.farmName = farmName;
    }
    @Override
    public void show() {
        System.err.println(farmName + " : Horse");
    }
}

// 牛
class Cattle implements Animal {
    private String farmName;
    public Cattle(String farmName) {
        this.farmName = farmName;
    }
    @Override
    public void show() {
        System.err.println(farmName + " : Cattle");
    }
}

// 植物
interface Plant {
    void show();
}

// 水果
class Fruitage implements Plant {
    private String farmName;
    public Fruitage(String farmName) {
        this.farmName = farmName;
    }
    @Override
    public void show() {
        System.err.println(farmName + " : Fruitage");
    }
}

// 蔬菜
class Vegetables implements Plant {
    private String farmName;
    public Vegetables(String farmName) {
        this.farmName = farmName;
    }
    @Override
    public void show() {
        System.err.println(farmName + " : Vegetables");
    }
}

// 农场
interface Farm {
    public Animal getAnimal();

    public Plant getPlant();
}

class AFarm implements Farm {
    @Override
    public Animal getAnimal() {
        return new Horse("AFarm");
    }

    @Override
    public Plant getPlant() {
        return new Fruitage("AFarm");
    }
}

class BFarm implements Farm {
    @Override
    public Animal getAnimal() {
        return new Cattle("BFarm");
    }

    @Override
    public Plant getPlant() {
        return new Vegetables("BFarm");
    }
}




