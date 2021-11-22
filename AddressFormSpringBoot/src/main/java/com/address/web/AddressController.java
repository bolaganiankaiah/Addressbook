package com.address.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.address.exception.RecordNotFoundException;
import com.address.model.AddressEntity;
import com.address.service.AddressService;



	@Controller
	@RequestMapping("/")
	public class AddressController 
	{
		@Autowired
		AddressService service;

		@RequestMapping
		public String getAllAddress(Model model) 
		{
			List<AddressEntity> list = service.getAllAdresses();

			model.addAttribute("addresses", list);
			return "list-address";
		}

		@RequestMapping(path = {"/edit", "/edit/{id}"})
		public String editAddressId(Model model, @PathVariable("id") Optional<Long> id) 
								throws RecordNotFoundException 
		{
			if (id.isPresent()) {
				AddressEntity entity = service.getAddressById(id.get());
				model.addAttribute("address", entity);
			} else {
				model.addAttribute("address", new AddressEntity());
			}
			return "add-edit-address";
		}
		
		  @RequestMapping(path = "/delete/{id}") public String deleteAddressById(Model
		  model, @PathVariable("id") Long id) throws RecordNotFoundException {
		  service.deleteAddressById(id); return "redirect:/"; }
		 

		@RequestMapping(path = "/createAddress", method = RequestMethod.POST)
		public String createOrUpdateAddress(AddressEntity address) 
		{
			service.createOrUpdateAddress(address);
			return "redirect:/";
		}
	}
