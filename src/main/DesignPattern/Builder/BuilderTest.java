package main.DesignPattern.Builder;

/**
 * @author Aijiner
 * @date 2021/5/30 21:48
 */
public class BuilderTest {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        product.show();
    }
}

// 产品
class Product {
    private String paramA;
    private String paramB;
    public void setParamA(String paramA) {
        this.paramA = paramA;
    }
    public void setParamB(String paramB) {
        this.paramB = paramB;
    }

    public void show(){
        System.err.println("paramA: " + paramA + ", paramB: " + paramB);
    }
}

// 抽象建造者
abstract class Builder {
    protected Product product = new Product();

    public abstract void buildParamA();
    public abstract void buildParamB();

    public Product getProduct() {
        return product;
    }
}

// 具体建造者
class ConcreteBuilder extends Builder {
    @Override
    public void buildParamA() {
        product.setParamA("构建A");
    }

    @Override
    public void buildParamB() {
        product.setParamB("构建B");
    }
}

// 指挥者
class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.buildParamA();
        builder.buildParamB();
        return builder.getProduct();
    }
}














