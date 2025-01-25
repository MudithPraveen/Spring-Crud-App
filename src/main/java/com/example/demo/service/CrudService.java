package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.CrudEntity;
import com.example.demo.repository.CrudRepo;

@Service
public class CrudService {
	
	@Autowired
	CrudRepo crudRepo;

	public void save(CrudEntity item) {
		crudRepo.save(item);
	}

	public List<CrudEntity> get() {
		return crudRepo.findAll();
	}

}
