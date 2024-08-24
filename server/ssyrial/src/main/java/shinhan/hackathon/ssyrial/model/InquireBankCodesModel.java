/*
2.3.2 은행코드 조회 (p.21)

설명
입출금, 예적금, 대출 상품 등록시 필요함.
은행코드를 조회해야 각 은행 상품을 만들 수 있음.

Request
Header - 공통 - 타입X - 길이X - 필수Y - userKey 제외

Response
Header - 공통 - 타입X - 길이X - 필수Y
REC-은행코드 리스트-List-길이X-필수Y
bankCode-은행코드-String-길이3-필수Y
bankName-은행코드명-String-길이3-필수Y
*/
