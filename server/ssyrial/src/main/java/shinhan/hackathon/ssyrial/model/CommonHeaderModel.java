/*
2.3.1 공통 HEADER API (p.18)

설명
API 요청/응답시, BODY에 공통으로 사용하는 데이터
BODY 안에 HEADER라는 키로 들어가며, 공통부를 포함하여 API들이 요청, 응답값을 전송한다.

Request
*기관거래고유번호
새로운 번호로 임의 채번 (YYYYMMDD + HHMMSS + 일련번호 6자리) 또는 20자리의 난수
API 요청시 사용자가 항상 새로운 번호로 임의 채번해야함.
(예 : 2024021609000000000, 2024021609000000001)

apiName - API이름 - String - 길이30 - 필수Y - 호출API URI의 마지막 path명 ex) ssafy/api/v1/edu/account/inquireBankAccountTypes 호출 uri일 경우 => inquireBankAccountTypes
transmissionDate - 전송일자 - String - 길이8 - 필수Y - API 전송일자(YYYYMMDD) 요청일
transmissionTime - 전송시각 - String - 길이6 - 필수Y - API 전송시각(HHMMSS) 요청시간 기준 +-5분
institutionCode - 기관코드 - String - 길이5 - 필수Y - '00100'로 고정
fintechAppNo - 핀테크 앱 일련번호 - String - 길이3 - 필수Y - '001'로 고정
apiServiceCode - API서비스코드 - String - 길이30 - 필수Y - API 이름 필드와 동일
institutionTransactionUniqueNo - 기관거래고유번호 - String - 길이20 - 필수Y - 기관별 API 서비스 호출 단위의 고유 코드
apiKey - API KEY - String - 길이40 - 필수Y - 앱 관리자(개발자)가 발급받은 API KEY
userKey - USER KEY - String - 길이40 - 필수Y - 앱 사용자가 회원가입할때 발급받은 USER KEY


Response
responseCode - 응답코드 - String - 길이X - 필수Y - H0000
responseMessage - 응답메세지 - String - 길이X - 필수Y - 정상처리 되었습니다.
apiName - API이름 - String - 길이30 - 필수Y - 호출 API URI 뒷부분 ex) /ssafy/api/v1/edu/demandDeposit/createDemandDeposit 호출 uri일 경우 => createDemandDeposit
transmissionDate - 전송일자 - String - 길이8 - 필수Y - API 전송일자(YYYYMMDD) 요청일
transmissionTime - 전송시각 - String - 길이6 - 필수Y - API 전송시각(HHMMSS) 요청시간 기준 +-5분
institutionCode - 기관코드 - String - 길이5 - 필수Y - '00100'로 고정
fintechAppNo - 핀테크 앱 일련번호 - String - 길이3 - 필수Y - '001'로 고정
apiServiceCode - API서비스코드 - String - 길이30 - 필수Y - API 이름 필드와 동일
institutionTransactionUniqueNo - 기관거래고유번호 - String - 길이20 - 필수Y - 기관별 API 서비스 호출 단위의 고유 코드
*/
