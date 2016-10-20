import static org.junit.Assert.*;

import org.cap.dao.AccountDao;
import org.cap.dto.Account;
import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InsufficientBalanceException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import junit.framework.Assert;

public class withdrawal {

	
	
	private AcccountService accService;
	
	@Mock
	private AccountDao accountdao;
	
	@Before
	public void beforeMethod(){
		
		MockitoAnnotations.initMocks(this);
		accService=new AccountServiceImpl(accountdao);
	}
	 
	@Test
	   public void test_withdrawal_method() throws InsufficientBalanceException{
	     
	Account account=new Account();
	account.setAccountNo(1001);
	account.setAmount(2000);
	Customer customer=new Customer();
	customer.setCustAddress(new Address());

	customer.setCustName("jack");
	account.setCustomer(customer);
	
	//declaration
	Mockito.when(accountdao.findAccountById(1001)).thenReturn(account);
	//actual logic businesws
	Account account2=accService.withdraw(1001,500);
	
	Mockito.verify(accountdao).findAccountById(1001);
	assertEquals(1500,account2.getAmount(),0.0);

	
	
	}

}
