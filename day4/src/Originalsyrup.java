public class Originalsyrup extends CondimentDecorator {
    public Originalsyrup(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() +"\n "+"+1份原味糖浆";
    }

    public double cost() {
        return 2 + beverage.cost();
    }
}
