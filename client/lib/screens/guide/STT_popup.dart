import 'package:flutter/material.dart';

class STTPopup extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text('들은 내용:'),
      content: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          //TODO: STT (This is where the speech-to-text functionality would populate the heard message)
          Container(
            padding: EdgeInsets.all(12),
            decoration: BoxDecoration(
              color: Colors.grey[200],
              borderRadius: BorderRadius.circular(8),
            ),
            child: Text(
              '송금을 하고 싶어', // Example text; this would be replaced by the STT result
              style: TextStyle(fontSize: 18),
            ),
          ),
          SizedBox(height: 20),
          Text('송금에 관한 내용이 맞나요?'),
          SizedBox(height: 20),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              ElevatedButton(
                onPressed: () {
                  Navigator.pop(context); // Close the pop-up
                },
                child: Text('네'),
              ),
              SizedBox(width: 20),
              ElevatedButton(
                onPressed: () {
                  Navigator.pop(context); // Close the pop-up
                },
                child: Text('아니요'),
              ),
            ],
          ),
        ],
      ),
    );
  }
}