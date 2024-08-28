import 'package:flutter/material.dart';

// PersonalInformationConsent 클래스 정의
class PersonalInformationConsent extends StatelessWidget {
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
                  print('취소하기 버튼 클릭됨');
                },
              ),
              SizedBox(height: 20),
              Text(
                '회원 등록을 위해\n항목에 동의해주세요.',
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
              ),
              SizedBox(height: 20),
              _buildConsentItem('필수 항목 전체 동의'),
              _buildConsentItem('[필수] 개인정보 수집이용'),
              _buildConsentItem('[필수] 고유식별정보처리 동의'),
              _buildConsentItem('[필수] 통신사 이용약관'),
              _buildConsentItem('[필수] 서비스 이용 동의'),
              Spacer(),
              Text(
                '시작하기 위해 회원 등록을 진행할까요?',
                style: TextStyle(fontSize: 16),
              ),
              SizedBox(height: 10),
              SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  child: Text('다음'),
                  onPressed: () {
                    // 다음 화면으로 이동 로직
                    print('다음 버튼 클릭됨');
                  },
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.blue,
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

  Widget _buildConsentItem(String text) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8.0),
      child: Row(
        children: [
          Icon(Icons.check_circle_outline, color: Colors.grey),
          SizedBox(width: 10),
          Text(text),
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
      title: 'Personal Information Consent',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: PersonalInformationConsent(), // PersonalInformationConsent를 홈 화면으로 설정
    );
  }
}

// main 함수
void main() {
  runApp(MyApp());
}
