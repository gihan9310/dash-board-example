package com.example.servies;

import com.example.entities.UniqueKey;
import com.example.repositories.UniqueKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Service
public class UniqueKeyService {

    @Autowired
    private UniqueKeyRepository uniqueKeyRepository;

    public String getNexCode(String serchKey){
        Optional<UniqueKey> isPersent = uniqueKeyRepository.findBySearchKey(serchKey);
        UniqueKey key =null;
        if(isPersent.isPresent()){
            key = isPersent.get();
        }else {
            key =saveKey(serchKey);
        }
        String keyCode =key.getPerfix()+"-"+key.getNextNumber();
        key.setNextNumber(key.getNextNumber()+1);
        return keyCode;
    }

    private UniqueKey saveKey(String key){
        UniqueKey uniqueKey = new UniqueKey();
        uniqueKey.setNextNumber(1l);
        uniqueKey.setSearchKey(key);
        uniqueKey.setPerfix(key);
       return uniqueKeyRepository.save(uniqueKey);
    }

}
