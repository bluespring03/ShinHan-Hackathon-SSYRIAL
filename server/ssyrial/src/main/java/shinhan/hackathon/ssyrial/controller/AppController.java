package shinhan.hackathon.ssyrial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import shinhan.hackathon.ssyrial.model.ApiResponse;
import shinhan.hackathon.ssyrial.model.IssuedApiKeyModel;
import shinhan.hackathon.ssyrial.service.AppService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/app")
public class AppController {
  private final AppService appService;

  @PostMapping("/getApiKey")
  public ResponseEntity<ApiResponse<IssuedApiKeyModel.Response>> getApiKey(
      @RequestBody IssuedApiKeyModel.Request request) {
    IssuedApiKeyModel.Response response = appService.getIssuedApiKey(request);
    return ResponseEntity.ok(ApiResponse.success(response));
  }
}
