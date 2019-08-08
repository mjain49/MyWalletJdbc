package com.cg.service;

import java.util.List;
import java.util.Map;

import com.cg.bean.Account;
import com.cg.dao.AccountDAO;
import com.cg.dao.AccountDAOImpl;
import com.cg.exception.InsufficientBalanceException;

public class AccountServiceImpl implements AccountService {
	
	AccountDAO a= new AccountDAOImpl();
		
	@Override
	public boolean addAccount(Account ob) {
		return a.addAccount(ob);
	}

	@Override
	public boolean deleteAccount(Account ob) {
		// TODO Auto-generated method stub
		return a.deleteAccount(ob);
		
	}
	@Override
	public boolean updateAccount(Account acc, String name) {
		 acc.setAccountholder(name);
		 return a.updateAccount(acc);
	}

	@Override
	public boolean transferMoney(Account from, Account to, Double amount) throws InsufficientBalanceException {
		// TODO Auto-generated method stub
		return a.transferMoney(from, to, amount);
	}

	@Override
	public Account findAccount(Long mo) {
		// TODO Auto-generated method stub
		return a.findAccount(mo);
	}

	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return a.getAllAccount();
	}

	@Override
	public boolean deposit(Account ac, Double amount) {
		// TODO Auto-generated method stub
		return a.deposit(ac, amount);
	}

	@Override
	public boolean withdraw(Account ac, Double amount) throws InsufficientBalanceException {
		// TODO Auto-generated method stub
		return a.withdraw(ac, amount);
	}

	public  void printStatement(Account ob) {
		 
		 System.out.println("========================================");
		 System.out.println("Statement for Account NO.: "+ob.getAid());

		 System.out.println("Account Holder: "+ob.getAccountholder());
		 System.out.println("Mobile Number: "+ob.getMobile());
		 System.out.println("Balance is => "+ob.getBalance());
		 System.out.println("========================================");
		 
	 }

	public void setAccountDAO(AccountDAOImpl mockDAO) {
		// TODO Auto-generated method stub
		this.a = mockDAO;
		
	}

}
