/*
2.5.1 예금 상품 등록 (p.71)

설명
은행별 예금 상품을 등록합니다. 
은행코드를 조회하여 해당 은행의 예금 상품을 생성할 수 있습니다.
예금 상품 조회 API를 통해 샘플 데이터를 참고하여 상품을 등록할 수 있습니다.

Request
Header - 공통 - 타입X - 길이X - 필수Y - userKey 제외
bankCode - 은행코드 - String - 길이20 - 필수Y
accountName - 상품명 - String - 길이20 - 필수Y - 예금 상품명 입력 (ex. 7일 예금)
accountDescription - 상품설명 - String - 길이20 - 필수N - 예금 상품 설명 입력 (ex. 최대 10% 이자를 지급하는 특별 적금)
subscriptionPeriod - 가입기간 - String - 길이20 - 필수Y - 2 이상 ~ 365 이하 / 단위(일)
minSubscriptionBalance - 최소가입가능금액 - Long - 길이X - 필수Y - 1 이상/ 단위(원)
maxSubscriptionBalance - 최대가입가능금액 - Long - 길이X - 필수Y - 100000000(1억) 이하/ 단위(원)
interestRate - 이자율 - Double - 길이X - 필수Y - 0.1이상 ~ 20 이하 / 단위(%)
rateDescription - 이자율 설명 - String - 길이255 - 필수N

Response
Header - 공통 - 타입X - 길이X - 필수Y
REC - 예금계좌정보 - 타입X - 길이X - 필수Y
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