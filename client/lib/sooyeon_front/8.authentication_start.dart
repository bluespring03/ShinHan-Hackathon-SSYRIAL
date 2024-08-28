import 'package:flutter/material.dart';

class AuthenticationStart extends StatefulWidget {
  @override
  _AuthenticationStartState createState() => _AuthenticationStartState();
}

class _AuthenticationStartState extends State<AuthenticationStart> {
  String? selectedGender;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // 취소하기 버튼
              TextButton(
                child: Text(
                  '취소하기',
                  style: TextStyle(color: Colors.grey),
                ),
                onPressed: () {
                  Navigator.pop(context);
                },
              ),
              SizedBox(height: 20),
              Text(
                '인증 시작 버튼을\n눌러주세요.',
                style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
              ),
              SizedBox(height: 20),
              // 인증 시작 버튼
              SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  child: Text('인증 시작', style: TextStyle(fontSize: 18)),
                  onPressed: () {
                    // 다음 화면으로 이동 로직
                    Navigator.pushNamed(context, '/next_screen');
                  },
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.green,
                    padding: EdgeInsets.symmetric(vertical: 16),
                  ),
                ),
              ),
              SizedBox(height: 20),
              // 성별 선택 컨테이너
              Container(
                padding: EdgeInsets.all(16),
                decoration: BoxDecoration(
                  color: Colors.grey[200],
                  borderRadius: BorderRadius.circular(8),
                ),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text('성별', style: TextStyle(fontSize: 18)),
                    SizedBox(height: 8),
                    Row(
                      children: [
                        Expanded(
                          child: ElevatedButton(
                            child: Text('남자'),
                            onPressed: () => setGender('남자'),
                            style: ElevatedButton.styleFrom(
                              backgroundColor: selectedGender == '남자' ? Colors.green : Colors.grey,
                            ),
                          ),
                        ),
                        SizedBox(width: 8),
                        Expanded(
                          child: ElevatedButton(
                            child: Text('여자'),
                            onPressed: () => setGender('여자'),
                            style: ElevatedButton.styleFrom(
                              backgroundColor: selectedGender == '여자' ? Colors.green : Colors.grey,
                            ),
                          ),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  void setGender(String gender) {
    setState(() {
      selectedGender = gender;
    });
  }
}

class NextScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Next Screen')),
      body: Center(child: Text('This is the next screen!')),
    );
  }
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Authentication App',
      theme: ThemeData(
        primarySwatch: Colors.green,
      ),
      home: AuthenticationStart(), // 홈 화면을 AuthenticationStart로 설정
      routes: {
        '/next_screen': (context) => NextScreen(), // 다음 화면으로 이동할 때 사용할 라우트
      },
    );
  }
}

void main() {
  runApp(MyApp());
}
