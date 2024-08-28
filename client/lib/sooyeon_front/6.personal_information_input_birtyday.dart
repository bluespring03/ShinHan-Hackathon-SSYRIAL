import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

// PersonalInformationInputBirthday 클래스 정의
class PersonalInformationInputBirthday extends StatefulWidget {
  final String initialName;

  PersonalInformationInputBirthday({required this.initialName});

  @override
  _PersonalInformationInputBirthdayState createState() => _PersonalInformationInputBirthdayState();
}

class _PersonalInformationInputBirthdayState extends State<PersonalInformationInputBirthday> {
  TextEditingController _birthdayController = TextEditingController();
  late TextEditingController _nameController;

  @override
  void initState() {
    super.initState();
    // 초기 이름 설정
    _nameController = TextEditingController(text: widget.initialName);
  }

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
                '생년월일을 입력해주세요.',
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
              ),
              SizedBox(height: 20),
              // 생년월일 입력 컨테이너
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
                    TextField(
                      controller: _birthdayController,
                      decoration: InputDecoration(
                        hintText: '입력해 주세요.',
                        border: InputBorder.none,
                        filled: true,
                        fillColor: Colors.white,
                      ),
                      keyboardType: TextInputType.number,
                      inputFormatters: [
                        FilteringTextInputFormatter.digitsOnly,
                        LengthLimitingTextInputFormatter(6),
                      ],
                      onChanged: (value) {
                        setState(() {});
                      },
                    ),
                  ],
                ),
              ),
              SizedBox(height: 20),
              // 이름 입력 컨테이너
              Container(
                padding: EdgeInsets.all(16),
                decoration: BoxDecoration(
                  color: Colors.grey[200],
                  borderRadius: BorderRadius.circular(8),
                ),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text('이름'),
                    SizedBox(height: 8),
                    TextField(
                      controller: _nameController,
                      decoration: InputDecoration(
                        hintText: '입력해 주세요.',
                        border: InputBorder.none,
                        filled: true,
                        fillColor: Colors.white,
                      ),
                      onChanged: (value) {
                        setState(() {});
                      },
                    ),
                  ],
                ),
              ),
              Spacer(),
              SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  child: Text('다음'),
                  onPressed: (_birthdayController.text.length == 6 && _nameController.text.isNotEmpty)
                      ? () {
                    print('생년월일: ${_birthdayController.text}');
                    print('이름: ${_nameController.text}');
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

  @override
  void dispose() {
    _birthdayController.dispose();
    _nameController.dispose();
    super.dispose();
  }
}

// MyApp 클래스 정의
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Personal Information Input',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: PersonalInformationInputBirthday(initialName: '홍길동'), // 하드코딩된 이름을 전달
      routes: {
        '/next_screen': (context) => NextScreen(), // 다음 화면으로 이동할 때 사용할 라우트
      },
    );
  }
}

// NextScreen 클래스 정의 (다음 화면 예시)
class NextScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Next Screen')),
      body: Center(child: Text('This is the next screen!')),
    );
  }
}

// main 함수
void main() {
  runApp(MyApp());
}
