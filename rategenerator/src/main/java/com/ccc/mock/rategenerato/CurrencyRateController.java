package com.ccc.mock.rategenerato;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/currency")
public class CurrencyRateController {
    static List<RateMock> mocksWithCriteria = List.of(
            new RateMock("USDJPY",147.699,-0.05,-0.067,147.707,147.714,148.167,147.625),
            new RateMock("GBPUSD",1.2387,-0.04,-0.0005,1.2388,1.2389,1.2410,1.2334),
            new RateMock("AUDUSD",0.64994,0.71,0.00461,0.64992,0.65001,0.65050,0.64483),
            new RateMock("USDCAD",1.34214,-0.18,-0.00247,1.34189,1.34197,1.34646,1.33958),
            new RateMock("USDCHF",0.89498,-0.23,-0.00204,0.89494,0.89514,0.89841,0.89393),
            new RateMock("NZDUSD",0.59753,0.69,0.00411,0.59757,0.59762,0.59793,0.59329)
            );
    static List<TenorModel> tenorModels = List.of(
            new TenorModel("ON",0),
            new TenorModel("TN",1),
            new TenorModel("SP",2),
            new TenorModel("1W",7),
            new TenorModel("3W",21),
            new TenorModel("1M",30),
            new TenorModel("2M",60),
            new TenorModel("3M",90),
            new TenorModel("6M",180),
            new TenorModel("1Y",365),
            new TenorModel("3Y",365*3),
            new TenorModel("5Y",365*5)
            );

    @GetMapping("/exchange-rate")
    public List<Rate> getExchangeRate() {
        final LocalDateTime timestamp= LocalDateTime.now();
        // Mock currency rate data
        List<Rate> exchangeRates = mocksWithCriteria.stream()
                .flatMap(
                        rateMock->tenorModels.stream()
                                .map(tenor->new Rate(rateMock.getSymbol(),
                                        tenor.getTenor(),
                                        LocalDate.now().plusDays(tenor.getDays()),
                                        rateMock.getAsk()+rateMock.getAsk()* rateMock.getCHANGE()*tenor.getDays(),
                                        rateMock.getAsk()+rateMock.getAsk()* rateMock.getCHANGE()*tenor.getDays(),
                                        rateMock.getBid()+rateMock.getBid()* rateMock.getCHANGE()*tenor.getDays(),
                                        timestamp)))
                .collect(Collectors.toList());
        return exchangeRates;
    }
}
