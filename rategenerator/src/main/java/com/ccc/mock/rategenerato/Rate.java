package com.ccc.mock.rategenerato;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rate {
    private String currencyPair;
    private String tenor;
    private LocalDate SettlementDate;
    private Double ask;
    private Double mid;
    private Double bid;
    private LocalDateTime timeStamp;

}
