/*
 * 2.4.5 계좌 조회 (단건) (p.41)
 * 
 * 설명
 * 특정 계좌에 대한 정보 조회
 * 
 * Request
 * Header - 공통 - 타입X - 길이X - 필수Y
 * accountNo - 계좌번호 - String - 길이16 - 필수Y
 * 
 * Response
 * Header - 공통 - 타입X - 길이X - 필수Y
 * REC - 계좌정보 - List - 길이X - 필수N
 * bankCode - 은행코드 - String - 길이3 - 필수Y
 * bankName - 은행명 - String - 길이20 - 필수Y
 * username - 예금주명 - String - 길이50 - 필수Y
 * accountNo - 계좌번호 - String - 길이16 - 필수Y
 * accountName - 상품명 - String - 길이20 - 필수Y
 * accountTypeCode - 상품구분코드 - String - 길이3 - 필수Y - 1:수시입출금, 2:정기예금, 3:정기적금, 4:대출
 * accountTypeName - 상품종류명 - String - 길이20 - 필수Y
 * accountCreatedDate - 계좌개설일 - String - 길이8 - 필수Y
 * accountExpiryDate - 계좌만기일 - String - 길이8 - 필수Y
 * dailyTransferLimit - 1일이체한도 - Long - 길이X - 필수Y
 * oneTimeTransferLimit - 1회이체한도 - Long - 길이X - 필수Y
 * accountBalance - 계좌잔액 - Long - 길이X - 필수Y
 * lastTransactionDate - 최종거래일 - String - 길이8 - 필수N
 * currency - 통화코드 - String - 길이8 - 필수Y
 */