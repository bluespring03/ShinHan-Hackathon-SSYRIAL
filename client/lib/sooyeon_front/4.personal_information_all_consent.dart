import 'package:flutter/material.dart';

// PersonalInformationAllConsent 클래스 정의
class PersonalInformationAllConsent extends StatefulWidget {
  @override
  _PersonalInformationAllConsentState createState() => _PersonalInformationAllConsentState();
}

class _PersonalInformationAllConsentState extends State<PersonalInformationAllConsent> {
  bool isAllConsented = false;

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
                  // 취소 화면으로 이동 로직
                  Navigator.pop(context);
                },
              ),
              SizedBox(height: 20),
              Text(
                '회원 등록을 위해\n항목에 동의해주세요.',
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
              ),
              SizedBox(height: 20),
              // 전체 동의 버튼
              Container(
                decoration: BoxDecoration(
                  border: Border.all(color: Colors.grey),
                  borderRadius: BorderRadius.circular(8),
                ),
                child: TextButton(
                  child: Row(
                    children: [
                      Icon(
                        isAllConsented ? Icons.check_box : Icons.check_box_outline_blank,
                        color: isAllConsented ? Colors.blue : Colors.grey,
                      ),
                      SizedBox(width: 10),
                      Text('필수 항목 전체 동의'),
                    ],
                  ),
                  onPressed: () {
                    setState(() {
                      isAllConsented = !isAllConsented;
                    });
                    // 개인정보 동의 내용 서버에 전송
                    _sendConsentToServer();
                  },
                ),
              ),
              Spacer(),
              // 다음 버튼
              SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  child: Text('다음'),
                  onPressed: isAllConsented
                      ? () {
                    // 다음 화면으로 이동 로직
                    Navigator.pushNamed(context, '/next_screen');
                  }
                      : null,
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.green,
                    padding: EdgeInsets.symmetric(vertical: 16),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  void _sendConsentToServer() {
    // TODO: 서버에 동의 내용 전송 로직 구현
    print('개인정보 동의 내용 서버 전송: $isAllConsented');
  }
}

// MyApp 클래스 정의
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Personal Information Consent',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: PersonalInformationAllConsent(), // PersonalInformationAllConsent를 홈 화면으로 설정
      // 정의된 경로에 따라 라우팅을 추가할 수 있습니다.
      // 예를 들어, '/next_screen' 경로를 사용할 수 있도록 설정
      routes: {
        '/next_screen': (context) => NextScreen(), // NextScreen을 정의해 주세요.
      },
    );
  }
}

// Placeholder for the next screen
class NextScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Next Screen'),
      ),
      body: Center(
        child: Text('다음 화면입니다!'),
      ),
    );
  }
}

// main 함수
void main() {
  runApp(MyApp());
}
