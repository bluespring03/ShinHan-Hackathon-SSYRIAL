package shinhan.hackathon.ssyrial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shinhan.hackathon.ssyrial.model.ApiResponse;
import shinhan.hackathon.ssyrial.model.member.MemberModel;
import shinhan.hackathon.ssyrial.model.member.MemberSearchModel;
import shinhan.hackathon.ssyrial.service.MemberService;

@RestController
@RequestMapping("/api/member")
public class MemberController {

  private final MemberService memberService;

  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @PostMapping("/")
  public ResponseEntity<ApiResponse<MemberModel.Response>> createMember(
      @RequestBody MemberModel.Request request) {
    MemberModel.Response response = memberService.createMember(request);
    return ResponseEntity.ok(ApiResponse.success(response));
  }

  @PostMapping("/search")
  public ResponseEntity<ApiResponse<MemberSearchModel.Response>> searchMember(
      @RequestBody MemberSearchModel.Request request) {
    MemberSearchModel.Response response = memberService.searchMember(request);
    return ResponseEntity.ok(ApiResponse.success(response));
  }
}
