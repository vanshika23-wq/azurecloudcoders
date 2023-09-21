package com.ccc.mock.rategenerato;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RateMock {
   private String symbol;
   private Double price;
   private Double perChange;
   private Double CHANGE;
   private Double bid;
   private Double ask;
   private Double high;
   private Double low;
}
