/*
2.4.2 상품 조회 (p.31)

설명
은행별 계좌 상품을 조회

Request
Header - 공통 - 타입X - 길이X - 필수Y - userKey 제외

Response
Header - 공통 - 타입X - 길이X - 필수Y
REC - 은행별 상품 리스트 - List - 길이X - 필수Y
accountTypeUniqueNo - 상품 고유번호 - String - 길이20 - 필수Y
bankCode - 은행코드 - String - 길이20 - 필수Y
bankName - 은행명 - String - 길이20 - 필수Y
accountTypeCode - 상품구분코드 - String - 길이3 - 필수Y - 1:수시입출금, 2:정기예금, 3:정기적금, 4:대출
accountName - 상품명 - String - 길이20 - 필수Y
accountDescription - 상품설명 - String - 길이255 - 필수N
accountType - 통화 - String - 길이255 - 필수Y - DOMESTIC:원화, OVERSEAS:외화
*/