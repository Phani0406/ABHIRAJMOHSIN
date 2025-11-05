package model;
public class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String date; // YYYY-MM-DD
    private String time; // HH:mm
    private String reason;
    private String status;

    public Appointment() {}
    public Appointment(int appointmentId, int patientId, int doctorId, String date, String time, String reason, String status) {
        this.appointmentId = appointmentId; this.patientId = patientId; this.doctorId = doctorId;
        this.date = date; this.time = time; this.reason = reason; this.status = status;
    }
    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
