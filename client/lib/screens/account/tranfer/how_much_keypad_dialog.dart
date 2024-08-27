import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: MainScreen(),
    );
  }
}

class MainScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('입력 팝업'),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            showDialog(
              context: context,
              builder: (BuildContext context) {
                return InputPopup();
              },
            );
          },
          child: Text('팝업 열기'),
        ),
      ),
    );
  }
}

class InputPopup extends StatefulWidget {
  @override
  _InputPopupState createState() => _InputPopupState();
}

class _InputPopupState extends State<InputPopup> {
  String inputText = ''; // 박스1.텍스트 위젯에 표시될 문자열

  void _addDigit(String digit) {
    setState(() {
      inputText += digit; // 입력한 숫자를 추가
    });
  }

  void _clearText() {
    setState(() {
      inputText = ''; // 텍스트 위젯 클리어
    });
  }

  void _deleteLastCharacter() {
    setState(() {
      if (inputText.isNotEmpty) {
        inputText = inputText.substring(0, inputText.length - 1); // 마지막 글자 삭제
      }
    });
  }

  void _onCancel() {
    Navigator.of(context).pop(); // 현재 팝업이 사라지게 함
  }

  void _onComplete() {
    // 여기에 send_money_screen.dart의 미니박스2.텍스트위젯에 데이터를 입력하는 로직을 추가하세요
    Navigator.of(context).pop(); // 팝업을 닫음
  }

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      content: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          // 박스1 - 텍스트 위젯
          Container(
            padding: EdgeInsets.all(16),
            child: Text(inputText, style: TextStyle(fontSize: 24)),
          ),
          SizedBox(height: 10),
          // 박스2 - 버튼들
          Column(
            children: [
              // row1
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: [
                  _buildNumberButton('1'),
                  _buildNumberButton('2'),
                  _buildNumberButton('3'),
                ],
              ),
              // row2
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: [
                  _buildNumberButton('4'),
                  _buildNumberButton('5'),
                  _buildNumberButton('6'),
                ],
              ),
              // row3
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: [
                  _buildNumberButton('7'),
                  _buildNumberButton('8'),
                  _buildNumberButton('9'),
                ],
              ),
              // row4
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: [
                  ElevatedButton(
                    onPressed: _clearText,
                    child: Text('모두 지우기'),
                  ),
                  _buildNumberButton('0'),
                  ElevatedButton(
                    onPressed: _deleteLastCharacter,
                    child: Text('하나 지우기'),
                  ),
                ],
              ),
            ],
          ),
          SizedBox(height: 10),
          // 박스3 - 취소 및 완료 버튼
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              ElevatedButton(
                onPressed: _onCancel,
                child: Text('취소'),
              ),
              ElevatedButton(
                onPressed: _onComplete,
                child: Text('완료'),
              ),
            ],
          ),
        ],
      ),
    );
  }

  // 숫자 버튼 생성 메서드
  Widget _buildNumberButton(String number) {
    return ElevatedButton(
      onPressed: () => _addDigit(number),
      child: Text(number),
    );
  }
}
