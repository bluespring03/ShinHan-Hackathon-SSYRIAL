import 'package:flutter/material.dart';

class AccountInfoInputScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              '돈을 받는 통장의 정보를 입력해 주세요.',
              style: TextStyle(fontSize: 18),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                // Handle bank selection
              },
              child: Text('은행 선택하기'),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                // Handle account number input
              },
              child: Text('계좌번호 입력하기'),
            ),
            SizedBox(height: 40),
            ElevatedButton(
              onPressed: () {
                Navigator.pop(context); // Navigate back to the previous screen
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.grey, // Back button color
              ),
              child: Text('돌아가기'),
            ),
          ],
        ),
      ),
    );
  }
}
