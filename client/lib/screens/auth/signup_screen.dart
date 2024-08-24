import 'package:flutter/material.dart';
import 'package:ssyrial/screens/auth/login_screen.dart';
import 'package:ssyrial/screens/auth/success_screen.dart';
import 'package:ssyrial/widgets/help_dialog.dart';

class SignupScreen extends StatelessWidget {
  final String questionText; // 질문 텍스트
  final String yesButtonText; // "네" 버튼 텍스트
  final String noButtonText; // "아니요" 버튼 텍스트
  final TextStyle? questionTextStyle; // 질문 텍스트 스타일
  final TextStyle? buttonTextStyle; // 버튼 텍스트 스타일
  final Color yesButtonColor; // "네" 버튼 배경색
  final Color noButtonColor; // "아니요" 버튼 배경색
  final double buttonSpacing; // 버튼 사이 간격
  final EdgeInsetsGeometry padding; // 전체 화면 패딩

  const SignupScreen({
    Key? key,
    this.questionText = '신한은행 아이디를 가지고 있나요?', // 기본 질문 텍스트
    this.yesButtonText = '네', // 기본 "네" 버튼 텍스트
    this.noButtonText = '아니요', // 기본 "아니요" 버튼 텍스트
    this.questionTextStyle,
    this.buttonTextStyle,
    this.yesButtonColor = Colors.blue, // 기본 "네" 버튼 색상
    this.noButtonColor = Colors.grey, // 기본 "아니요" 버튼 색상
    this.buttonSpacing = 20.0, // 기본 버튼 간격
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
            questionText, // 질문 텍스트
            style: questionTextStyle, // 질문 텍스트 스타일
          ),
          SizedBox(height: 20),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              ElevatedButton(
                onPressed: () {
                  // 로그인 화면으로 이동
                  Navigator.pop(context);
                  showDialog(
                    context: context,
                    builder: (context) => HelpDialog(child: LoginScreen()),
                  );
                },
                style: ElevatedButton.styleFrom(
                  backgroundColor: yesButtonColor, // "네" 버튼 배경색 설정
                ),
                child: Text(
                  yesButtonText, // "네" 버튼 텍스트
                  style: buttonTextStyle, // 버튼 텍스트 스타일
                ),
              ),
              SizedBox(width: buttonSpacing), // 버튼 간격 설정
              ElevatedButton(
                onPressed: () {
                  // 회원가입 성공 메시지 표시
                  Navigator.pop(context);
                  showDialog(
                    context: context,
                    builder: (context) =>
                        HelpDialog(child: SuccessScreen(message: '회원가입 성공~~~~~~')),
                  );
                },
                style: ElevatedButton.styleFrom(
                  backgroundColor: noButtonColor, // "아니요" 버튼 배경색 설정
                ),
                child: Text(
                  noButtonText, // "아니요" 버튼 텍스트
                  style: buttonTextStyle, // 버튼 텍스트 스타일
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
