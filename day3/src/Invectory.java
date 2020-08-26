import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Invectory {
    private List inventory;

    public Invectory() {
        inventory = new LinkedList();
    }
    public void adddevice(String serialNumber,double price,DeviceSpec spec)
    {
        Device device = new Device(serialNumber, price, spec);
        inventory.add(device);
    }

    public Device get(String serialNumber)
    {
        for (Iterator i = inventory.iterator(); i.hasNext(); )
        {
            Device device=(Device) i.next();
            if (device.getSerialNumber().equals(serialNumber))
                return device;
        }
        return null;
    }

    public List search(DeviceSpec searchSpec)
    {
        List matchingDevice=new LinkedList();
        for (Iterator i = inventory.iterator(); i.hasNext(); )
        {
            Device device=(Device) i.next();
            if (device.getSpec().matches(searchSpec))
                matchingDevice.add(device);
        }
        return matchingDevice;
    }
}
