import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: SendMoneyRejectPasswordScreen(),
    );
  }
}

class SendMoneyRejectPasswordScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('비밀번호 오류'),
      ),
      body: Center(
        child: RedContainerWithMessage(),
      ),
    );
  }
}

class RedContainerWithMessage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.red, // 빨강색 배경
      padding: EdgeInsets.all(16.0),
      child: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          // Image 위젯
          Icon(
            Icons.close, // X모양 아이콘
            color: Colors.white,
            size: 50.0,
          ),
          SizedBox(height: 16.0),
          // Text 위젯
          Text(
            '비밀번호가 틀렸어요',
            style: TextStyle(
              fontSize: 18.0,
              color: Colors.white,
              fontWeight: FontWeight.bold,
            ),
          ),
        ],
      ),
    );
  }
}
