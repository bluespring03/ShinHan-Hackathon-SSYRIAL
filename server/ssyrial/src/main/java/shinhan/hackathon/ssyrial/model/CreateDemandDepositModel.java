/*
2.4.1 상품 등록 (p.28)

설명
은행별 수시입출금 상품을 등록

Request
Header - 공통 - 타입X - 길이X - 필수Y - userKey 제외
bankCode - 은행코드 - String - 길이3 - 필수Y
accountName - 상품명 - String - 길이20 - 필수Y
accountDescription - 상품설명 - String - 길이255 - 필수N

Response
Header - 공통 - 타입X - 길이X - 필수Y
REC - 등록된 상품 정보 - List - 길이X - 필수 Y
accountTypeUniqueNo - 상품 고유번호 - String - 길이20 - 필수Y
bankCode - 은행코드 - String - 길이3 - 필수Y
bankName - 은행명 - String - 길이20 - 필수Y
accountTypeCode - 상품구분코드 - String - 길이3 - 필수Y - 1:수시입출금, 2:정기예금, 3:정기적금, 4:대출
accountTypeName - 상품구분명 - String - 길이20 - 필수Y
accountName - 상품명 - String - 길이20 - 필수Y
accountDescription - 상품설명 - String - 길이255 - 필수N
accountType - 통화 - String - 길이255 - 필수Y - DOMESTIC:원화, OVERSEAS:외화
*/