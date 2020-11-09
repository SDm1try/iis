package Strategy;

public class StrategyPattern {
    public static void main(String[] args) {
        Context a = new Context();

        a.setStrategy(new StrategyAdd());
        System.out.println("execute StrategyAdd 3,2 = " + a.executeStrategy(3, 2));

        a.setStrategy(new StrategySubtract());
        System.out.println("execute StrategySubtract 3,2 = " + a.executeStrategy(3, 2));

        a.setStrategy(new StrategyMultiply());
        System.out.println("execute StrategyMultiply 3,2 = " + a.executeStrategy(3, 2));
    }
}

class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}

interface Strategy {
    int execute(int a, int b);
}

class StrategyAdd implements Strategy {

    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}

class StrategySubtract implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}

class StrategyMultiply implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}