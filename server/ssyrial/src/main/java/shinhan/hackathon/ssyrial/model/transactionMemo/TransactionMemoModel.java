/*
2.12.1 거래내역 메모 (p.223)

설명
원화, 외화 수시입출금의 거래내역에 대한 메모를 작성하고 수정합니다.

Request
Header - 공통 - 타입X - 길이X - 필수Y - userKey 제외
accountNo - 계좌번호 - String - 길이16 - 필수Y
transactionUniqueNo - 거래고유번호 - Long - 길이X - 필수Y
transactionMemo - 메모 - String - 길이255 - 필수N

Response
Header - 공통 - 타입X - 길이X - 필수Y
REC - 설명X - List - 길이 - 필수Y
memoUniqueNo - 메모 고유번호 - Long - 길이X
accountNo - 계좌번호 - String - 길이16 - 필수Y
transactionUniqueNo - 거래 고유번호 - Long - 길이X - 필수Y
transactionMemo - 메모 - String - 길이255 - 필수N
created - 생성일 - String - 길이10 - 필수Y
*/