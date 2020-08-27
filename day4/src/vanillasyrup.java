public class vanillasyrup extends CondimentDecorator {
    public vanillasyrup(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() +"\n "+"+1份香草糖浆";
    }

    public double cost() {
        return 4 + beverage.cost();
    }
}
