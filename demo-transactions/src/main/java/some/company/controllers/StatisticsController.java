package some.company.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import some.company.model.StatisticsEntity;
import some.company.service.TransactionsService;
import some.company.utils.ConversionUtils;

@Slf4j
@RestController("/statistics")
public class StatisticsController {

    private final TransactionsService transactionsService;

    @Autowired
    public StatisticsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping
    public ResponseEntity<?> getStatistics() {
        final StatisticsEntity statisticsEntity = transactionsService.getStatistics();
        log.info("Retrieving statistics: {}", statisticsEntity);

        return ResponseEntity
            .ok()
            .body(ConversionUtils.convertStatisticsEntityToDto(statisticsEntity));
    }

}
