package de.hfu;

import java.util.*;
import org.junit.*;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.easymock.EasyMock.*;

/**
 * The Class ResidentMockTest.
 */
public class ResidentMockTest {
	
	List<Resident> residentList = new ArrayList<Resident>();
    Resident filter = new Resident();
    Resident r1 = new Resident("Max", "Mustermann", "Musterstraße1", "Musterstadt", new Date());
	Resident r2 = new Resident("Max1", "Mustermann", "Musterstraße12", "Musterstadt4", new Date());
	Resident r3 = new Resident("Max2", "Mustermann", "Musterstraße1232", "Musterstadt99", new Date());

    @Before
    public void init() {
        residentList.add(r1);
        residentList.add(r2);
        residentList.add(r3);
    		
    }

    /**
     * Test get unique resident.
     *
     * @throws ResidentServiceException the resident service exception
     */
    @Test
    public void testGetUniqueResident() throws ResidentServiceException {
        ResidentRepository residentRepositoryMock = createMock(ResidentRepository.class);

        BaseResidentService bRService = new BaseResidentService();
bRService.setResidentRepository(residentRepositoryMock);

        expect(residentRepositoryMock.getResidents()).andReturn(residentList);
        replay(residentRepositoryMock);


        Resident result = bRService.getUniqueResident(r2);
        verify(residentRepositoryMock);
        assertThat(result, equalTo(r2));
        
        
       
        
        
        
    }

    /**
     * Test get filtered residents list.
     */
    @Test
    public void testGetFilteredResidentsList() {
        ResidentRepository residentRepositoryMock = createMock(ResidentRepository.class);

        BaseResidentService bRService = new BaseResidentService();
        bRService.setResidentRepository(residentRepositoryMock);

        expect(residentRepositoryMock.getResidents()).andReturn(residentList);
        replay(residentRepositoryMock);

        filter.setGivenName("Ma*");        
        List<Resident> foundResidents = bRService.getFilteredResidentsList(filter);

        verify(residentRepositoryMock);

        assertThat(foundResidents.size(), equalTo(3));
    }
}
