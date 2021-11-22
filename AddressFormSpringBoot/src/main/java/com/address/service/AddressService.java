package com.address.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.address.exception.RecordNotFoundException;
import com.address.model.AddressEntity;
import com.address.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository repository;
	
	public List<AddressEntity> getAllAdresses()
	{
		List<AddressEntity> result = (List<AddressEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<AddressEntity>();
		}
	}
	
	public AddressEntity getAddressById(Long id) throws RecordNotFoundException 
	{
		Optional<AddressEntity> address = repository.findById(id);
		
		if(address.isPresent()) {
			return address.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
	
	public AddressEntity createOrUpdateAddress(AddressEntity entity) 
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<AddressEntity> adds = repository.findById(entity.getId());
			
			if(adds.isPresent()) 
			{
				AddressEntity newEntity = adds.get();
				newEntity.setName(entity.getName());
				newEntity.setDoorNo(entity.getDoorNo());
				newEntity.setCity(entity.getCity());
				newEntity.setPinCode(entity.getPinCode());
				
				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	}
	

  public void deleteAddressById(Long id) throws RecordNotFoundException {
  Optional<AddressEntity> employee = repository.findById(id);
  
  if(employee.isPresent()) { repository.deleteById(id); } else { throw new
  RecordNotFoundException("No employee record exist for given id"); 
  } 
  }
  

}
 