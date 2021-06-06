package main.DesignPattern.Interpreter;

/**
 * @author Aijiner
 * @date 2021/6/5 17:11
 */
public class InterpreterTest {
    public static void main(String[] args) {
        Expression expression1 = new TerminalExpression("love");
        Expression expression2 = new TerminalExpression("like");

        Expression expression = new OrExpression(expression1,expression2);

        System.err.println(expression.interpret("love"));
        System.err.println(expression.interpret("like"));
        System.err.println(expression.interpret("miss"));
    }
}

// 解释器接口
interface Expression {
    boolean interpret(String str);
}

class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String str) {
        return str.contains(data);
    }
}

class OrExpression implements Expression {
    private Expression expressionA;
    private Expression expressionB;

    public OrExpression(Expression expressionA, Expression expressionB) {
        this.expressionA = expressionA;
        this.expressionB = expressionB;
    }

    @Override
    public boolean interpret(String str) {
        return expressionA.interpret(str) || expressionB.interpret(str);
    }
}



