package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentOut {

    private AppointmentApi patient;
    private String startDate;
    private Integer id;
    private String firstName;

    public AppointmentOut() {
    }

    public AppointmentOut(AppointmentApi patient, String startDate, Integer id, String firstName) {
        this.patient = patient;
        this.startDate = startDate;
        this.id = id;
        this.firstName = firstName;
    }

    public AppointmentApi getPatient() {
        return patient;
    }

    public void setPatient(AppointmentApi patient) {
        this.patient = patient;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "AppointmentOut{" +
                "patient=" + patient +
                ", startDate='" + startDate + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
