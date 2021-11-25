package com.upgrad.bookmyconsultation.controller;

import com.upgrad.bookmyconsultation.dto.AppointmentDTO;
import com.upgrad.bookmyconsultation.entity.Appointment;
import com.upgrad.bookmyconsultation.exception.InvalidInputException;
import com.upgrad.bookmyconsultation.exception.SlotUnavailableException;
import com.upgrad.bookmyconsultation.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private ModelMapper modelMapper;

	//create a method post method named bookAppointment with return type ReponseEntity
		//method has paramter of type Appointment, use RequestBody Annotation for mapping
	
		//save the appointment details to the database and save the response from the method used
		//return http response using ResponseEntity
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> bookAppointment(@RequestBody AppointmentDTO appointmentDTO) throws InvalidInputException {
		Appointment appointment=modelMapper.map(appointmentDTO,Appointment.class);
		String appointmentId= appointmentService.appointment(appointment);
		return new ResponseEntity(appointmentId, HttpStatus.CREATED);
	}

	//create a get method named getAppointment with return type as ResponseEntity
		//method has appointmentId of type String. Use PathVariable annotation to identity appointment using the parameter defined
		//get the appointment details using the appointmentId
		//save the response
		//return the response as an http response
	@GetMapping(value="{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getAppointment(@PathVariable(name="id") String id) {
		Appointment appointment=appointmentService.getAppointment(id);
		AppointmentDTO appointmentDTO=modelMapper.map(appointment,AppointmentDTO.class);
		return new ResponseEntity(appointmentDTO,HttpStatus.OK);
	}
}