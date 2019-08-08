package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.bean.Account;
import com.cg.exception.InsufficientBalanceException;


public class AccountDAOImpl implements AccountDAO {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em=emf.createEntityManager();
		public AccountDAOImpl() {
		
		}
		
	@Override
	public boolean addAccount(Account ob) {
		// TODO Auto-generated method stub
	
		try {
			em.getTransaction().begin();
			em.persist(ob);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}

	@Override
	public boolean updateAccount(Account ob) {
		// TODO Auto-generated method stub

		try {
			em.getTransaction().begin();
			em.merge(ob);
			//em.persist(ob);
			em.getTransaction().commit();
		}
		catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			
		return true;
	}

	@Override
	public boolean deleteAccount(Account ob) {
		// TODO Auto-generated method stub
		
		try {
			em.getTransaction().begin();
			em.remove(ob);
			//em.persist(ob);
			em.getTransaction().commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	@Override
	public Account findAccount(Long mo) {
		// TODO Auto-generated method stub
		Account acc;
		try {
			acc=em.find(Account.class, mo);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return acc;
	}


	@Override
	public boolean transferMoney(Account from, Account to, Double amount) throws InsufficientBalanceException {
		// TODO Auto-generated method stub
		Double bal1=from.getBalance();
			if(bal1-amount<1000.0)
			{
				throw new InsufficientBalanceException("Balance Below 1000 so Transaction Invalid ",bal1);
			}
			else
			{
				withdraw(from, amount);
				deposit(to, amount);
			}
		return true;
	}


	@Override
	public List<Account> getAllAccount() {
		try {
			Query query=em.createQuery("select m from Account m");
			List<Account> list = query.getResultList();
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
}

	@Override
	public boolean deposit(Account ac, Double amount) {
		
		try {
				ac.setBalance(ac.getBalance()+amount);
				em.getTransaction().begin();
				em.persist(ac);
				em.getTransaction().commit();
				System.out.println("Deposit Done");
			}
			
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean withdraw(Account ac, Double amount) throws InsufficientBalanceException {
		
			
			if((ac.getBalance()-amount)<1000)
				throw new InsufficientBalanceException("Balance Below 1000 so Transaction Invalid ",ac.getBalance());
			else
			{
			ac.setBalance(ac.getBalance()-amount);
			em.getTransaction().begin();
			em.persist(ac);
			em.getTransaction().commit();
			System.out.println("Withdraw Done");
			}
	
	return true;
	}



}
