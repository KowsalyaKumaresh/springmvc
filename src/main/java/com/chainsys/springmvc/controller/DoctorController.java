package com.chainsys.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.springmvc.dao.DoctorRepository;
import com.chainsys.springmvc.dao.EmployeeDao;
import com.chainsys.springmvc.pojo.Appointment;
import com.chainsys.springmvc.pojo.Doctor;
import com.chainsys.springmvc.pojo.DoctorAppointmentsDTO;
import com.chainsys.springmvc.pojo.Employee;
import com.chainsys.springmvc.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	DoctorService drService;

	@GetMapping("/doctorlist")
	public String getDoctors(Model model) {
		List<Doctor> doclist = drService.getDoctors();
		model.addAttribute("alldoctors", doclist);
		return "list-doctors";
	}

	@GetMapping("/addform")
	public String showAddForm(Model model) {
		Doctor theDoc = new Doctor();
		model.addAttribute("adddoctor", theDoc);
		return "add-doctor-form";
	}

	@PostMapping("/newdoctor")
	public String addNewDoctor(@ModelAttribute("adddoctor") Doctor theDoc) {
		drService.save(theDoc);
		return "redirect:/doctor/doctorlist";
	}

	@GetMapping("/updateform")
	public String showUpdateForm(@RequestParam("docid") int id, Model model) {
		Doctor theDoc = drService.findById(id);
		model.addAttribute("updatedoctor", theDoc);
		return "update-doctor-form";
	}

	@PostMapping("updatedoc")
	public String updateDoctor(@ModelAttribute("updatedoctor") Doctor theDoc) {
		drService.save(theDoc);
		return "redirect:/doctor/doctorlist";
	}

	@GetMapping("/deletedoctor")
	public String deleteDoctro(@RequestParam("docid") int id) {
		drService.deleteDoctorById(id);
		return "redirect:/doctor/doctorlist";

	}

	@GetMapping("/finddoctorbyid")
	public String findDoctorById(@RequestParam("docid") int id, Model model) {
		Doctor theDoc = drService.findById(id);
		model.addAttribute("finddoctorbyid", theDoc);
		return "find-doctor-id-form";
	}

	@GetMapping("/getdocapp")
	public String getAppointments(@RequestParam("id") int id, Model model) {
		DoctorAppointmentsDTO dto = drService.getDoctorAndAppointments(id);
		model.addAttribute("getdoc", dto.getDoctor());
		model.addAttribute("applist", dto.getAppointments());
		return "list-doctor-appointments";
	}

	// localhost:8080/doctor/trans?id=22
	@GetMapping("/trans")
	public void testTransaction(@RequestParam("id") int id) {
		DoctorAppointmentsDTO dto = new DoctorAppointmentsDTO();
		Doctor dr = new Doctor();
		dr.setDoctor_id(id);
		dr.setDoctor_name("kowsi");
		Date dt = new Date(21, 7, 25);
		dr.setDob(dt);
		dr.setCity("coimbatore");
		dr.setPhone_no(9824674844l);
		dr.setSpeciality("dermatology");
		dr.setStandard_fees(1500);
		dto.setDoctor(dr);
		List<Appointment> appList = new ArrayList<Appointment>();
//		int nextAppId = drService.getNextAppointmentId();
		for (int i = 200; i < 202; i++) {
			Appointment app = new Appointment();
			app.setApp_id(i);
			Date appdt = new Date(22, 7, 25);
			app.setApp_date(appdt);
			app.setDoctor_id(id);
			app.setPatient_name("jeru");
			app.setFees_collected(dr.getStandard_fees());
			dto.addAppointment(app);
		}
		drService.addDoctorAndAppointments(dto);
		System.out.println("Successfully completed!!");
	}

}
