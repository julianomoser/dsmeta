package com.moser.dsmeta.repositories;

import com.moser.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Juliano Moser
 */
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
