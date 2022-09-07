package com.moser.dsmeta.controllers;

import com.moser.dsmeta.entities.Sale;
import com.moser.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Juliano Moser
 */
@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<Sale> findSales() {
        return saleService.findSales();
    }
}
