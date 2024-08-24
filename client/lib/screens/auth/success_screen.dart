import 'package:flutter/material.dart';
import 'package:ssyrial/screens/guide/function_selection_screen.dart';

class SuccessScreen extends StatelessWidget {
  final String message; // 성공 메시지 텍스트
  final String buttonText; // 버튼 텍스트
  final TextStyle? messageTextStyle; // 메시지 텍스트 스타일
  final TextStyle? buttonTextStyle; // 버튼 텍스트 스타일
  final Color buttonColor; // 버튼 배경색
  final EdgeInsetsGeometry padding; // 전체 화면 패딩

  const SuccessScreen({
    Key? key,
    required this.message, // 필수 파라미터로 성공 메시지 텍스트
    this.buttonText = '확인', // 기본 버튼 텍스트
    this.messageTextStyle,
    this.buttonTextStyle,
    this.buttonColor = Colors.blue, // 기본 버튼 배경색
    this.padding = const EdgeInsets.all(16.0), // 기본 패딩
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: padding, // 전체 화면의 패딩 설정
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(
            message, // 성공 메시지 텍스트
            style: messageTextStyle, // 메시지 텍스트 스타일
            textAlign: TextAlign.center, // 중앙 정렬
          ),
          SizedBox(height: 20),
          ElevatedButton(
            onPressed: () {
              // 새로운 기능 선택 화면으로 이동
              Navigator.pop(context);
              Navigator.push(
                context,
                MaterialPageRoute(
                    builder: (context) => FunctionSelectionScreen()),
              );
            },
            style: ElevatedButton.styleFrom(
              backgroundColor: buttonColor, // 버튼 배경색 설정
            ),
            child: Text(
              buttonText, // 버튼 텍스트
              style: buttonTextStyle, // 버튼 텍스트 스타일
            ),
          ),
        ],
      ),
    );
  }
}
