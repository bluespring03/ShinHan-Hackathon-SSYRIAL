/*
2.3.12 계좌 거래 내역 조회 (p.61)

설명
계좌 거래 내역 목록을 조회합니다.

Request
Header - 공통 - 타입X - 길이X - 필수Y
accountNo - 계좌번호 - String - 길이16 - 필수Y
startDate - 조회시작일자 - String - 길이8 - 필수Y - YYYYMMDD
endDate - 조회종료일자 - String - 길이8 - 필수Y - YYYYMMDD
transactionType - 거래구분 - String - 길이1 - 필수Y - M:입금 D:출금 A:전체
orderByType - 정렬순서 - String - 길이4 - 필수N - 거래고유번호 기준 ASC:오름차순(이전거래), DESC:내림차순(최근거래)

Response
Header - 공통 - 타입X - 길이X - 필수Y
REC - 거래내역 - List - 길이X - 필수N
totalCount - 조회총건수 - String - 길이X - 필수N
list - 거래목록 - List - 길이X - 필수N
transactionUniqueNo - 거래고유번호 - Long - 길이X - 필수Y
transactionDate - 거래일자 - String - 길이8 - 필수Y
transactionTime - 거래시각 - String - 길이6 - 필수Y
transactionTypeName - 입금출금구분명 - String - 길이10 - 필수Y - 입금, 출금, 입금(이체), 출금(이체)
transactionAccountNo - 거래계좌번호 - String - 길이16 - 필수N
transactionBalance - 거래금액 - Long - 길이X - 필수Y
transactionAfterBalance - 거래후잔액 - Long - 길이X - 필수Y
transactionSummary - 거래 요약내용 - String - 길이255 - 필수N
transactionMemo - 거래 메모 - String - 길이255 - 필수N
*/