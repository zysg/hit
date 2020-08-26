public class Device {
    private String serialNumber;
    private double price;
    private DeviceSpec spec;

    public Device(String serialNumber,double price,DeviceSpec spec)
    {
        this.serialNumber=serialNumber;
        this.price=price;
        this.spec=spec;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public double getprice()
    {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DeviceSpec getSpec()
    {
        return spec;
    }
}
