package shinhan.hackathon.ssyrial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinhan.hackathon.ssyrial.model.ApiResponse;
import shinhan.hackathon.ssyrial.model.bank.InquireBankCodes;
import shinhan.hackathon.ssyrial.service.BankService;

/**
 * BankController 클래스는 은행 코드 조회 API 요청을 처리하는 REST 컨트롤러입니다.
 * /api/bank 경로로 들어오는 요청을 처리하며, 은행 코드 조회 API에 대한 요청을 처리합니다.
 */
@RestController
@RequestMapping("/api/bank")
public class BankController {

  private final BankService bankService;

  /**
   * BankController 생성자
   * BankService 인스턴스를 주입받아 사용합니다.
   *
   * @param bankService - 은행 코드 조회 관련 비즈니스 로직을 처리하는 서비스
   */
  public BankController(BankService bankService) {
    this.bankService = bankService;
  }

  /**
   * /inquireBankCodes 엔드포인트에 대한 POST 요청을 처리하는 메서드입니다.
   * 은행 코드 조회 API를 호출하고, 그 결과를 클라이언트에게 응답으로 반환합니다.
   *
   * @return ResponseEntity<ApiResponse<InquireBankCodes.Response>> - 은행 코드 조회 응답
   *         데이터를 담은 ApiResponse를 반환합니다.
   */
  @PostMapping("/inquireBankCodes")
  public ResponseEntity<ApiResponse<InquireBankCodes.Response>> inquireBankCodes() {
    // 은행 코드 조회 서비스 호출
    InquireBankCodes.Response response = bankService.inquireBankCodes();

    // 응답을 성공 상태로 반환
    return ResponseEntity.ok(ApiResponse.success(response));
  }
}
