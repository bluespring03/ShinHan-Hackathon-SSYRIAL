/*
 * 2.4.4 계좌 목록 조회 (p.37)
 * 
 * 설명
 * 사용자의 계좌 목록 전체를 조회합니다.
 * 
 * Request
 * Header - 공통 - 타입X - 길이X - 필수Y
 * 
 * Response
 * Header - 공통 - 타입X - 길이X - 필수Y
 * REC - 계좌목록 - List - 길이X - 필수N - 생성된 계좌가 없는 경우 응답JSON에 존재하지 않음
 * bankCode - 은행코드 - String - 길이3 - 필수Y
 * bankName - 은행명 - String - 길이20 - 필수Y
 * username - 예금주명 - String - 길이50 - 필수Y
 * accountNo - 계좌번호 - String - 길이16 - 필수Y
 * accountName - 상품명 - String - 길이20 - 필수Y
 * accountTypeCode - 상품구분코드 - String - 길이3 - 필수Y - 1:수시입출금, 2:정기예금, 3:정기적금, 4:대출
 * accountTypeName - 상품종류명 - String - 길이20 - 필수Y
 * accountCreatedDate - 계좌개설일 - String - 길이8 - 필수Y
 * accountExpiryDate - 계좌만기일 - String - 길이8 - 필수Y
 * dailyTransferLimit - 1일이체한도 - Long - 길이X - 필수Y - default:5억
 * oneTimeTransferLimit - 1회이체한도 - Long - 길이X - 필수Y - default:1억
 * accountBalance - 계좌잔액 - Long - 길이X - 필수Y
 * lastTransactionDate - 최종거래일 - String - 길이8 - 필수N
 * currency - 통화코드 - String - 길이8 - 필수Y
 */