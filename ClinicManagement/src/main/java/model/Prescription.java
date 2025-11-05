package model;
public class Prescription {
    private int prescriptionId;
    private int appointmentId;
    private String medicines;
    private String diagnosis;

    public Prescription() {}
    public Prescription(int prescriptionId, int appointmentId, String medicines, String diagnosis) {
        this.prescriptionId = prescriptionId; this.appointmentId = appointmentId; this.medicines = medicines; this.diagnosis = diagnosis;
    }
    public int getPrescriptionId() { return prescriptionId; }
    public void setPrescriptionId(int prescriptionId) { this.prescriptionId = prescriptionId; }
    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }
    public String getMedicines() { return medicines; }
    public void setMedicines(String medicines) { this.medicines = medicines; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
}
