package shinhan.hackathon.ssyrial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinhan.hackathon.ssyrial.model.ApiResponse;
import shinhan.hackathon.ssyrial.model.member.MemberModel;
import shinhan.hackathon.ssyrial.model.member.MemberSearchModel;
import shinhan.hackathon.ssyrial.service.MemberService;

/**
 * MemberController 클래스는 회원 관련 API 요청을 처리하는 컨트롤러 클래스입니다.
 * 이 클래스는 사용자 등록 및 사용자 검색 요청을 처리합니다.
 */
@RestController
@RequestMapping("/api/member")
public class MemberController {

  private final MemberService memberService;

  /**
   * MemberController의 생성자. MemberService를 주입받습니다.
   * 
   * @param memberService 회원 관련 비즈니스 로직을 처리하는 서비스 클래스
   */
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  /**
   * 사용자 등록(회원가입) 요청을 처리하는 엔드포인트입니다.
   * 
   * @param request MemberModel.Request - 사용자 등록 요청 데이터
   * @return ResponseEntity<ApiResponse<MemberModel.Response>> - 등록된 사용자 정보 응답
   */
  @PostMapping("/")
  public ResponseEntity<ApiResponse<MemberModel.Response>> createMember(
      @RequestBody MemberModel.Request request) {
    MemberModel.Response response = memberService.createMember(request);
    return ResponseEntity.ok(ApiResponse.success(response));
  }

  /**
   * 사용자 검색 요청을 처리하는 엔드포인트입니다.
   * 
   * @param request MemberSearchModel.Request - 사용자 검색 요청 데이터
   * @return ResponseEntity<ApiResponse<MemberSearchModel.Response>> - 검색된 사용자 정보
   *         응답
   */
  @PostMapping("/search")
  public ResponseEntity<ApiResponse<MemberSearchModel.Response>> searchMember(
      @RequestBody MemberSearchModel.Request request) {
    MemberSearchModel.Response response = memberService.searchMember(request);
    return ResponseEntity.ok(ApiResponse.success(response));
  }
}
