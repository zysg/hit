public class coffee extends Beverage {

    public coffee(int num, String cup, String temperature, String milk)
    {
        this.num=num;
        this.cup=cup;
        this.temperature=temperature;
        this.milk=milk;
        description = "点了"+num+"杯"+cup+temperature+milk+"的咖啡";
    }

    public double cost() {
        double sum=10;

        if(cup.equals("中杯")) sum+=0;
        else if(cup.equals("大杯")) sum+=5;
        else sum+=10;

        if(milk.equals("全脂牛奶")) sum+=2;
        else if(milk.equals("燕麦奶")) sum+=3;
        else if(milk.equals("脱脂牛奶")) sum+=4;
        else sum+=0;

        return sum;
    }

    private int num;
    private String cup;
    private String temperature;
    private String milk;
}
