package neu.data.model;

public class VitalSigns {
    private String remarks;
    private String purpose;
    private float bodyTemperature;
    private float bloodPressure;
    private int pulseRate;
    private int respirationRate;

    public VitalSigns(String remarks, String purpose, float bodyTemperature, float bloodPressure, int pulseRate, int respirationRate) {
        this.remarks = remarks;
        this.purpose = purpose;
        this.bodyTemperature = bodyTemperature;
        this.bloodPressure = bloodPressure;
        this.pulseRate = pulseRate;
        this.respirationRate = respirationRate;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getPurpose() {
        return purpose;
    }

    public float getBodyTemperature() {
        return bodyTemperature;
    }

    public float getBloodPressure() {
        return bloodPressure;
    }

    public int getPulseRate() {
        return pulseRate;
    }

    public int getRespirationRate() {
        return respirationRate;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setBodyTemperature(float bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public void setBloodPressure(float bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public void setPulseRate(int pulseRate) {
        this.pulseRate = pulseRate;
    }

    public void setRespirationRate(int respirationRate) {
        this.respirationRate = respirationRate;
    } 
}
