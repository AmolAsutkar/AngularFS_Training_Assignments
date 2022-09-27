package com.citiustech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.constants.AppointmentConstants;
import com.citiustech.dto.AppointmentDTO;
import com.citiustech.dto.AppointmentResponseDTO;
import com.citiustech.enums.AppointmentStatus;
import com.citiustech.model.Appointment;
import com.citiustech.repository.AppointmentRepository;
import com.citiustech.request.ChangeStatusRequest;
import com.citiustech.service.AppointmentService;

@RestController
@RequestMapping("/api/appointment")
//@CrossOrigin("*")
@CrossOrigin(origins = "http://localhost:4200")

public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@PostMapping("/save")
	public ResponseEntity<AppointmentResponseDTO> saveAppointment(@RequestBody AppointmentDTO appointmentDTO) {
		AppointmentResponseDTO responseDTO = new AppointmentResponseDTO();
		appointmentService.saveAppointment(appointmentDTO);
		responseDTO.setStatus(HttpStatus.OK);
		responseDTO.setMessage(AppointmentConstants.SAVE_APPOINTMENT);
		return new ResponseEntity<AppointmentResponseDTO>(responseDTO, responseDTO.getStatus());
	}
	
	@GetMapping("/getByUser")
	//public ResponseEntity<List<Appointment>> fetchByUserId(@RequestParam(name = "id") long id, @RequestParam(name="status") AppointmentStatus status) {

	public ResponseEntity<List<Appointment>> fetchByUserId(@RequestParam(name = "id") long id ) {


		return new ResponseEntity<List<Appointment>>(appointmentRepository.findAllByUserIdAndStatus(id), HttpStatus.OK);
		//return new ResponseEntity<List<Appointment>>(appointmentRepository.findAllByUserIdAndStatus(id, status), HttpStatus.OK);

	}
	
	@GetMapping("/getByPhysician")
	public ResponseEntity<List<Appointment>> fetchByPhysicianId(@RequestParam(name = "id") long id) {

	//public ResponseEntity<List<Appointment>> fetchByPhysicianId(@RequestParam(name = "id") long id,  @RequestParam(name="status") AppointmentStatus status) {
	//return new ResponseEntity<List<Appointment>>(appointmentRepository.findAllByPhysicianIdAndStatus(id, status), HttpStatus.OK);

		return new ResponseEntity<List<Appointment>>(appointmentRepository.findAllByPhysicianIdAndStatus(id), HttpStatus.OK);
	}
	
	@PostMapping("/changeStatus")
	public ResponseEntity<String> changeStatus(@RequestBody ChangeStatusRequest request) {
		appointmentService.changeStatus(request);
		return new ResponseEntity<String>("Status updated!!!", HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Appointment> getById(@PathVariable(name = "id") long id) {
		return new ResponseEntity<Appointment>(appointmentRepository.findById(id), HttpStatus.OK);
	}

}












