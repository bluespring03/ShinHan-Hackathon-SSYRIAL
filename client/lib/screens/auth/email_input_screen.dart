import 'package:flutter/material.dart';
import 'package:ssyrial/screens/auth/signup_screen.dart';
import 'package:ssyrial/widgets/help_dialog.dart';

class EmailInputScreen extends StatefulWidget {
  final String title; // 화면의 제목
  final String labelText; // 텍스트 필드의 라벨
  final String buttonText; // 버튼에 표시될 텍스트
  final TextStyle? titleTextStyle; // 제목의 텍스트 스타일
  final TextStyle? labelTextStyle; // 라벨의 텍스트 스타일
  final TextStyle? buttonTextStyle; // 버튼 텍스트의 스타일
  final Color buttonColor; // 버튼 배경색
  final EdgeInsetsGeometry padding; // 화면 전체의 패딩

  const EmailInputScreen({
    Key? key,
    this.title = '이메일을 입력하세요',
    this.labelText = '이메일',
    this.buttonText = '다음',
    this.titleTextStyle,
    this.labelTextStyle,
    this.buttonTextStyle,
    this.buttonColor = Colors.blue,
    this.padding = const EdgeInsets.all(16.0),
  }) : super(key: key);

  @override
  _EmailInputScreenState createState() => _EmailInputScreenState();
}

class _EmailInputScreenState extends State<EmailInputScreen> {
  final _emailController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: widget.padding, // 전체 화면의 패딩 설정
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(
            widget.title, // 제목 텍스트
            style: widget.titleTextStyle, // 제목의 텍스트 스타일
          ),
          SizedBox(height: 20),
          TextFormField(
            controller: _emailController,
            decoration: InputDecoration(
              border: OutlineInputBorder(),
              labelText: widget.labelText, // 라벨 텍스트
              labelStyle: widget.labelTextStyle, // 라벨 텍스트 스타일
            ),
          ),
          SizedBox(height: 20),
          ElevatedButton(
            onPressed: () {
              // 이메일 입력 후 다음 단계로 진행
              if (_emailController.text.isNotEmpty) {
                Navigator.pop(context);
                showDialog(
                  context: context,
                  builder: (context) => HelpDialog(child: SignupScreen()),
                );
              } else {
                // 이메일이 입력되지 않은 경우 오류 메시지 표시
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(content: Text('이메일을 입력해주세요')),
                );
              }
            },
            style: ElevatedButton.styleFrom(
              backgroundColor: widget.buttonColor, // 버튼 배경색 설정
            ),
            child: Text(
              widget.buttonText, // 버튼 텍스트
              style: widget.buttonTextStyle, // 버튼 텍스트 스타일
            ),
          ),
        ],
      ),
    );
  }
}
