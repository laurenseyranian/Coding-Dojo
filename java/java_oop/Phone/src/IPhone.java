public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return ("iPhone" + this.versionNumber + "says Zing");
    }
    @Override
    public String unlock() {
    	return ("Unlocking via facial recognition");
    }
    @Override
    public void displayInfo() {
        System.out.println("Version Number: "+this.getVersionNumber()+", Battery Percentage: "+this.getBatteryPercentage()+", Carrier: "+this.getCarrier()+", Ring Tone: "+this.getRingTone());          
    }
}
