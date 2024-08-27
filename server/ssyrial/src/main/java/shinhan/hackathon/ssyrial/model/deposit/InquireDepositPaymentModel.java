/*
2.5.6 예금 납입 상세 조회 (p.89)

설명
가입한 예금 계좌의 납입 내역을 상세 조회합니다.

Request
Header - 공통 - 타입X - 길이X - 필수Y
accountNo - 계좌번호 - String - 길이16 - 필수Y

Response
Header - 공통 - 타입X - 길이X - 필수Y
REC - 예금납입내역 - 타입X - 길이X - 필수Y
paymentUniqueNo - 납입 고유번호 - String - 길이X - 필수Y
paymentDate - 납입일자 - String - 길이8 - 필수Y
paymentTime - 납입시각 - String - 길이6 - 필수Y
paymentBalance - 납입금액 - Long - 길이X - 필수Y
*/