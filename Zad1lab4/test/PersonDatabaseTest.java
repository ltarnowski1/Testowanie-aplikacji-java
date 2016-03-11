import static org.junit.Assert.*;

import java.sql.SQLException;

import org.easymock.EasyMock;
import org.easymock.Mock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import EasyMockExample.Person;
import EasyMockExample.PersonDatabaseService;
import EasyMockExample.PersonException;
import EasyMockExample.PersonMockServiceImpl;

import static org.easymock.EasyMock.*;
public class PersonDatabaseTest {

	
	private PersonMockServiceImpl serv;
	private PersonDatabaseService mockService;
	private Person person, person1;
	
	@Before
	public void setUp() throws Exception {
		mockService = EasyMock.createMock(PersonDatabaseService.class);
		serv = new PersonMockServiceImpl();
		serv.setService(mockService);
		person = new Person(1, "Jan", "Kowalski", 2000);
	}

	@After
	public void tearDown() throws Exception {
		mockService = null;
		serv = null;
		person = null;
	}

	@Test
	public void AddPerson_ReturnTrue_Test() throws SQLException, PersonException {
		EasyMock.expect(mockService.AddPerson(person)).andReturn(1);
		EasyMock.replay(mockService);
		boolean result = serv.AddPerson(person);
		assertTrue(result);
		EasyMock.verify(mockService);
	}
	
	@Test(expected=PersonException.class)
	public void AddPerson_ThrowException_Test() throws SQLException, PersonException{
		EasyMock.expect(mockService.AddPerson(person)).andThrow(new SQLException());
		EasyMock.replay(mockService);
		boolean result = serv.AddPerson(person);
		assertTrue(result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void AddPerson_ReturnFalse_Test() throws SQLException, PersonException {
		EasyMock.expect(mockService.AddPerson(person)).andReturn(0);
		EasyMock.replay(mockService);
		boolean result = serv.AddPerson(person);
		assertFalse(result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void removeTest() throws SQLException, PersonException {
		EasyMock.expect(mockService.remove(person.getId())).andReturn(1);
		EasyMock.replay(mockService);
		boolean result = serv.remove(person.getId());
		assertTrue(result);
		EasyMock.verify(mockService);
	}
	
	@Test(expected=PersonException.class)
	public void removeExceptionTest() throws SQLException, PersonException{
		EasyMock.expect(mockService.remove(person.getId())).andThrow(new SQLException());
		EasyMock.replay(mockService);
		boolean result = serv.remove(person.getId());
		assertTrue(result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void remove_ReturnFalse_Test() throws SQLException, PersonException {
		EasyMock.expect(mockService.remove(person.getId())).andReturn(0);
		EasyMock.replay(mockService);
		boolean result = serv.remove(person.getId());
		assertFalse(result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void read_ReturnTrue_Test() throws SQLException, PersonException {
		EasyMock.expect(mockService.read(person.getId())).andReturn(person);
		EasyMock.replay(mockService);
		boolean result = serv.read(1);
		assertTrue(result);
		EasyMock.verify(mockService);
	}
	
	@Test(expected=PersonException.class)
	public void read_ThrowException_Test() throws SQLException, PersonException{
		EasyMock.expect(mockService.read(person.getId())).andThrow(new SQLException());
		EasyMock.replay(mockService);
		boolean result = serv.read(1);
		assertTrue(result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void read_ReturnFalse_Test() throws SQLException, PersonException {
		EasyMock.expect(mockService.read(person.getId())).andReturn(null);
		EasyMock.replay(mockService);
		boolean result = serv.read(person.getId());
		assertFalse(result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void update_ReturnTrue_Test() throws SQLException, PersonException {
		EasyMock.expect(mockService.update(person.getId())).andReturn(1);
		EasyMock.replay(mockService);
		boolean result = serv.update(1);
		assertTrue(result);
		EasyMock.verify(mockService);
	}
	
	@Test(expected=PersonException.class)
	public void update_ThrowException_Test() throws SQLException, PersonException{
		EasyMock.expect(mockService.update(person.getId())).andThrow(new SQLException());
		EasyMock.replay(mockService);
		boolean result = serv.update(1);
		assertTrue(result);
		EasyMock.verify(mockService);
	}
	
	@Test
	public void update_ReturnFalse_Test() throws SQLException, PersonException {
		EasyMock.expect(mockService.update(person.getId())).andReturn(0);
		EasyMock.replay(mockService);
		boolean result = serv.update(person.getId());
		assertFalse(result);
		EasyMock.verify(mockService);
	}

}
