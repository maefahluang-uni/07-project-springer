package lab.microservice.currencyconversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private CurrencyExchangeServiceProxy proxy;

  @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
      @PathVariable double quantity) {

    ResponseEntity<CurrencyConversionBean> responseEntity = proxy.retrieveExchangeValue(from, to);
    logger.info("Response from forex-service: {}", responseEntity);

    CurrencyConversionBean currencyRate = responseEntity.getBody();

    double conversionMultiple = currencyRate.getConversionMultiple();
    double totalCalculatedAmount = quantity * conversionMultiple;

    CurrencyConversionBean response = new CurrencyConversionBean(from, to, conversionMultiple, quantity,
        totalCalculatedAmount, currencyRate.getPort());

    return response;
  }
}
