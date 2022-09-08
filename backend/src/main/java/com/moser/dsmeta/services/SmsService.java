package com.moser.dsmeta.services;

import com.moser.dsmeta.entities.Sale;
import com.moser.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

/**
 * @author Juliano Moser
 */
@Slf4j
@Service
public class SmsService {

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    @Autowired
    private SaleRepository saleRepository;

    public void sendSms(Long saleId) {

        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, getMessage(saleId)).create();

        log.info("Sid {}", message.getSid());
    }

    private String getMessage(Long saleId) {

        Sale sale = saleRepository.findById(saleId).get();

        String date = sale.getDate().format(DateTimeFormatter.ofPattern("dd/MM"));

        return "O vendedor " +
                sale.getSellerName() +
                " foi destaque em " +
                date +
                " com um total de R$ " + String.format("%.2f", sale.getAmount());
    }
}
