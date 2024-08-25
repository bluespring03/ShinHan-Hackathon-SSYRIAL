package shinhan.hackathon.ssyrial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinhan.hackathon.ssyrial.model.ApiResponse;
import shinhan.hackathon.ssyrial.model.demandDeposit.CreateDemandDepositAccountModel;
import shinhan.hackathon.ssyrial.model.demandDeposit.InquireDemandDepositListModel;
import shinhan.hackathon.ssyrial.service.DemandDepositService;

/**
 * DemandDepositController 클래스는 수시입출금 상품 관련 API 요청을 처리하는 컨트롤러 클래스입니다.
 */
@RestController
@RequestMapping("/api/demandDeposit")
public class DemandDepositController {

  private static final Logger logger = LoggerFactory.getLogger(DemandDepositController.class);

  private final DemandDepositService demandDepositService;

  public DemandDepositController(DemandDepositService demandDepositService) {
    this.demandDepositService = demandDepositService;
  }

  /**
   * 수시입출금 상품 목록 조회 요청을 처리하는 엔드포인트입니다.
   */
  @PostMapping("/inquireDemandDepositList")
  public ResponseEntity<ApiResponse<InquireDemandDepositListModel.Response>> inquireDemandDepositList() {
    logger.info("Received request for inquireDemandDepositList");

    InquireDemandDepositListModel.Response response = demandDepositService.inquireDemandDepositList();

    logger.info("Responding with data: {}", response);

    return ResponseEntity.ok(ApiResponse.success(response));
  }

  /**
   * 계좌 생성 요청을 처리하는 엔드포인트입니다.
   */
  @PostMapping("/createDemandDepositAccount")
  public ResponseEntity<ApiResponse<CreateDemandDepositAccountModel.Response>> createDemandDepositAccount(
      @RequestBody CreateDemandDepositAccountModel.Request request) {
    logger.info("Received request to createDemandDepositAccount with userKey: {} and accountTypeUniqueNo: {}",
        request.getUserKey(), request.getAccountTypeUniqueNo());

    CreateDemandDepositAccountModel.Response response = demandDepositService.createDemandDepositAccount(
        request.getUserKey(), request.getAccountTypeUniqueNo());

    logger.info("Responding with created account data: {}", response);

    return ResponseEntity.ok(ApiResponse.success(response));
  }
}
