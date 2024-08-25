package shinhan.hackathon.ssyrial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinhan.hackathon.ssyrial.model.ApiResponse;
import shinhan.hackathon.ssyrial.model.bank.InquireBankCodes;
import shinhan.hackathon.ssyrial.service.BankService;

@RestController
@RequestMapping("/api/bank")
public class BankController {

  private final BankService bankService;

  public BankController(BankService bankService) {
    this.bankService = bankService;
  }

  @PostMapping("/inquireBankCodes")
  public ResponseEntity<ApiResponse<InquireBankCodes.Response>> inquireBankCodes() {
    InquireBankCodes.Response response = bankService.inquireBankCodes();
    return ResponseEntity.ok(ApiResponse.success(response));
  }
}
