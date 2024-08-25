package shinhan.hackathon.ssyrial.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shinhan.hackathon.ssyrial.model.member.MemberModel;
import shinhan.hackathon.ssyrial.model.member.MemberSearchModel;

@Service
public class MemberService extends ShinhanApiService {

  private final String apiKey;

  public MemberService(RestTemplate restTemplate, String apiKey) {
    super(restTemplate);
    this.apiKey = apiKey;
  }

  public MemberModel.Response createMember(MemberModel.Request request) {
    request.setApiKey(apiKey);
    return sendRequest("/member/", HttpMethod.POST, request, MemberModel.Response.class);
  }

  public MemberSearchModel.Response searchMember(MemberSearchModel.Request request) {
    request.setApiKey(apiKey);
    return sendRequest("/member/search", HttpMethod.POST, request, MemberSearchModel.Response.class);
  }
}
