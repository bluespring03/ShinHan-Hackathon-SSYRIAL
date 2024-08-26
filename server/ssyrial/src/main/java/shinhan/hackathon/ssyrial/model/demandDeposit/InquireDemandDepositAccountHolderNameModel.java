/*
2.4.6 예금주 조회 (p.44)

설명
계좌에 대한 예금주명을 조회합니다.

Request
Header - 공통 - 타입X - 길이X - 필수Y
accountNo - 계좌번호 - String - 길이16 - 필수Y - 외화 계좌 가능

Response
Header - 공통 - 타입X - 길이X - 필수Y
REC - 계좌정보 - List - 길이X - 필수N
bankCode - 은행코드 - String - 길이3 - 필수Y
bankName - 은행명 - String - 길이20 - 필수Y
accountNo - 계좌번호 - String - 길이16 - 필수Y
userName - 예금주명 - String - 길이50 - 필수Y
currency - 통화코드 - String - 길이8 - 필수Y
*/