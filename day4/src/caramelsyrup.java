public class caramelsyrup extends CondimentDecorator {
    public caramelsyrup(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() +"\n "+"+1份焦糖糖浆";
    }

    public double cost() {
        return 4 + beverage.cost();
    }
}
