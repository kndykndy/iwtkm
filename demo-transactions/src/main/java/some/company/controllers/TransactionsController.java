package some.company.controllers;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import some.company.model.TransactionEntity;
import some.company.service.TransactionsService;
import some.company.utils.ConversionUtils;

@Slf4j
@RestController("/transactions")
public class TransactionsController {

    private final TransactionsService transactionsService;

    @Autowired
    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> processTransaction(
        @Valid @RequestBody TransactionEntity.Dto transactionEntityDto) {

        transactionsService.processTransaction(
            ConversionUtils.convertTransactionEntityDtoToEntity(transactionEntityDto));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllTransactions() {
        transactionsService.deleteAllTransactions();

        log.info("Deleting all transactions.");

        return ResponseEntity.noContent().build();
    }

}
