import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Sign In',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        scaffoldBackgroundColor: Colors.white,
      ),
      home: SignInScreen(),
    );
  }
}

class SignInScreen extends StatefulWidget {
  @override
  _SignInScreenState createState() => _SignInScreenState();
}

class _SignInScreenState extends State<SignInScreen> {
  String password = '';

  void addNumber(String number) {
    if (password.length < 6) {
      setState(() {
        password += number;
      });
    }
  }

  void removeNumber() {
    if (password.isNotEmpty) {
      setState(() {
        password = password.substring(0, password.length - 1);
      });
    }
  }

  void clearPassword() {
    setState(() {
      password = '';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        decoration: BoxDecoration(
          border: Border.all(color: Colors.blue, width: 2),
        ),
        child: SafeArea(
          child: Column(
            children: [
              Container(
                padding: EdgeInsets.all(16),
                color: Colors.pink[50],
                child: Column(
                  children: [
                    Text(
                      '6자리 비밀번호를 \n 입력해 주세요.',
                      style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                    ),
                    SizedBox(height: 16),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: List.generate(
                        6,
                            (index) => Container(
                          width: 40, // 각 박스의 너비를 설정
                          height: 40, // 각 박스의 높이를 설정
                          margin: EdgeInsets.symmetric(horizontal: 4),
                          decoration: BoxDecoration(
                            border: Border.all(
                              color: Colors.black, // 테두리 색상 설정
                              width: 2, // 테두리 두께 설정
                            ),
                            borderRadius: BorderRadius.circular(8), // 모서리를 둥글게 설정
                          ),
                          alignment: Alignment.center, // 텍스트를 가운데 정렬
                          child: Text(
                            index < password.length ? '*' : '', // 입력된 경우 '*' 표시, 비어 있으면 빈 문자열
                            style: TextStyle(
                              fontSize: 24, // 별표 크기 설정
                              color: index < password.length ? Colors.black : Colors.grey[300], // 색상 조정
                            ),
                          ),
                        ),
                      ),
                    )
                  ],
                ),
              ),
              Expanded(
                child: Container(
                  color: Colors.pink[50],
                  child: GridView.count(
                    crossAxisCount: 3,
                    childAspectRatio: 1.5,
                    padding: EdgeInsets.all(16),
                    mainAxisSpacing: 16,
                    crossAxisSpacing: 16,
                    children: [
                      ...List.generate(
                        9,
                            (index) => ElevatedButton(
                          child: Text(
                            '${index + 1}',
                            style: TextStyle(
                              fontWeight: FontWeight.bold, // 볼드체 설정
                              fontSize: 20, // 폰트 크기 설정
                              color: Colors.white,
                            ),
                          ),
                          onPressed: () => addNumber('${index + 1}'),
                          style: ElevatedButton.styleFrom(backgroundColor: Colors.green),
                        ),
                      ),
                      ElevatedButton(
                        child: Text(
                          '재배열',
                          style: TextStyle(
                            fontWeight: FontWeight.bold, // 볼드체 설정
                            fontSize: 24, // 폰트 크기 설정
                          ),
                        ),
                        onPressed: () {
                          // 비밀번호 초기화 로직
                          setState(() {
                            password = ''; // 비밀번호를 초기화
                          });
                          print('비밀번호가 초기화되었습니다.');
                        },
                        style: ElevatedButton.styleFrom(
                          backgroundColor: Colors.grey, // 배경색 설정
                          minimumSize: Size(double.infinity, 60), // 최소 높이 설정
                        ),
                      ),
                      ElevatedButton(
                        child: Text('0'),
                        onPressed: () => addNumber('0'),
                        style: ElevatedButton.styleFrom(backgroundColor: Colors.green),
                      ),
                      ElevatedButton(
                        child: Text(
                          ' 하나\n지우기',
                          style: TextStyle(
                            fontWeight: FontWeight.bold, // 볼드체 설정
                            fontSize: 24, // 폰트 크기 설정
                          ),
                        ),
                        onPressed: removeNumber,
                        style: ElevatedButton.styleFrom(
                          backgroundColor: Colors.grey, // 배경색 설정
                          minimumSize: Size(double.infinity, 60), // 최소 높이 설정
                        ),
                      ),
                    ],
                  ),
                ),
              ),
              Row(
                children: [
                  // 왼쪽 '취소' 버튼 (빨간색)
                  Expanded(
                    child: ElevatedButton(
                      child: Text('취소'),
                      onPressed: () {
                        // 취소 버튼 로직
                        print('취소 버튼 클릭됨');
                      },
                      style: ElevatedButton.styleFrom(
                        backgroundColor: Colors.red,
                        minimumSize: Size(double.infinity, 60), // 최소 높이 설정
                      ),
                    ),
                  ),
                  SizedBox(width: 16), // 두 박스 사이의 간격
                  // 오른쪽 '완료' 버튼 (파란색)
                  Expanded(
                    child: ElevatedButton(
                      child: Text('완료'),
                      onPressed: () {
                        // 완료 버튼 로직
                        print('완료 버튼 클릭됨');
                      },
                      style: ElevatedButton.styleFrom(
                        backgroundColor: Colors.blue,
                        minimumSize: Size(double.infinity, 60), // 최소 높이 설정
                      ),
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
}
