import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: MoneyTransferScreen(),
    );
  }
}

class MoneyTransferScreen extends StatefulWidget {
  @override
  _MoneyTransferScreenState createState() => _MoneyTransferScreenState();
}

class _MoneyTransferScreenState extends State<MoneyTransferScreen> {
  // API에서 가져올 잔고 값을 저장하는 변수
  int balance = 10000; // 초기값은 예시용
  TextEditingController _controller = TextEditingController();

  @override
  void initState() {
    super.initState();
    _fetchBalance();
  }

  // API에서 잔고 값을 가져오는 함수
  void _fetchBalance() async {
    // 실제 API 호출은 여기서 진행
    // 예시를 위해 10000으로 설정
    setState(() {
      balance = 10000; // API로부터 가져온 값으로 변경
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: TextButton(
          child: Text('돌아가기',),
          onPressed: () {
            Navigator.pop(context); // 돌아가기 버튼 클릭 시 스크린 팝
          },
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text('얼마를 보낼까요?'),
            SizedBox(height: 16),
            _buildBox(),
            Spacer(),
            _buildSendButton(),
          ],
        ),
      ),
    );
  }

  Widget _buildBox() {
    return Container(
      padding: EdgeInsets.all(16),
      decoration: BoxDecoration(
        border: Border.all(color: Colors.grey),
        borderRadius: BorderRadius.circular(8),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          _buildMiniBox1(),
          SizedBox(height: 16),
          _buildMiniBox2(),
        ],
      ),
    );
  }

  Widget _buildMiniBox1() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text('남은돈'),
        Text('잔고: $balance 원'), // 잔고 표시
      ],
    );
  }

  Widget _buildMiniBox2() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text('보낼돈'),
        TextField(
          controller: _controller,
          keyboardType: TextInputType.number, // 숫자 패드
          decoration: InputDecoration(
            hintText: '금액을 입력하세요',
          ),
        ),
      ],
    );
  }

  Widget _buildSendButton() {
    return Visibility(
      visible: true, // 필요에 따라 변경 가능
      child: ElevatedButton(
        onPressed: () {
          _showConfirmationDialog();
        },
        child: Text('보내기'),
      ),
    );
  }

  void _showConfirmationDialog() {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('확인'),
          content: Text('보내기를 하시겠습니까?'),
          actions: [
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
              },
              child: Text('취소'),
            ),
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
                // 실제 전송 로직 추가
              },
              child: Text('확인'),
            ),
          ],
        );
      },
    );
  }
}
