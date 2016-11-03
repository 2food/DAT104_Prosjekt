package no.hib.dat104.project.tests;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import no.hib.dat104.project.model.User;
import no.hib.dat104.project.model.UserEAO;

/*
 * Tester UserEAO
 * @author Tormod
 */
public class UserEAOTest {
	
	@EJB
	private UserEAO ueao;
	static EJBContainer container;
	
	User d;	
	
	@BeforeClass
	public static void start() {
	    container = EJBContainer.createEJBContainer();
	}
	 
	@Before
	public void inject() throws NamingException {
	    container.getContext().bind("inject", this);
	    d = new User();
	    d.setUser_name("testusmaximus");
		d.setUser_password("testolini");
	}
	 
	@AfterClass
	public static void stop() {
	    container.close();
	}
	
	@Test 
	public void isOpenTest(){
		assertTrue(ueao.isOpen());
	}

	@Test
	public void findUserIdTest() {
		assertTrue(ueao.findUser(new Integer(10)).getUser_name().equals("admin"));
	}
	
	@Test
	public void FindUserNameTest() {
		assertTrue(ueao.findUser("admin").getUid() == 10);
	}
	
	@Test
	public void addRemoveUserTest() {
		ueao.addUser(d);
		assertTrue(ueao.findUser("testusmaximus").getUid() == d.getUid());
		ueao.removeUser(ueao.findUser("testusmaximus").getUid());
		assertNull(ueao.findUser("testusmaximus"));
	}

	@Test
	public void updateUsersTest() {
		ueao.updateUser(ueao.findUser("testusmaximus"));
	}

}
