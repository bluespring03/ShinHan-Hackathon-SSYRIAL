/*
2.4.7 계좌 잔액 조회 (p.46)

설명
특정 계좌의 잔액을 조회

Request
Header - 공통 - 타입X - 길이X - 필수Y
accountNo - 계좌번호 - String - 길이16 - 필수Y

Response
Header - 공통 - 타입X - 길이X - 필수Y
REC - 계좌정보 - List - 길이X - 필수N
bankCode - 은행코드 - String - 길이3 - 필수Y
accountNo - 계좌번호 - String - 길이16 - 필수Y
accountBalance - 계좌잔액 - Long - 길이X - 필수Y
accountCreatedDate - 계좌개설일 - String - 길이8 - 필수Y
accountExpiryDate - 계좌만기일 - String - 길이8 - 필수Y
lastTransactionDate - 최종거래일 - String - 길이8 - 필수N
currency - 통화코드 - String - 길이8 - 필수Y
*/