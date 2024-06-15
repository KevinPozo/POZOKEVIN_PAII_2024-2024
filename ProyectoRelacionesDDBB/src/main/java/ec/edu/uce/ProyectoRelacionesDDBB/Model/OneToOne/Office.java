/**
 *
 * @author KevinPozo
 * Title: Relaciones Entidades Springboot.
 *
 *
 * */
package ec.edu.uce.ProyectoRelacionesDDBB.Model.OneToOne;

import jakarta.persistence.*;

@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roomNumber;
    private String building;

    @OneToOne(mappedBy = "office")
    private Doctor doctor;

    public Office(){

    }

    public Office(Long id, String roomNumber, String building, Doctor doctor) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.building = building;
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        String doctorName = (doctor != null) ? doctor.getName() : null;
        return "Office{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", building='" + building + '\'' +
                ", doctorName='" + doctorName + '\'' +
                '}';
    }
}
