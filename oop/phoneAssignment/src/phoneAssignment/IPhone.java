package phoneAssignment;

public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
       return "Zing";
    }
    @Override
    public String unlock() {
       return "Unlocking via facial recognition";
    }
    @Override
    public void displayInfo() {
       System.out.println("iPhone " + this.getVersionNumber() + " from " + this.getCarrier());           
    }
}
