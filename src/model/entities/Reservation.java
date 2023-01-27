package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Long duration() {
		return Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay()).toDays();
	}

	public String updateDate(LocalDate checkIn, LocalDate checkOut) {
		LocalDate now = LocalDate.now();
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			return "Reservation dates for update must be future dates";
		}
		if (!checkOut.isAfter(checkIn)) {
			return "Check-out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Room " + this.roomNumber + ", check-in: " + this.checkIn.format(formatter) + ", check-out: "
				+ this.checkOut.format(formatter) + ", " + this.duration() + " nigths";
	}
}
