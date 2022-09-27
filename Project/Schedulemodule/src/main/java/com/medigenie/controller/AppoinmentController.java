package com.medigenie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.medigenie.constant.SchedulingConstant;
import com.medigenie.dto.SchedulingResponseDTO;
import com.medigenie.dto.UserDTO;
import com.medigenie.model.Appoinment;
import com.medigenie.scheduleappoinment.service.AppoinmentService;

@RestController
@CrossOrigin(origins="*")
public class AppoinmentController {
	
	@Autowired
	private HttpServletRequest request;
	
    Appoinment appoinment=new Appoinment();
	@Autowired
	AppoinmentService appoinmentservice;
	
	
	int id=4;
	
	
	@PostMapping("/bookappoinment")

	public ResponseEntity<SchedulingResponseDTO> saveAppoinment(@RequestBody Appoinment appoinment) {
		SchedulingResponseDTO responsedto=new SchedulingResponseDTO();
		RestTemplate restemplate = new RestTemplate();
		String url="http://localhost:8070/api/user/findById/" +appoinment.getPhysicianId();
		UserDTO result=restemplate.getForObject(url, UserDTO.class);
		appoinment.setPhysicianname(result.getFirstName()+" " +result.getLastName());
		appoinmentservice.saveAppoinment(appoinment);
		responsedto.setStatus(HttpStatus.OK);
		responsedto.setMessage(SchedulingConstant.SAVE_SUCCESS);
		return new ResponseEntity<>(responsedto,responsedto.getStatus());
	}
	

	@GetMapping("/Viewappoinment")
	public List<Appoinment> seeAllAppoinment() {
		//String headerNames = request.getHeader("user");
		//System.out.println(headerNames +" header name is ");
		/*while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
          System.out.println("key is "+key +"  value is "+value);
		}*/
		return appoinmentservice.fetchAllAppoinment();

	}
	
	@GetMapping("/viewdoctorsappoinment")
	public List<Appoinment>  seeDoctorsAppoinment() {
		return appoinmentservice.fetchAllAppoinment();
	}
	
	
	
	@DeleteMapping("/deleteappoinment/{id}")
	public void deleteAppoinment(@PathVariable("id") Long id) {
		 appoinmentservice.deleteAppoinmentById(id);
	}
	
	
	
}
