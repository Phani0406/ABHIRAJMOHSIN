package model;
import java.util.Date;
public class Bill {
    private int billId;
    private int appointmentId;
    private double consultationFee;
    private double medicineCharges;
    private double labCharges;
    private double total;
    private Date billDate;

    public Bill() {}
    public Bill(int billId, int appointmentId, double consultationFee, double medicineCharges, double labCharges, double total, Date billDate) {
        this.billId = billId; this.appointmentId = appointmentId; this.consultationFee = consultationFee;
        this.medicineCharges = medicineCharges; this.labCharges = labCharges; this.total = total; this.billDate = billDate;
    }
    public int getBillId() { return billId; }
    public void setBillId(int billId) { this.billId = billId; }
    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }
    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }
    public double getMedicineCharges() { return medicineCharges; }
    public void setMedicineCharges(double medicineCharges) { this.medicineCharges = medicineCharges; }
    public double getLabCharges() { return labCharges; }
    public void setLabCharges(double labCharges) { this.labCharges = labCharges; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public Date getBillDate() { return billDate; }
    public void setBillDate(Date billDate) { this.billDate = billDate; }
}
