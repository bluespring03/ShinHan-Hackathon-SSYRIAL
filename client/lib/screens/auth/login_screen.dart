import 'package:flutter/material.dart';
import 'package:ssyrial/screens/auth/success_screen.dart';
import 'package:ssyrial/widgets/custom_dialog.dart';

class LoginScreen extends StatelessWidget {
  final String titleText; // 제목 텍스트
  final String passwordButtonText; // 비밀번호 버튼 텍스트
  final String authButtonText; // 인증서 버튼 텍스트
  final TextStyle? titleTextStyle; // 제목 텍스트 스타일
  final TextStyle? buttonTextStyle; // 버튼 텍스트 스타일
  final Color passwordButtonColor; // 비밀번호 버튼 배경색
  final Color authButtonColor; // 인증서 버튼 배경색
  final double buttonSpacing; // 버튼 사이 간격
  final EdgeInsetsGeometry padding; // 전체 화면 패딩

  const LoginScreen({
    Key? key,
    this.titleText = '로그인 방식을 선택해주세요', // 기본 제목 텍스트
    this.passwordButtonText = '비밀번호', // 기본 비밀번호 버튼 텍스트
    this.authButtonText = '인증서', // 기본 인증서 버튼 텍스트
    this.titleTextStyle,
    this.buttonTextStyle,
    this.passwordButtonColor = Colors.blue, // 기본 비밀번호 버튼 색상
    this.authButtonColor = Colors.green, // 기본 인증서 버튼 색상
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
            titleText, // 제목 텍스트
            style: titleTextStyle, // 제목 텍스트 스타일
          ),
          SizedBox(height: 20),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              ElevatedButton(
                onPressed: () {
                  // 비밀번호 로그인 성공 메시지 표시
                  Navigator.pop(context);
                  showDialog(
                    context: context,
                    builder: (context) => CustomDialog(
                        child: SuccessScreen(message: '비밀번호 로그인 성공~~')),
                  );
                },
                style: ElevatedButton.styleFrom(
                  backgroundColor: passwordButtonColor, // 비밀번호 버튼 배경색 설정
                ),
                child: Text(
                  passwordButtonText, // 비밀번호 버튼 텍스트
                  style: buttonTextStyle, // 버튼 텍스트 스타일
                ),
              ),
              SizedBox(width: buttonSpacing), // 버튼 간격 설정
              ElevatedButton(
                onPressed: () {
                  // 인증서 로그인 성공 메시지 표시
                  Navigator.pop(context);
                  showDialog(
                    context: context,
                    builder: (context) => CustomDialog(
                        child: SuccessScreen(message: '인증서 로그인 성공~~')),
                  );
                },
                style: ElevatedButton.styleFrom(
                  backgroundColor: authButtonColor, // 인증서 버튼 배경색 설정
                ),
                child: Text(
                  authButtonText, // 인증서 버튼 텍스트
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
