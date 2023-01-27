package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);
		System.out.print("Room number: ");
		Integer room = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), formatter);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), formatter);

		if (!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: Checkout date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(room, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(sc.next(), formatter);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(sc.next(), formatter);

			String error = reservation.updateDate(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation);
			}
		}
		sc.close();
	}
}
