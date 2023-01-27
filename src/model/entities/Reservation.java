package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Long duration() {
		return Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay()).toDays();
	}

	public void updateDate(LocalDate checkin, LocalDate checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "Room " + this.roomNumber + ", check-in: " + this.checkin.format(formatter) + ", check-out: "
				+ this.checkout.format(formatter) + ", " + this.duration() + " nigths";
	}
}
