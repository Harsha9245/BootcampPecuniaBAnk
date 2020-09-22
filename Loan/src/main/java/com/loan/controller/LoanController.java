package com.loan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.entity.LoanRequests;
import com.loan.service.LoanPecuniaService;



@RestController
@RequestMapping("/loan")

public class LoanController {

	@Autowired
	LoanPecuniaService service;
	
	@PostMapping("/request")
	public ResponseEntity<String> loanRequest(@RequestBody LoanRequests loanreq) throws Exception
	{
		if(loanreq.getAccountId()==null)
		{
			throw new Exception("cannot be null");
		}
		else
		{
			String request = service.loanRequest(loanreq);
			return new ResponseEntity<String>(request, new HttpHeaders(), HttpStatus.OK); 
		}
	}
	
}
