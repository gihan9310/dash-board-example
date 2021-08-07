package com.example.repositories;

import com.example.entities.UniqueKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Repository
public interface UniqueKeyRepository extends JpaRepository<UniqueKey, Long> {
    Optional<UniqueKey> findBySearchKey(String search);
}
