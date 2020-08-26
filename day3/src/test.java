import javax.swing.*;
import java.util.*;

public class test {
    public static void main(String[] args) {
        Invectory invectory=new Invectory();
        initializeInventory(invectory);
        Map properties=new HashMap();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入想查找的电脑类型：1为台式机，2为笔记本，3为服务器");
        int name = Integer.parseInt(sc.nextLine());
        switch (name) {
            case 1:
                properties.put("type","Desktop");
                break;
            case 2:
                properties.put("type","PC");
                break;
            case 3:
                properties.put("type","server");
                break;
        }

        System.out.println("请输入想查找的电脑品牌：1为联想，2为苹果，3为其他");
        int name1 = Integer.parseInt(sc.nextLine());
        switch (name1) {
            case 1:
                properties.put("brand","Lenovo");
                break;
            case 2:
                properties.put("brand","APPLE");
                break;
            case 3:
                properties.put("brand","other");
                break;
        }

        DeviceSpec clientSpec=new DeviceSpec(properties);

        List matchingDevice=invectory.search(clientSpec);
        if(!matchingDevice.isEmpty())
        {
            System.out.println("查找成功");
            for (Iterator i = matchingDevice.iterator(); i.hasNext(); )
            {
                Device device=(Device) i.next();
                System.out.println("设备唯一编号为："+device.getSerialNumber()+"设备价格为："+device.getprice());
                DeviceSpec spec=device.getSpec();
                for (Iterator j = spec.getProperties().keySet().iterator(); j.hasNext(); ) {
                    String propertyName=(String)j.next();
                    System.out.println("设备的"+propertyName+"为"+spec.getProperties().get(propertyName));
                }
            }
        }else{
            System.out.println("没有找到");
        }
    }

    public static void initializeInventory(Invectory invectory) {
        String serialNumber1= UUID.randomUUID().toString();
        double price1=1000;
        Map properties1=new HashMap();
        properties1.put("type","PC");
        properties1.put("brand","Lenovo");
        DeviceSpec spec1=new DeviceSpec(properties1);
        invectory.adddevice(serialNumber1,price1,spec1);

        String serialNumber2= UUID.randomUUID().toString();
        double price2=2000;
        Map properties2=new HashMap();
        properties2.put("type","Desktop");
        properties2.put("brand","APPLE");
        DeviceSpec spec2=new DeviceSpec(properties2);
        invectory.adddevice(serialNumber2,price2,spec2);

        String serialNumber3= UUID.randomUUID().toString();
        double price3=5200;
        Map properties3=new HashMap();
        properties3.put("type","Desktop");
        properties3.put("brand","Lenovo");
        DeviceSpec spec3=new DeviceSpec(properties3);
        invectory.adddevice(serialNumber3,price3,spec3);
    }
}
