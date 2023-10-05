package com.example.Service;

import java.util.List;

import com.example.Entity.Appointment;

public interface AppointmentService {
	public Appointment addAppointment(Appointment ap);

	public List<Appointment> getAllAppointments();

	public Appointment getAppointmentById(int id);

	public String deleteAppointment(int id);

	public Appointment updateAppointment(Appointment ap);

}
