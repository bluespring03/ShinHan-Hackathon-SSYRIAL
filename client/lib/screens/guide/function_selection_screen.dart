import 'package:flutter/material.dart';

class FunctionSelectionScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('SSYRIAL_MAIN'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text('도움이 필요한 기능을 선택해 주세요'),
            SizedBox(height: 20),
            GridView.count(
              crossAxisCount: 2,
              shrinkWrap: true,
              childAspectRatio: 3,
              mainAxisSpacing: 16,
              crossAxisSpacing: 16,
              children: [
                ElevatedButton(
                  onPressed: () {},
                  child: Text('돈 넣기'),
                  style: ElevatedButton.styleFrom(backgroundColor: Colors.green),
                ),
                ElevatedButton(
                  onPressed: () {},
                  child: Text('돈 찾기'),
                  style: ElevatedButton.styleFrom(backgroundColor: Colors.green),
                ),
                ElevatedButton(
                  onPressed: () {},
                  child: Text('돈 보내기'),
                  style: ElevatedButton.styleFrom(backgroundColor: Colors.green),
                ),
                ElevatedButton(
                  onPressed: () {},
                  child: Text('통장 조회'),
                  style: ElevatedButton.styleFrom(backgroundColor: Colors.green),
                ),
              ],
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {},
              child: Text('다른 기능 찾기'),
              style: ElevatedButton.styleFrom(backgroundColor: Colors.orange),
            ),
            Spacer(),
            Text('또는 버튼을 누르고 말해보세요'),
            IconButton(
              icon: Icon(Icons.mic),
              onPressed: () {
                // Microphone action
              },
            ),
          ],
        ),
      ),
    );
  }
}
