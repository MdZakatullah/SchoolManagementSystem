package com.zak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.zak.entity.StaffDtls;
import com.zak.entity.StudentDtls;
import com.zak.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
//	@Autowired
//    private PasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String landingPage() {
		return "landingPage";
	}
	
	@GetMapping("/al")
	public String adminLogin() {
		return "adminLogin";
	}
	
	@GetMapping("/t")
	public String test() {
		return "test";
	}
	
	@GetMapping("/regstaff")
	public String registerStaff() {
		return "registerStaff";
	}
	
	@GetMapping("/logstaff")
	public String staffLogin() {
		return "staffLogin";
	}
	
	@PostMapping("/registerStaff")
	public String registerStaff(@ModelAttribute StaffDtls u, HttpSession session) {
		System.out.println(u);
		
		repo.save(u);
		session.setAttribute("message", "User Register Successfully..");
		
		return "redirect:/logstaff";
	}
	
	@PostMapping("/loginStaff")
	public String loginStaff(@ModelAttribute StaffDtls u, HttpSession session) {
		//repo.save(u);
		return "redirect:/dash";
	}
	
	@GetMapping("/regstudent")
	public String registerStudent() {
		return "registerStudent";
	}
	
	@GetMapping("/logstudent")
	public String studentLogin() {
		return "studentLogin";
	}
	
	@PostMapping("/registerStudent")
	public String registerStudent(@ModelAttribute StudentDtls s, HttpSession session) {
		System.out.println(s);
		
		repo.save(s);
		session.setAttribute("message", "User Register Successfully..");
		
		return "redirect:/logstudent";
	}
	
	@PostMapping("/loginStudent")
	public String loginStudent(@ModelAttribute StudentDtls s, HttpSession session) {
		//repo.save(u);
		return "redirect:/dash";
	}
	
	@GetMapping("/dash")
	public String dashboard() {
		return "dashboard";
	}
	
	@GetMapping("/hom")
	public String home() {
		return "home";
	}
	
	@GetMapping("/about")
	public String aboutUs() {
		return "aboutUs";
	}
	
	@GetMapping("/contact")
	public String contactUs() {
		return "contactUs";
	}
	
	@GetMapping("/loadForgotPassword")
	public String loadForgotPassword()
	{
		return "forgot_password";
	}
	
	@GetMapping("/loadResetPassword/{id}")
	public String loadResetPassword(@PathVariable int id, Model m)
	{
		m.addAttribute("id", id);
		return "reset_password";
	}
	
	@PostMapping("/forgotPassword")
	public String forgotPassword(@RequestParam String email, HttpSession session)
	{
		StaffDtls user = repo.findByEmail(email);
		
		if(user != null)
		{
			return "redirect:/loadResetPassword/" + user.getId();
				
		}else {
			session.setAttribute("msg", "Invalid email");
			return "forgot_password";
		}
		
	}
	
	@PostMapping("/changePassword")
	public String resetPassword(@RequestParam String psw, @RequestParam Integer id, HttpSession session) {
		
		StaffDtls user = repo.findById(id).get();
		//String encryptPsw=passwordEncoder.encode(psw);
		//user.setPassword(encryptPsw);
		StaffDtls UpdateUser= repo.save(user);
		
		if(UpdateUser!=null) {
			session.setAttribute("msg", "Password change successfully");
		}
		
		return "redirect:/loadForgotPassword";
	}
	
	@GetMapping("/atten")
	public String attendance() {
		return "attendance";
	}
	
	@GetMapping("/forgot")
	public String forgotPassword() {
		return "forgotPassword";
	}
	
	@GetMapping("/parentDash")
	public String parentDashboard() {
		return "parentDashboard";
	}
	
	@GetMapping("/parentH")
	public String parentHome() {
		return "parentHome";
	}
	
	@GetMapping("/school")
	public String schools() {
		return "schools";
	}
	
	@GetMapping("/cu")
	public String collegesUniversities() {
		return "collegesUniversities";
	}
	
	@GetMapping("/ac")
	public String awardCertification() {
		return "awardCertification";
	}
	
	@GetMapping("/rr")
	public String reviewsRatings() {
		return "reviewsRatings";
	}
	
	@GetMapping("carri")
	public String carrier() {
		return "carrier";
	}
	
	@GetMapping("supp")
	public String support() {
		return "support";
	}
	
	@GetMapping("quer")
	public String query() {
		return "query";
	}
		
}
