package com.example.servies;

import com.example.dtos.SupplierDTO;
import com.example.entities.Supplier;
import com.example.exceptions.SupplierException;
import com.example.repositories.SupplierRepository;
import com.example.utils.UNIQUE_KEYS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Service
@Slf4j
public class SupplierService {

    @Autowired
    private UniqueKeyService uniqueKeyService;

    @Autowired
    private SupplierRepository supplierRepository;

    @Transactional
    public SupplierDTO create(SupplierDTO dto) {
        log.info("Creating Suppliers..........");
        try {
            String nexCode = uniqueKeyService.getNexCode(UNIQUE_KEYS.SUPPLIER_REQ.getKey());
            Supplier entity = dto.getEntity();
            entity.setRegNumber(nexCode);
//            entity.setRegDate(LocalDate.now());
           return supplierRepository.save(entity).getDto();
        }catch (Exception e){
            e.printStackTrace();
            throw new SupplierException("Supplier account cannot create");
        }
    }

    public List<SupplierDTO> getAllSuppliers() {
        try {
            List<SupplierDTO> list = new ArrayList<>();
            supplierRepository.findAll().forEach(i->list.add(i.getDto()));
            return list;
        }catch (Exception e){
            throw new SupplierException("Can not get all supplier account.");
        }
    }

    @Transactional
    public SupplierDTO update(SupplierDTO dto) {

        log.info("Creating Suppliers..........");
        try {
            Supplier entity = dto.getEntity();
            return supplierRepository.save(entity).getDto();
        }catch (Exception e){
            e.printStackTrace();
            throw new SupplierException("Supplier account cannot create");
        }
    }
}
