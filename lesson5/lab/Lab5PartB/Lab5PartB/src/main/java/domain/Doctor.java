package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Column;

import jakarta.persistence.Embeddable;

@Entity
@Embeddable
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "type")
	private String doctorType;
	private String firstName;
	private String lastName;

	public Doctor() {
	}

	public Doctor(String doctorType, String firstName, String lastName) {
		this.doctorType = doctorType;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public String getDoctorType() {
		return doctorType;
	}

	public void setDoctorType(String doctorType) {
		this.doctorType = doctorType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", doctorType=" + doctorType + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

}
