package shinhan.hackathon.ssyrial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinhan.hackathon.ssyrial.model.ApiResponse;
import shinhan.hackathon.ssyrial.model.demandDeposit.InquireDemandDepositListModel;
import shinhan.hackathon.ssyrial.service.DemandDepositService;

/**
 * DemandDepositController 클래스는 수시입출금 상품 관련 API 요청을 처리하는 컨트롤러 클래스입니다.
 * 이 클래스는 수시입출금 상품 목록 조회 요청을 처리합니다.
 */
@RestController
@RequestMapping("/api/demandDeposit")
public class DemandDepositController {

  private final DemandDepositService demandDepositService;

  /**
   * DemandDepositController의 생성자. DemandDepositService를 주입받습니다.
   * 
   * @param demandDepositService 수시입출금 상품 관련 비즈니스 로직을 처리하는 서비스 클래스
   */
  public DemandDepositController(DemandDepositService demandDepositService) {
    this.demandDepositService = demandDepositService;
  }

  /**
   * 수시입출금 상품 목록 조회 요청을 처리하는 엔드포인트입니다.
   * 
   * 클라이언트로부터 수시입출금 상품 목록 조회 요청을 받아 처리하고, 해당 목록 정보를 반환합니다.
   * 
   * @return ResponseEntity<ApiResponse<InquireDemandDepositListModel.Response>> -
   *         조회된
   *         수시입출금 상품 목록 정보 응답
   */
  @PostMapping("/inquireDemandDepositList")
  public ResponseEntity<ApiResponse<InquireDemandDepositListModel.Response>> inquireDemandDepositList() {
    InquireDemandDepositListModel.Response response = demandDepositService.inquireDemandDepositList();
    return ResponseEntity.ok(ApiResponse.success(response));
  }
}
