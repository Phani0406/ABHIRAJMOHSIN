package model;
public class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private String username;
    private String password;
    private String contact;

    public Doctor() {}
    public Doctor(int doctorId, String name, String specialization, String username, String password, String contact) {
        this.doctorId = doctorId; this.name = name; this.specialization = specialization;
        this.username = username; this.password = password; this.contact = contact;
    }
    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}
