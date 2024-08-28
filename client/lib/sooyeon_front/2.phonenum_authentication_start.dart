import 'package:flutter/material.dart';

// PhoneNumAuthenticationStart 클래스 정의
class PhoneNumAuthenticationStart extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center, // 중앙 정렬
        children: [
          // 취소하기 버튼
          Container(
            padding: EdgeInsets.symmetric(vertical: 10),
            child: Stack(
              alignment: Alignment.center,
              children: [
                Icon(
                  Icons.arrow_back,
                  size: 50,
                  color: Colors.red,
                ),
                TextButton(
                  child: Text('취소하기'),
                  onPressed: () {
                    // 취소 로직 구현
                    print('취소하기 버튼 클릭됨');
                  },
                ),
              ],
            ),
          ),
          Text(
            '번호 인증을 위해\n문자를 보내주세요.',
            textAlign: TextAlign.center, // 텍스트 중앙 정렬
            style: TextStyle(fontSize: 18),
          ),
          SizedBox(height: 20),
          // 메시지 컨테이너
          Container(
            padding: EdgeInsets.all(10),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.center, // 중앙 정렬
              children: [
                Icon(Icons.message),
                SizedBox(width: 10),
                Text('메시지'),
              ],
            ),
          ),
          SizedBox(height: 10),
          // 또는 컨테이너
          Container(
            padding: EdgeInsets.all(10),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.center, // 중앙 정렬
              children: [
                Icon(Icons.send),
                SizedBox(width: 10),
                Text('또는'),
              ],
            ),
          ),
          SizedBox(height: 10),
          // 보내기 버튼
          Container(
            padding: EdgeInsets.all(10),
            child: Stack(
              alignment: Alignment.center,
              children: [
                Icon(
                  Icons.arrow_forward,
                  size: 50,
                  color: Colors.blue,
                ),
                TextButton(
                  child: Text('보내기'),
                  onPressed: () {
                    // 보내기 로직 구현
                    print('보내기 버튼 클릭됨');
                  },
                ),
              ],
            ),
          ),
          Spacer(),
          // 다음 버튼
          TextButton(
            child: Text('다음'),
            onPressed: () {
              // 다음 화면으로 이동 로직 구현
              print('다음 버튼 클릭됨');
            },
          ),
        ],
      ),
    );
  }
}

// MyApp 클래스 정의
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Phone Num Authentication',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: PhoneNumAuthenticationStart(), // PhoneNumAuthenticationStart를 홈 화면으로 설정
    );
  }
}

// main 함수
void main() {
  runApp(MyApp());
}
