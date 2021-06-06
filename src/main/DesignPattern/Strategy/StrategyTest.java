package main.DesignPattern.Strategy;

/**
 * @author Aijiner
 * @date 2021/6/3 20:38
 */
public class StrategyTest {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.strategyMethod();
        context.setStrategy(new ConcreteStrategyB());
        context.strategyMethod();
    }
}

interface Strategy {
    public void StrategyMethod();
}

class ConcreteStrategyA implements Strategy {
    @Override
    public void StrategyMethod() {
        System.err.println("ConcreteStrategyA.StrategyMethod");
    }
}

class ConcreteStrategyB implements Strategy {
    @Override
    public void StrategyMethod() {
        System.err.println("ConcreteStrategyB.StrategyMethod");
    }
}

// 环境类
class Context {
    private Strategy strategy;
    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public void strategyMethod(){
        this.strategy.StrategyMethod();
    }
}














