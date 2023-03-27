package com.hms.controller;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dtos.EmployeeUserDataBacking;
import com.hms.dtos.Response;
import com.hms.jwt.JWTUtility;
import com.hms.services.UserServices;
import com.hms.spring_security.UserDetailsService;
@CrossOrigin
@RestController@PermitAll @RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserServices  services;
	@Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userService;
    
  
	//
  
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticateUser(@RequestBody EmployeeUserDataBacking useData) throws Exception { 
		
		//token generation code 
		try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                    		useData.getEmail(),
                    		useData.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(useData.getEmail());

        final String token =
                jwtUtility.generateToken(userDetails);

		
		EmployeeUserDataBacking user=services.getUserByEmailAndPassword(useData);
		if(user!=null) {
			if(user.getPassword()!=null&&user.getPassword().equals(useData.getPassword())) {
				user.setToken(token);
				return Response.success(user);
			}
				
			return Response.error("invalid_password");
		}
		else
		return Response.error("invalid_user");
		
	}
	@PostMapping("/emailExists")
	public ResponseEntity<?> checkIfEmailExists(@RequestBody EmployeeUserDataBacking useData ){
		Boolean emailExists=services.checkIfEmailExists(useData);
		if(emailExists==true)
		return Response.success("DUPLICATE_EMAIL");
		else
		return Response.success("UNIQUE_EMAIL");
	}
	
	@PostMapping("/validateSecurityAnswer")
	public ResponseEntity<?> checkIfUserExistByEmailAndSecurity(@RequestBody EmployeeUserDataBacking useData ){
		Boolean emailExists=services.checkByEmailAndSecurity(useData);
		if(emailExists==true)
		return Response.success("VALID");
		else
		return Response.success("INVALID");
	}
	@PostMapping("/updatePassword")
	public ResponseEntity<?> updatePassword(@RequestBody EmployeeUserDataBacking useData ){
		Boolean emailExists=services.updatePassword(useData);
		if(emailExists==true)
		return Response.success("PASSWORD_CHANGED");
		else
		return Response.success("INVALID");
	}
	
	

}
