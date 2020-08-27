import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎光临，请输入想要点的咖啡的数量：");
        int num = Integer.parseInt(sc.nextLine());

        System.out.println("请输入咖啡的杯型：1为中杯，2为大杯，3为超大杯（回车默认为中杯）");
        int cup_num = 1;
        try {
            cup_num = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            cup_num = 1;
        }
        String cup;
        switch (cup_num){
            case 1:
                cup="中杯";
                break;
            case 2:
                cup="大杯";
                break;
            case 3:
                cup="超大杯";
                break;
            default:
                cup="中杯";
        }

        System.out.println("请输入咖啡的温度：1为热，2为微热，3为冰，4为去冰（回车默认为冰）");
        int temp = 2;
        try {
            temp = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            temp = 2;
        }
        String temperature;
        switch (temp){
            case 1:
                temperature="热";
                break;
            case 2:
                temperature="微热";
                break;
            case 3:
                temperature="冰";
                break;
            case 4:
                temperature="去冰";
                break;
            default:
                temperature="冰";
        }

        System.out.println("请输入牛奶：1为全脂牛奶，2为燕麦奶，3为脱脂牛奶（回车默认为不加牛奶）");
        int milk_type = 4;
        try {
            temp = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            temp = 4;
        }
        String milk;
        switch (milk_type){
            case 1:
                milk="全脂牛奶";
                break;
            case 2:
                milk="燕麦奶";
                break;
            case 3:
                milk="脱脂牛奶";
                break;
            default:
                milk="不加牛奶";
        }

        Beverage beverage=new coffee(num, cup, temperature, milk);
        while(true) {
            System.out.println("请加入风味糖浆：1为原味，2为香草，3为焦糖, 4为不加糖浆（回车默认为不加糖浆）");
            int syrup_name = 4;
            try {
                syrup_name = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                syrup_name = 4;
            }
            String syrup;
            switch (syrup_name) {
                case 1:
                    beverage = new Originalsyrup(beverage);
                    break;
                case 2:
                    beverage = new vanillasyrup(beverage);
                    break;
                case 3:
                    beverage = new caramelsyrup(beverage);
                    break;
                default:
                    break;
            }
            if(syrup_name==4)
                break;
        }

        System.out.println(beverage.getDescription()+"\n"+"价格为"+num*beverage.cost()+"元");
        System.out.println("请扫描二维码付款，谢谢光临！");
    }
}
