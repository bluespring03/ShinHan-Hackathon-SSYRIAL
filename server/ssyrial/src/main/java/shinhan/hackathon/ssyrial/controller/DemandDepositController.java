package shinhan.hackathon.ssyrial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinhan.hackathon.ssyrial.model.ApiResponse;
import shinhan.hackathon.ssyrial.model.demandDeposit.CreateDemandDepositAccountModel;
import shinhan.hackathon.ssyrial.model.demandDeposit.CreateDemandDepositModel;
import shinhan.hackathon.ssyrial.model.demandDeposit.InquireDemandDepositListModel;
import shinhan.hackathon.ssyrial.service.DemandDepositService;

/**
 * DemandDepositController 클래스는 수시입출금 상품과 관련된 요청을 처리하는 컨트롤러입니다.
 *
 * 이 클래스는 수시입출금 상품과 관련된 기능에 대한 엔드포인트를 제공합니다.
 * - /api/demandDeposit/inquireDemandDepositList: 수시입출금 상품 목록 조회 요청을 처리합니다.
 * - /api/demandDeposit/createDemandDepositAccount: 수시입출금 계좌 생성 요청을 처리합니다.
 * - /api/demandDeposit/createDemandDeposit: 수시입출금 상품 등록 요청을 처리합니다.
 */
@RestController
@RequestMapping("/api/demandDeposit")
public class DemandDepositController extends BaseController {

  private final DemandDepositService demandDepositService;

  /**
   * DemandDepositController 생성자.
   * 
   * @param demandDepositService 수시입출금 상품 관련 비즈니스 로직을 처리하는 서비스 클래스
   */
  public DemandDepositController(DemandDepositService demandDepositService) {
    this.demandDepositService = demandDepositService;
  }

  /**
   * /createDemandDeposit 엔드포인트로 들어오는 수시입출금 상품 등록 요청을 처리합니다.
   * 
   * 이 메서드는 클라이언트로부터 수시입출금 상품 등록 요청을 받아서 처리한 후,
   * 등록된 상품 정보를 반환합니다.
   *
   * @param request CreateDemandDepositModel.Request - 상품 등록 요청 데이터
   * @return ResponseEntity<ApiResponse<CreateDemandDepositModel.Response>> - 등록된
   *         상품 정보가 담긴 응답
   */
  @PostMapping("/createDemandDeposit")
  public ResponseEntity<ApiResponse<CreateDemandDepositModel.Response>> createDemandDeposit(
      @RequestBody CreateDemandDepositModel.Request request) {
    CreateDemandDepositModel.Response response = demandDepositService.createDemandDeposit(
        request.getBankCode(), request.getAccountName(), request.getAccountDescription());
    return successResponse(response);
  }

  /**
   * /inquireDemandDepositList 엔드포인트로 들어오는 수시입출금 상품 목록 조회 요청을 처리합니다.
   * 
   * 이 메서드는 클라이언트로부터 수시입출금 상품 목록 조회 요청을 받아서 처리한 후,
   * 조회된 상품 목록 정보를 반환합니다.
   *
   * @return ResponseEntity<ApiResponse<InquireDemandDepositListModel.Response>> -
   *         상품 목록 정보가 담긴 응답
   */
  @PostMapping("/inquireDemandDepositList")
  public ResponseEntity<ApiResponse<InquireDemandDepositListModel.Response>> inquireDemandDepositList() {
    InquireDemandDepositListModel.Response response = demandDepositService.inquireDemandDepositList();
    return successResponse(response);
  }

  /**
   * /createDemandDepositAccount 엔드포인트로 들어오는 수시입출금 계좌 생성 요청을 처리합니다.
   * 
   * 이 메서드는 클라이언트로부터 계좌 생성 요청을 받아서 처리한 후,
   * 생성된 계좌 정보를 반환합니다.
   *
   * @param request CreateDemandDepositAccountModel.Request - 계좌 생성 요청 데이터
   * @return ResponseEntity<ApiResponse<CreateDemandDepositAccountModel.Response>>
   *         - 생성된 계좌 정보가 담긴 응답
   */
  @PostMapping("/createDemandDepositAccount")
  public ResponseEntity<ApiResponse<CreateDemandDepositAccountModel.Response>> createDemandDepositAccount(
      @RequestBody CreateDemandDepositAccountModel.Request request) {
    CreateDemandDepositAccountModel.Response response = demandDepositService.createDemandDepositAccount(
        request.getUserKey(), request.getAccountTypeUniqueNo());
    return successResponse(response);
  }
}
