package de.hfu.residents.repository;

import java.util.List;

import de.hfu.residents.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository{

	List<Resident> residentsList;
	public ResidentRepositoryStub(List<Resident> residents) {
		this.residentsList = residents;
	}
	@Override
	public List<Resident> getResidents() {
		// TODO Auto-generated method stub
		return residentsList;
	}

}
