package com.cg.dao;
import java.util.List;

import com.cg.bean.*;
import com.cg.exception.InsufficientBalanceException;
public interface AccountDAO {
	
	public boolean addAccount(Account ob);
	public boolean updateAccount(Account ob);
	public boolean deleteAccount(Account ob);
	public boolean transferMoney(Account from, Account to,Double amount) throws InsufficientBalanceException;
	public Account findAccount(Long mo);
	public List<Account> getAllAccount();
	public boolean deposit(Account  ac, Double amount);
	public boolean withdraw(Account  ac, Double amount) throws InsufficientBalanceException;
}
