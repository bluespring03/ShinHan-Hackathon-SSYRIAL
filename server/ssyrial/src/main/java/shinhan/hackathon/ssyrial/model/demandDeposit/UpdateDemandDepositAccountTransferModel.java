/*
2.4.10 계좌 이체 (p.55)

설명
한 계좌로부터 다른 계좌로 대금을 이체합니다.

Request
Header - 공통 - 타입X - 길이X - 필수Y
depositAccountNo - 입금계좌번호 - String - 길이16 - 필수Y - 원화, 외화 계좌 가능
transactionBalance - 거래금액 - Long - 길이X - 필수Y - 출금할 금액 입력
withdrawalAccountNo - 출금계좌번호 - String - 길이16 - 필수Y - 원화 계좌만 가능
depositTransactionSummary - 거래 요약내용(입금계좌) - String - 길이255 - 필수N
withdrawalTransactionSummary - 거래 요약내용(출금계좌) - String - 길이255 - 필수N

Response
Header - 공통 - 타입X - 길이X - 필수Y
REC - 거래목록 - 길이X - 필수Y
transactionUniqueNo - 거래고유번호 - Long - 길이X - 필수Y
accountNo - 계좌번호 - String - 길이16 - 필수Y
transactionDate - 거래일자 - String - 길이8 - 필수Y - YYYYMMDD
transactionType - 거래유형 - String - 길이1 - 필수Y - 1, 2 ...
transactionTypeName - 거래유형명 - String - 길이8 - 필수Y - 입금이체, 출금이체 ...
transactionAccountNo - 거래 계좌번호 - String - 길이16 - 필수Y - 이체 거래에 대한 계좌번호
*/