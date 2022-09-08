package com.moser.dsmeta.controllers;

import com.moser.dsmeta.entities.Sale;
import com.moser.dsmeta.services.SaleService;
import com.moser.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * @author Juliano Moser
 */
@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Autowired
    private SmsService smsService;

    @GetMapping()
    public Page<Sale> findSales(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {

        return saleService.findSales(minDate, maxDate, pageable);
    }

    @GetMapping("/{saleId}/notification")
    public void notifySms(@PathVariable Long saleId) {
        smsService.sendSms(saleId);
    }
}
