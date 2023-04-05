package com.minsait.financial.repositories;

import com.minsait.financial.models.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LoanModel, Long> {
}
