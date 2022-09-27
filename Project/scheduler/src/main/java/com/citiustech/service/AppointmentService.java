package com.citiustech.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citiustech.constants.AppointmentConstants;
import com.citiustech.dto.AppointmentDTO;
import com.citiustech.dto.UserDTO;
import com.citiustech.enums.AppointmentStatus;
import com.citiustech.exception.AppointmentException;
import com.citiustech.model.Appointment;
import com.citiustech.repository.AppointmentRepository;
import com.citiustech.request.ChangeStatusRequest;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository  appointmentRepository;
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	private String ENDPOINT_URL = "http://localhost:8070/api/user/findById/";
	
	public void saveAppointment(AppointmentDTO appointmentDTO) {
		Appointment appointment = new Appointment();
		if(appointmentDTO!=null) {
			BeanUtils.copyProperties(appointmentDTO, appointment);
			appointment.setStatus(AppointmentStatus.PENDING);
			
			UserDTO response = restTemplate.getForObject(ENDPOINT_URL+appointmentDTO.getPhysicianId(), UserDTO.class);

			appointment.setPhysicianName(response.getFirstName()+" "+response.getLastName());
			
			appointment.setMeetingTitle(appointment.getPatientName()+"&"+appointment.getPhysicianName());
			
			appointmentRepository.save(appointment);
		} else {
			throw new AppointmentException(AppointmentConstants.SAVE_APPOINTMENT_FAILED);
		}	
	}
	
	public void changeStatus(ChangeStatusRequest request) {
		Appointment appointment = appointmentRepository.findById(request.getId());
		
		System.out.println(request.getStatus());
		if(request.getStatus().equals("ACCEPTED")) {
			appointment.setStatus(AppointmentStatus.ACCEPTED);
		} else if(request.getStatus().equals("REJECTED")) {
			appointment.setStatus(AppointmentStatus.REJECTED);
		} else {
			appointment.setStatus(AppointmentStatus.COMPLETED);
		}
		
		appointmentRepository.save(appointment);
	}
	
	
}















