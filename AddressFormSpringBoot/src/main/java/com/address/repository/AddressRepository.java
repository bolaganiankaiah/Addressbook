package com.address.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.address.model.AddressEntity;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity,Long>
{

}
