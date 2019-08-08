package com.cg.service;

import java.util.List;
import java.util.Map;

import com.cg.bean.Account;
import com.cg.exception.InsufficientBalanceException;

public interface AccountService {

	public boolean addAccount(Account ob);
	public boolean updateAccount(Account acc, String name);
	public boolean deleteAccount(Account ob);
	public boolean transferMoney(Account from, Account to,Double amount)throws InsufficientBalanceException;
	public Account findAccount(Long mo);
	public List<Account> getAllAccount();
	public boolean deposit(Account  ac, Double amount);
	public boolean withdraw(Account  ac, Double amount)throws InsufficientBalanceException;
	public  void printStatement(Account ac);


}
