import 'package:flutter/material.dart';

// SaveYourPassword 클래스와 상태 관리 클래스
class SaveYourPassword extends StatefulWidget {
  @override
  _SaveYourPasswordState createState() => _SaveYourPasswordState();
}

class _SaveYourPasswordState extends State<SaveYourPassword> {
  String password = '';

  void addDigit(String digit) {
    if (password.length < 6) {
      setState(() {
        password += digit;
      });
    }
  }

  void removeDigit() {
    if (password.isNotEmpty) {
      setState(() {
        password = password.substring(0, password.length - 1);
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                '6자리 비밀번호를 다시 입력해주세요.',
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
              SizedBox(height: 20),
              Container(
                padding: EdgeInsets.all(16),
                decoration: BoxDecoration(
                  color: Colors.grey[200],
                  borderRadius: BorderRadius.circular(8),
                ),
                child: Text(
                  '* ' * password.length + '  ' * (6 - password.length),
                  style: TextStyle(fontSize: 24),
                ),
              ),
              SizedBox(height: 20),
              GridView.count(
                shrinkWrap: true,
                crossAxisCount: 3,
                childAspectRatio: 1.5,
                mainAxisSpacing: 10,
                crossAxisSpacing: 10,
                children: [
                  for (var i = 1; i <= 9; i++) buildNumberButton(i.toString()),
                  buildActionButton('재배열', Colors.grey),
                  buildNumberButton('0'),
                  buildActionButton('하나지우기', Colors.grey),
                ],
              ),
              SizedBox(height: 20),
              Row(
                children: [
                  Expanded(
                    child: ElevatedButton(
                      child: Text('취소', style: TextStyle(fontSize: 18)),
                      onPressed: () => Navigator.pop(context),
                      style: ElevatedButton.styleFrom(backgroundColor: Colors.red),
                    ),
                  ),
                  SizedBox(width: 10),
                  Expanded(
                    child: ElevatedButton(
                      child: Text('완료', style: TextStyle(fontSize: 18)),
                      onPressed: password.length == 6 ? () {
                        // TODO: 2.2.1 사용자 계정 생성 API 호출
                        print('비밀번호: $password');
                        // 서버로 데이터 전송 로직 구현
                      } : null,
                      style: ElevatedButton.styleFrom(backgroundColor: Colors.blue),
                    ),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget buildNumberButton(String number) {
    return ElevatedButton(
      child: Text(number, style: TextStyle(fontSize: 24)),
      onPressed: () => addDigit(number),
      style: ElevatedButton.styleFrom(
        backgroundColor: Colors.green,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
      ),
    );
  }

  Widget buildActionButton(String text, Color color) {
    return ElevatedButton(
      child: Text(text, style: TextStyle(fontSize: 14)),
      onPressed: text == '하나지우기' ? removeDigit : null,
      style: ElevatedButton.styleFrom(
        backgroundColor: color,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
      ),
    );
  }
}

// MyApp 클래스와 main 함수
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Password Input',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: SaveYourPassword(), // SaveYourPassword 위젯을 홈 화면으로 설정
    );
  }
}

void main() {
  runApp(MyApp());
}
