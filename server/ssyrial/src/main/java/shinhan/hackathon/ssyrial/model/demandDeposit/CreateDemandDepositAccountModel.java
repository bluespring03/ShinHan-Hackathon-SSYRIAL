/*
 * 2.4.3 계좌 생성 (p.34)
 * 
 * 설명
 * 계좌를 생성합니다. 상품을 조회한 사용자는 상품 고유번호를 통해 계좌를 생성할 수 있습니다.
 * 
 * Request
 * Header - 공통 - 타입X - 길이X - 필수Y
 * accountTypeUniqueNo - 상품 고유번호 - String - 길이20 - 필수Y
 * 
 * Response
 * Header - 공통 - 타입X - 길이X - 필수Y
 * REC - 계좌정보 - List - 길이X - 필수Y
 * bankCode - 은행코드 - String - 길이3 - 필수Y
 * accountNo - 계좌번호 - String - 길이16 - 필수Y
 * currency - 설명X - List - 길이X - 필수Y
 * currency - 통화코드 - String - 길이8 - 필수Y
 * currencyName - 통화명 - String - 길이16 - 필수Y
 */