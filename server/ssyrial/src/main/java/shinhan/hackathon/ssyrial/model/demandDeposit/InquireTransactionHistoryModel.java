/*
2.3.13 계좌 거래 내역 조회 (단건) (p.65)

설명
계좌 거래 내역 (단건)을 조회합니다.

Request
Header - 공통 - 타입X - 길이X - 필수Y
accountNo - 계좌번호 - String - 길이16 - 필수Y
transactionUniqueNo - 거래고유번호 - Long - 길이X - 필수Y

Response
Header - 공통 - 타입X - 길이X - 필수Y
REC - 거래내역 - List - 길이X - 필수N
transactionUniqueNo - 거래고유번호 - Long - 길이X - 필수Y
transactionDate - 거래일자 - String - 길이8 - 필수Y
transactionTime - 거래시각 - String - 길이6 - 필수Y
transactionType - 입금출금구분 - String - 길이1 - 필수Y - 1,2
transactionTypeName - 입금출금구분명 - String - 길이10 - 필수Y - 입금, 출금, 입금(이체), 출금(이체)
transactionAccountNo - 거래계좌번호 - String - 길이16 - 필수N
transactionBalance - 거래금액 - Long - 길이X - 필수Y
transactionAfterBalance - 거래후잔액 - Long - 길이X - 필수Y
transactionSummary - 거래 요약내용 - String - 길이255 - 필수N
transactionMemo - 거래 메모 - String - 길이255 - 필수N
*/