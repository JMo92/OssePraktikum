/**
 * 
 */
package de.hfu;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepositoryStub;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

/**
 * @author uic31018
 *
 */
public class ResidentTest {

	
	
	public ResidentTest() {
		
	}
	@Test
	public void uniqueResidentTest() {
		Resident r1 = new Resident("Max", "Mustermann", "Musterstraße1", "Musterstadt", new Date());
		Resident r2 = new Resident("Max1", "Mustermann", "Musterstraße12", "Musterstadt4", new Date());
		Resident r3 = new Resident("Max2", "Mustermann", "Musterstraße1232", "Musterstadt99", new Date());
		
		List<Resident> residentList = new ArrayList<Resident>();
		residentList.add(r1);
		residentList.add(r2);
		residentList.add(r3);
		
		BaseResidentService brService = new BaseResidentService();
		ResidentRepositoryStub stub = new ResidentRepositoryStub(residentList);
		brService.setResidentRepository(stub);
		
		try {
			assert(brService.getUniqueResident(r3).equals(r3));
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assert(brService.getUniqueResident(r2).equals(r2));
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assert(!brService.getUniqueResident(r1).equals(r3));
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		//fail("Not yet implemented");
	}
	@Test
	public void getFilteredResidentListTest() {
		Resident r1 = new Resident("Max", "Mustermann", "Musterstraße1", "Musterstadt", new Date());
		Resident r2 = new Resident("Max1", "Mustermann", "Musterstraße12", "Musterstadt4", new Date());
		Resident r3 = new Resident("Max2", "Mustermann", "Musterstraße1232", "Musterstadt99", new Date());
		
		List<Resident> residentList = new ArrayList<Resident>();
		residentList.add(r1);
		residentList.add(r2);
		residentList.add(r3);
		
		BaseResidentService brService = new BaseResidentService();
		ResidentRepositoryStub stub = new ResidentRepositoryStub(residentList);
		brService.setResidentRepository(stub);
		
		List<Resident> filteredList = brService.getFilteredResidentsList(new Resident("NotInTheList", "ReallyNotInTheList", "Musterstraße", "Musterstadt", new Date()));
		assert(filteredList.isEmpty());
		//wildcards
		
		assert(brService.getFilteredResidentsList(new Resident("Ma*", "Mustermann", "Musterstraße*", "Musterstad*", new Date())).equals(residentList));
		assert(!brService.getFilteredResidentsList(new Resident("Ma*", "Mustermann", "Musterstraße", "Musterstadt", new Date())).equals(residentList));
				
		
	}
	@Test
	public void uniqueResidentExceptionTest() throws ResidentServiceException{
		Resident r1 = new Resident("Max", "Mustermann", "Musterstraße1", "Musterstadt", new Date());
		List<Resident> residentList = new ArrayList<Resident>();
		residentList.add(r1);

		BaseResidentService brService = new BaseResidentService();
		ResidentRepositoryStub stub = new ResidentRepositoryStub(residentList);
		brService.setResidentRepository(stub);
		try {
			brService.getUniqueResident(new Resident("Ma*", "Mustermann", "Musterstraße1", "Musterstadt", new Date()));
			fail();
		} catch(ResidentServiceException e) {};
		
	}

}
