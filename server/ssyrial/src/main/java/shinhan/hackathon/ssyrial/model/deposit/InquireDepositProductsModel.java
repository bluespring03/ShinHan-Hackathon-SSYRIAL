/*
2.5.2 예금 상품 조회 (p.75)

설명
예금 상품 목록을 조회합니다.

Request
Header - 공통 - 타입X - 길이X - 필수Y - userKey 제외

Response
Header - 공통 - 타입X - 길이X - 필수Y
REC - 예금상품목록 - List - 길이X - 필수N
accountTypeUniqueNo - 상품 고유번호 - String - 길이20 - 필수Y
bankCode - 은행코드 - String - 길이3 - 필수Y
bankName - 은행명 - String - 길이20 - 필수Y
accountTypeCode - 상품구분코드 - String - 길이3 - 필수Y - 1:수시입출금, 2:정기예금, 3:정기적금, 4:대출
accountTypeName - 상품구분명 - String - 길이20 - 필수Y
accountName - 상품명 - String - 길이20 - 필수Y
accountDescription - 상품설명 - String - 길이255 - 필수N
subscriptionPeriod - 가입기간 - String - 길이20 - 필수Y
minSubscriptionBalance - 최소 가입 가능금액 - Long - 길이X - 필수Y
maxSubscriptionBalance - 최대 가입 가능금액 - Long - 길이X - 필수Y
interestRate - 이자율 - double - 길이X - 필수Y
rateDescription - 이자율 설명 - String - 길이255 - 필수N
*/