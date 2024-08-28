import 'package:flutter/material.dart';

class PersonalInformationChooseGender extends StatefulWidget {
  @override
  _PersonalInformationChooseGenderState createState() => _PersonalInformationChooseGenderState();
}

class _PersonalInformationChooseGenderState extends State<PersonalInformationChooseGender> {
  String? selectedGender;
  String birthday = '980229'; // 하드코딩된 생년월일

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
                '맞는 성별을 눌러 주세요.',
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
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
                    Text('성별'),
                    SizedBox(height: 8),
                    Row(
                      children: [
                        Expanded(
                          child: ElevatedButton(
                            child: Text('남자'),
                            onPressed: () => setGender('남자'),
                            style: ElevatedButton.styleFrom(
                              backgroundColor: selectedGender == '남자' ? Colors.blue : Colors.grey,
                            ),
                          ),
                        ),
                        SizedBox(width: 8),
                        Expanded(
                          child: ElevatedButton(
                            child: Text('여자'),
                            onPressed: () => setGender('여자'),
                            style: ElevatedButton.styleFrom(
                              backgroundColor: selectedGender == '여자' ? Colors.blue : Colors.grey,
                            ),
                          ),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
              SizedBox(height: 20),
              // 생년월일 표시 컨테이너
              Container(
                padding: EdgeInsets.all(16),
                decoration: BoxDecoration(
                  color: Colors.grey[200],
                  borderRadius: BorderRadius.circular(8),
                ),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text('생년월일'),
                    SizedBox(height: 8),
                    Text(
                      birthday,
                      style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                    ),
                  ],
                ),
              ),
              Spacer(),
              SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  child: Text('다음'),
                  onPressed: selectedGender != null
                      ? () {
                    print('선택된 성별: $selectedGender');
                    print('생년월일: $birthday');
                    // 다음 화면으로 이동 로직
                    Navigator.pushNamed(context, '/next_screen');
                  }
                      : null,
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
      title: 'Personal Information Input',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: PersonalInformationChooseGender(), // 홈 화면을 PersonalInformationChooseGender로 설정
      routes: {
        '/next_screen': (context) => NextScreen(), // 다음 화면으로 이동할 때 사용할 라우트
      },
    );
  }
}

void main() {
  runApp(MyApp());
}
