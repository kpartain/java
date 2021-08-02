package phoneAssignment;

public abstract class Phone {
	private String versionNumber;
    private int batteryPercentage;
    private String carrier;
    private String ringTone;
    public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
    }
    // abstract method. This method will be implemented by the subclasses
    public abstract void displayInfo();
    public void setVersionNumber(String newVersionNumber) {
    	this.versionNumber = newVersionNumber;
    }
    public void setBatteryPercentage(int newBatteryPercentage) {
    	this.batteryPercentage = newBatteryPercentage;
    }
    public void setCarrier(String newCarrier) {
    	this.carrier = newCarrier;
    }
    public void setRingTone(String newRingTone) {
    	this.ringTone = newRingTone;
    }
    public String getVersionNumber() {
    	return this.versionNumber;
    }
    public int getBatteryPercentage() {
    	return this.batteryPercentage;
    }
    public String getCarrier() {
    	return this.carrier;
    }
    public String getRingTone() {
    	return this.ringTone;
    }
}
