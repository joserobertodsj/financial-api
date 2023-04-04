package com.minsait.financial.repositories;

import com.minsait.financial.models.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
    Optional<CustomerModel>  findByDocumentNumber(String documentNumber);
    void deleteByDocumentNumber(String documentNumber);

}
