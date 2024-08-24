import 'package:flutter/material.dart';

class HelpDialog extends StatelessWidget {
  final Widget child; // 다이얼로그 안에 표시될 위젯
  final double borderRadius; // 다이얼로그 모서리의 둥글기
  final double dialogWidthFactor; // 다이얼로그 너비 비율 (화면 대비)
  final double dialogHeightFactor; // 다이얼로그 높이 비율 (화면 대비)
  final EdgeInsetsGeometry dialogPadding; // 다이얼로그 내부의 패딩
  final Color backgroundColor; // 다이얼로그 배경색
  final Color borderColor; // 다이얼로그 테두리 색상
  final IconData closeIcon; // 닫기 버튼에 사용될 아이콘
  final double closeIconSize; // 닫기 아이콘의 크기
  final Color closeIconColor; // 닫기 아이콘의 색상
  final EdgeInsetsGeometry closeIconPadding; // 닫기 아이콘 주위의 패딩

  const HelpDialog({
    super.key,
    required this.child, // 필수로 제공되어야 하는 자식 위젯
    this.borderRadius = 20.0, // 모서리 둥글기 기본값
    this.dialogWidthFactor = 0.8, // 다이얼로그 너비 기본값 (화면의 80%)
    this.dialogHeightFactor = 0.8, // 다이얼로그 높이 기본값 (화면의 80%)
    this.dialogPadding = const EdgeInsets.all(20.0), // 내부 패딩 기본값
    this.backgroundColor = Colors.white, // 배경색 기본값 (흰색)
    this.borderColor = Colors.transparent, // 테두리 색상 기본값 (투명)
    this.closeIcon = Icons.close, // 닫기 아이콘 기본값
    this.closeIconSize = 24.0, // 닫기 아이콘 크기 기본값
    this.closeIconColor = Colors.black, // 닫기 아이콘 색상 기본값 (검정색)
    this.closeIconPadding = const EdgeInsets.all(8.0), // 닫기 아이콘 패딩 기본값
  });

  @override
  Widget build(BuildContext context) {
    return Dialog(
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.circular(borderRadius), // 다이얼로그 모서리 둥글게 설정
        side: BorderSide(color: borderColor), // 다이얼로그 테두리 색상 설정
      ),
      backgroundColor: backgroundColor, // 다이얼로그 배경색 설정
      child: Stack( // 다이얼로그 내부에서 닫기 버튼을 겹치게 배치하기 위해 Stack 사용
        children: [
          Container(
            width: MediaQuery.of(context).size.width * dialogWidthFactor, // 화면 너비에 대한 다이얼로그 너비 설정
            height: MediaQuery.of(context).size.height * dialogHeightFactor, // 화면 높이에 대한 다이얼로그 높이 설정
            padding: dialogPadding, // 다이얼로그 내부 패딩 설정
            child: child, // 다이얼로그의 내용이 될 자식 위젯
          ),
          Positioned( // 닫기 버튼의 위치를 설정 (오른쪽 상단)
            top: 10, // 상단에서 10픽셀 떨어짐
            right: 10, // 오른쪽에서 10픽셀 떨어짐
            child: Padding(
              padding: closeIconPadding, // 닫기 아이콘 주위의 패딩 설정
              child: IconButton(
                icon: Icon(
                  closeIcon, // 닫기 아이콘 설정
                  size: closeIconSize, // 아이콘 크기 설정
                  color: closeIconColor, // 아이콘 색상 설정
                ),
                onPressed: () {
                  Navigator.of(context).pop(); // 닫기 버튼 클릭 시 다이얼로그 닫기
                },
              ),
            ),
          ),
        ],
      ),
    );
  }
}
