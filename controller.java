package com.example.demo;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class controller {
	String otp;
	@Autowired
	private Service service;
	@Autowired
	private Sellerrepo repo;
	@Autowired
	private UniqueRepo urepo;
	@Autowired
	private Sellerrepo2 repo2;
	@Autowired
	private VehDetailsRepo repo3;
	@Autowired
	private Buyerrepo byrepo;
	@Autowired
	private Unique1Repo repo1;
	@Autowired
	private Buyerreqrepo repo4;
	@Autowired
	private udpateservice serv;
	@Autowired
	private JavaMailSender javamailSender;
	@GetMapping("/home")
  public String home()
  {
	  return"index";
  }
	 @GetMapping("/sell")
	public String Seller()
	{
		return "seller";
	}
	 @PostMapping("/snd")
	 public String otpSendtoMail(@ModelAttribute Model1 email)
	 { 
		otp=service.generateOtp();
		service.sendMail(email, otp);
		System.out.println("data send to mail succefully");
		return "OtpSendSuccess";
	 }
	 @PostMapping("/go")
		public String otp()
		{
			return "verifyemail";
		}
	 @PostMapping("/otpverify")
		public String otpp(HttpServletRequest request,Model model)
		{
		 
		 
			String n;
			n=request.getParameter("EmailOtp");
			if(n!=null && n.equals(otp))
			{
				HttpSession session=request.getSession();
				 session.setAttribute("Email",n);
				try 
				{
					Thread.sleep(5000);
					 return "finalsignup";
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("equal");
			}
			else
			{
				System.out.println("not equal");
			}
			return "verifyemail";
		}
	 
	 @PostMapping("/savedonninfo")
	 public String saveDonerinfo(Model2 mod2)
		{ 
			if(mod2!=null)
			{
				repo.save(mod2);
				System.out.println("data saved succesfully to db");
			}
			try 
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return "index";
		}
	 @PostMapping("/login")
	 public String DonerLogin(HttpServletRequest request,Model model)
	 {
		 String n=request.getParameter("Dlemail");
		 String n1=request.getParameter("Dlpass");
		 Model2 model2=repo.findByDemaillAndDpasssowrd(n, n1);
		 if(model2!=null)
		 {
			 try 
				{
					TimeUnit.SECONDS.sleep(5);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("login Success");
				return"SellerPage";
		 }
		 else 
		 {
			 try 
				{
					TimeUnit.SECONDS.sleep(2);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("login Success");
			System.out.println("not login succesully");
			model.addAttribute("msg","Invalid Email or Password!");
			 return "seller";
		 }
	 }
	 @PostMapping("/uniquekey")
	 public String Uniquekey(Model3 mod3)
	 {
		 if(mod3!=null)
		 {
			 urepo.save(mod3);
			 try 
				{
					Thread.sleep(5000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return "generated";
		 }
		 else 
		 {
			 return "index";
		 }
	 }
	 @PostMapping("/sendquery")
	 public String sendQuery(@RequestParam("qemail") String email, @RequestParam("qmessage") String query)
	 {
		 try 
			{
				String n="nitinsr246@gmail.com";
				String subject="Hye Developer, this query is send by"+"\t"+email+"\t"+"from Gadi Dheko";
				MimeMessage message=javamailSender.createMimeMessage();
				MimeMessageHelper helper=new MimeMessageHelper(message);
				helper.setFrom(email);
				helper.setTo(n);
				helper.setSubject(subject);
				helper.setText(query);
			    javamailSender.send(message);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		   return "querysend";
	 }
	 @PostMapping("/goback")
		public String goback()
		{
			try 
			{
				Thread.sleep(3000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return "SellerPage";
		}
	 @PostMapping("/sellerdetails")
	 public String savesellerdetails(Model5 mod5, HttpServletRequest req,Model model)
		{ 
		 String n=req.getParameter("Ykey");
			if(mod5!=null)
			{
				repo2.save(mod5);
				try 
				{
					Thread.sleep(5000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("data saved succesfully to db");
				
				return"datasave";
			}
			else 
			{
			try 
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return "!datasave";
			}
		}
	 @PostMapping("/gobackk")
		public String go()
		{
			try 
			{
				Thread.sleep(3000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return "SellerPage";
		}
	 @PostMapping("/vehicledetails")
	 private String saveVehicle(@RequestParam MultipartFile Oimage1,
			 @RequestParam MultipartFile Oimage2,@RequestParam MultipartFile Oimage3,
			 @RequestParam MultipartFile Oimage4,
			 @RequestParam String Oname,@RequestParam String Oemail,
			 @RequestParam String Okey,@RequestParam String Ophno,
			 @RequestParam String Ovtyp,@RequestParam String Ocomp,
			 @RequestParam String Ovmodel,@RequestParam String Ovyear,
			 @RequestParam String Ovno,@RequestParam String Ovcol,
			 @RequestParam String Ovprice,@RequestParam String Odesc)
	 {
		 Model6 model6 =new Model6();
		 model6.setOimage1(Oimage1.getOriginalFilename());
		 model6.setOimage2(Oimage2.getOriginalFilename());
		 model6.setOimage3(Oimage3.getOriginalFilename());
		 model6.setOimage4(Oimage4.getOriginalFilename());
		 model6.setOname(Oname);
		 model6.setOemail(Oemail);
		 model6.setOkey(Okey);
		 model6.setOphno(Ophno);
		 model6.setOvtyp(Ovtyp);
		 model6.setOcomp(Ocomp);
		 model6.setOvmodel(Ovmodel);
		 model6.setOvyear(Ovyear);
		 model6.setOvno(Ovno);
		 model6.setOvcol(Ovcol);
		 model6.setOvprice(Ovprice);
		 model6.setOdesc(Odesc);
		 Model6 uploadData=repo3.save(model6);
			if(uploadData!=null)
			{
			try 
			{
				File saveFile=new ClassPathResource("static/Vehicleimages").getFile();
				Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+Oimage1.getOriginalFilename());
				Path path1=Paths.get(saveFile.getAbsolutePath()+File.separator+Oimage2.getOriginalFilename());
				Path path2=Paths.get(saveFile.getAbsolutePath()+File.separator+Oimage3.getOriginalFilename());
				Path path3=Paths.get(saveFile.getAbsolutePath()+File.separator+Oimage4.getOriginalFilename());
				
				Files.copy(Oimage1.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
				Files.copy(Oimage2.getInputStream(),path1,StandardCopyOption.REPLACE_EXISTING);
				Files.copy(Oimage3.getInputStream(),path2,StandardCopyOption.REPLACE_EXISTING);
				Files.copy(Oimage4.getInputStream(),path3,StandardCopyOption.REPLACE_EXISTING);
				System.out.println(path);
				System.out.println(path1);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("datasavedsuccessfully");
			return "success";
		}
		else 
		{
			return"VehicleRegistration";
		}
	 }
	 @GetMapping("/showimg")
	 public String ShowVehicle(Model model,HttpServletRequest request)
	 {
		 HttpSession session=request.getSession();
		 int count=0;
		 try 
			{
				TimeUnit.SECONDS.sleep(2);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		 String n=request.getParameter("Key");
		 List<Model6> model6=repo3.findAllByOkey(n);
		 if(model6!=null)
		 {
			 count=model6.size();
			 session.setAttribute("TotalCount",count);
			 System.out.println(count);

			 model.addAttribute("list",model6);
			 return"AddedVehicle";
		 }
		 else 
		 {
			System.out.println("Error Key");
			 return "index";
		 }
	 }
	 @PostMapping("/delete")
	public String DeleteVehicle(HttpServletRequest requ)
	{
		String s=requ.getParameter("Ovno");
		repo3.deleteByOvno(s);
			 try 
				{
					TimeUnit.SECONDS.sleep(5);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("Data delete succesully..");
				return"Datadelered";
	}
	 
	 @PostMapping("/addagain")
	 public String Addagain()
	 {
		 return "VehicleRegistration";
	 }
	 @PostMapping("/gobak")
	 public String GoBak()
	 {
		 return "AddedVehicle";
	 }
	 
	 //Buyer part start
	 @GetMapping("/buyer")
	 public String Buyer()
	 {
		 return "buyer";
	 }
	 
	 @PostMapping("/sndd")
	 public String otpSendtoMaill(@ModelAttribute Model7 email1)
	 { 
		otp=service.generateOtp();
		service.sendMail1(email1, otp);
		System.out.println("data send to mail succefully");
		return "OtpSendSuccess1";
	 }
	 @PostMapping("/goo")
		public String otp1()
		{
			return "verifyemail1";
		}
	 
	 @PostMapping("/otpverifyy")
		public String otppp(HttpServletRequest request)
		{
			String n;
			n=request.getParameter("EmailOtpp");
			if(n!=null && n.equals(otp))
			{
				HttpSession session=request.getSession();
				 session.setAttribute("Email",n);
				try 
				{
					Thread.sleep(5000);
					 return "finalsignup1";
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("equal");
			}

			else
			{
				System.out.println("not equal");
			}
				return "index";
			
			
		}
	 
	 
	 
	 @PostMapping("/savbuyerinfo")
	 public String saveBuyer(Model8 mod8)
		{ 
			if(mod8!=null)
			{
				byrepo.save(mod8);
				System.out.println("data saved succesfully to db");
			}
			try 
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return "index";
		}
	 
	 
	 @PostMapping("/loginn")
	 public String BuyerLogin(HttpServletRequest request,Model modelll)
	 {
		 String a=request.getParameter("Blemail");
		 String b=request.getParameter("Blpass");
		 Model8 model8=byrepo.findByBemaillAndBpasssowrd(a, b);
		 if(model8!=null)
		 {
			 try 
				{
					TimeUnit.SECONDS.sleep(5);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("login Success");
				return"Buyerpage"; 
		 }
		 else 
		 {

			 try 
				{
					TimeUnit.SECONDS.sleep(2);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			System.out.println("not login succesully");
			modelll.addAttribute("mssg","Invalid Email or Password!");
			 return "buyer";
		 }
	 }
	  
	 @GetMapping("/showdetails")
	 public String ShowSeller(Model model,HttpServletRequest request)
	 {
		 String n=request.getParameter("city");
		 String n1=request.getParameter("state");
		 int count=0;
		 List<Model5> model5=repo2.findAllByYcityAndYstate(n, n1);
		 if(model5!=null)
		 {
			 try 
				{
					TimeUnit.SECONDS.sleep(2);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			 model.addAttribute("city",n);
			 model.addAttribute("state",n1);
			 model.addAttribute("list",model5);
			 return"SellerList";
		 }
		 else
		 {
			 return "index";
		 }
	 }
	 @GetMapping("/showList")
	 public String ShowList(Model model,HttpServletRequest request)
	 {
		 try 
			{
				TimeUnit.SECONDS.sleep(2);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		 String n=request.getParameter("kiy");
		 List<Model6> model6=repo3.findAllByOkey(n);
		 if(model6!=null)
		 {
			
			 model.addAttribute("key",n);
			 model.addAttribute("list",model6);
			 return"listofvehicle";
		 }
		 else 
		 {
			System.out.println("Error Key");
			 return "index";
		 }
	 }
	  @PostMapping("/bback")
	 public String gos()
	 {
		 return "SellerPage";
	 }
	  
	  @PostMapping("/gen")
		 public String gen()
		 {
			 return "SellerPage";
		 }
	  
	  @PostMapping("!eql")
	  public String notequal()
	  {
		  return "seller";
	  }
	  
	  
	    @PostMapping("/uniquekeyy")
	 public String Uniquekeyy(Model9 mod9,Model modl)
	 {
		 if(mod9!=null)
		 {
			 repo1.save(mod9);
			 try 
				{
					Thread.sleep(2000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return "gennrated";
		 }
		 else 
		 {
			 return "index";
		 }
	 }
	    
	    @PostMapping("/page")
	    public String page()
	    {
	    	return "Buyerpage";
	    }
	    
	    
	     @PostMapping("/sndquery")
	 public String sendQueryy(@RequestParam("eml") String email, @RequestParam("msg") String query)
	 {
		 try 
			{
				String n="nitinsr246@gmail.com";
				String subject="Hye Developer, this query is send by"+"\t"+email+"\t"+"from Gadi Dheko";
				MimeMessage message=javamailSender.createMimeMessage();
				MimeMessageHelper helper=new MimeMessageHelper(message);
				helper.setFrom(email);
				helper.setTo(n);
				helper.setSubject(subject);
				helper.setText(query);
			    javamailSender.send(message);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		   return "querysend1";
	 }
	     
	     @PostMapping("/gback")
			public String g()
			{
				try 
				{
					Thread.sleep(3000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return "Buyerpage";
			}
	     
	      @PostMapping("/buyerreq")
	 private String buyerreq(@RequestParam MultipartFile Bimage1,
			 @RequestParam MultipartFile Bimage2,
			 @RequestParam String Bname,@RequestParam String Bcity,
			 @RequestParam String Bstate,@RequestParam String Baddress,
			 @RequestParam String Bno,@RequestParam String Bmail,
			 @RequestParam String Bvno,@RequestParam String Bnp,
			 @RequestParam String Bdesc,Model modl1)
	 {
		 Model10 model10 =new Model10();
		 
		model10.setBimage1(Bimage1.getOriginalFilename());
		model10.setBimage2(Bimage2.getOriginalFilename());
		model10.setBname(Bname);
		model10.setBcity(Bcity);
		model10.setBstate(Bstate);
		model10.setBaddress(Baddress);
		model10.setBno(Bno);
		model10.setBmail(Bmail);
		model10.setBvno(Bvno);
		model10.setBnp(Bnp);
		model10.setBdesc(Bdesc);
		 Model10 uploadData=repo4.save(model10);
			if(uploadData!=null)
			{
			try 
			{
				File saveFile=new ClassPathResource("static/Buyerimages").getFile();
				Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+Bimage1.getOriginalFilename());
				Path path1=Paths.get(saveFile.getAbsolutePath()+File.separator+Bimage2.getOriginalFilename());
			
				
				Files.copy(Bimage1.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
				Files.copy(Bimage2.getInputStream(),path1,StandardCopyOption.REPLACE_EXISTING);
			
				System.out.println(path);
				System.out.println(path1);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("datasavedsuccessfully");
			modl1.addAttribute("sccs","Your Details Send Succefully");
			return "listofvehicle";
		}
		else 
		{
			return"VehicleRegistration";
		}
	 }
	      
	      @GetMapping("/state")
	 	 public String ShowBuyer(Model model,HttpServletRequest request)
	 	 {
	 		 try 
	 			{
	 				TimeUnit.SECONDS.sleep(2);
	 			}
	 			catch(Exception e)
	 			{
	 				e.printStackTrace();
	 			}
	 		 String n=request.getParameter("state");
	 		// List<Model6> model6=repo3.findAllByOkey(n);
	 		 List<Model10> model10= repo4.findAllByBstate(n);
	 		 if(model10!=null)
	 		 {
	 			model.addAttribute("st",n);
	 			 model.addAttribute("lst",model10);
	 			 return"ListofBuyer";
	 		 }
	 		 else 
	 		 {
	 			System.out.println("Error Key");
	 			 return "index";
	 		 }
	 	 }
	      
	      
	        @PostMapping("/deletee")
	public String DeleteBuyer(HttpServletRequest requ,Model mo1)
	{
		String s=requ.getParameter("delbuyer");
		repo4.deleteByBmail(s);
			 try 
				{
					TimeUnit.SECONDS.sleep(5);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("Data delete succesully..");
				mo1.addAttribute("dl","Buyer Deleted Successfully");
				return"ListofBuyer";
	}
	        
	        
	          @PostMapping("/sndmsgb")
	 public String sendmsgb(@RequestParam("bemail") String email, @RequestParam("bmessage") String query)
	 {
		 try 
			{
				String n="nitinsr246@gmail.com";
				String subject="Hye Buyer, this query is send by"+"\t"+email+"\t"+"from Gadi Dheko";
				MimeMessage message=javamailSender.createMimeMessage();
				MimeMessageHelper helper=new MimeMessageHelper(message);
				helper.setFrom(email);
				helper.setTo(n);
				helper.setSubject(subject);
				helper.setText(query);
			    javamailSender.send(message);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		   return "msgsend";
	 }
	         
	          @PostMapping("/mg")
				public String mgsend()
				{
					try 
					{
						Thread.sleep(3000);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					return "ListofBuyer";
				}
		     
	       
	          
	 @GetMapping("/shwimg")
	 public String dashboard(Model model,HttpServletRequest request)
	 {
		 try 
			{
				TimeUnit.SECONDS.sleep(2);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		 String n=request.getParameter("bemail");
		 List<Model10>m10=repo4.findAllByBmail(n);
		 if(m10!=null)
		 {
			 model.addAttribute("lt",m10);
			 return"Dshboard";
		 }
		 else 
		 {
			System.out.println("Error Key");
			 return "index";
		 }
	 }
	   
	 
	  @PostMapping("/deleteyour")
	public String Deleteyouself(HttpServletRequest requ,Model mo1)
	{
		String s=requ.getParameter("delyour");
		repo4.deleteByBmail(s);
			 try 
				{
					TimeUnit.SECONDS.sleep(5);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("Data delete succesully..");
				mo1.addAttribute("yr","Data Deleted Successfully");
				return"Dshboard";
	}   
	  
	  //forgot email
	    @PostMapping("/fogemapas")
	 public String emailforverify(@ModelAttribute Model11 email)
	 { 
		otp=service.generateOtp();
		service.sendMail2(email, otp);
		System.out.println("data send to mail succefully");
		return "otpsendsuccess2";
	 }
	   
	    
	      @PostMapping("/verify")
		public String emailotp()
		{
			return "verifyemail2";
		}
	     
	      @PostMapping("/emailverify")
		public String verifyemail(HttpServletRequest request,Model model)
		{
			String n;
			n=request.getParameter("vrfotp");
			if(n!=null && n.equals(otp))
			{
				try 
				{
					Thread.sleep(5000);
					 return "Updatepassword";
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("equal");
			}
			else
			{
				System.out.println("not equal");
			}
			return "verifyemail2";
		}
	     
	       @PostMapping("/updatepassword")
	public String Updatepassword(HttpServletRequest requ,Model mo1)
	{
		String s=requ.getParameter("fgeml");
		String s1=requ.getParameter("snewpass");
		boolean success= serv.updatePassword(s, s1);
		if(success)
		{
			try 
			{
				TimeUnit.SECONDS.sleep(5);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("Your Password Update Succefully");
			mo1.addAttribute("update","Password Updated Successfully!");
			return"seller";
		}
		else 
		{
			System.out.println("Password not update success");
			mo1.addAttribute("!update","Something Went Wrong!");
			return "verifyemail";
		}
			
	} 
	       
	       
	//buyer forgot 
	       @PostMapping("/fogemapass")
	  	 public String emailforrverify(@ModelAttribute Model12 email)
	  	 { 
	  		otp=service.generateOtp();
	  		service.sendMaill5(email, otp);
	  		System.out.println("data send to mail succefully");
	  		return "otpsendsuccess3";
	  	 }
	       
	       @PostMapping("/veriffy")
			public String emailotpp()
			{
				return "verifyemail3";
			}
        
	       @PostMapping("/emailverfy")
			public String verifyemaill(HttpServletRequest request,Model model)
			{
				String n;
				n=request.getParameter("rfotp");
				if(n!=null && n.equals(otp))
				{
					try 
					{
						Thread.sleep(5000);
						 return "Updatepassword1";
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					System.out.println("equal");
				}
				else
				{
					System.out.println("not equal");
				}
				return "verifyemail3";
			}
	       
	       
	       
	        @PostMapping("/updatepssword")
	public String Uupdatepassword(HttpServletRequest requ,Model mo1)
	{
		String s=requ.getParameter("feml");
		String s1=requ.getParameter("sewpass");
		boolean success= serv.updatePasswordd(s, s1);
		if(success)
		{
			try 
			{
				TimeUnit.SECONDS.sleep(5);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("Your Password Update Succefully");
			mo1.addAttribute("update","Password Updated Successfully!");
			return"buyer";
		}
		else 
		{
			System.out.println("Password not update success");
			mo1.addAttribute("!update","Something Went Wrong!");
			return "verifyemail3";
		}
			
	} 
	        
}
