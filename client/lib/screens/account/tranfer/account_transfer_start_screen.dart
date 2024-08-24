import 'dart:async';
import 'package:flutter/material.dart';
import 'package:ssyrial/screens/account/tranfer/account_info_input_screen.dart';

// The first screen showing the introductory message
class AccountTransferStartScreen extends StatefulWidget {
  @override
  _AccountTransferStartScreenState createState() => _AccountTransferStartScreenState();
}

class _AccountTransferStartScreenState extends State<AccountTransferStartScreen> {
  @override
  void initState() {
    super.initState();
    // Simulate speech and automatically navigate after 3 seconds
    Timer(Duration(seconds: 3), () {
      Navigator.pop(context);
      Navigator.push(
        context,
        MaterialPageRoute(builder: (context) => AccountInfoInputScreen()),
      );
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              '안녕하세요\n송금하는 법을 알려드릴게요\n(음성 끝나면 자동으로 다음페이지)',
              textAlign: TextAlign.center,
              style: TextStyle(fontSize: 18),
            ),
            SizedBox(height: 20),
            Image.asset(
              'assets/images/moli.gif', // Replace with your image asset
              width: 150,
              height: 150,
            ),
            SizedBox(height: 30),
            ElevatedButton(
              onPressed: () {
                Navigator.pop(context); // Navigate back to previous screen
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
