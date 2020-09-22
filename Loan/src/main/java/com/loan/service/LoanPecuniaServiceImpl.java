package com.loan.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.dao.AccountDao;
import com.loan.dao.LoanRequestDao;
import com.loan.entity.Account;
import com.loan.entity.LoanRequests;



@Service
public class LoanPecuniaServiceImpl implements LoanPecuniaService {
    
	@Autowired
	private LoanRequestDao dao;
	@Autowired
	private AccountDao account;

	@Override
	public String loanRequest(LoanRequests loanreq) {
		
	      String s = loanreq.getAccountId();
	    
	      Optional<Account> details = account.findById(s);
	      
	      if(details.isPresent()) {
	    	  dao.save(loanreq);
	       
	    	  return "Your Loan Request is successful";
	      }	      else
	      {
	    	  return "No BankAccount found with " + loanreq.getAccountId() + "\n You need to have an Bank Account to apply Loan";
	      }
		
	}


	
	
	
}
