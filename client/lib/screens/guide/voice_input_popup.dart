import 'package:flutter/material.dart';
import 'package:ssyrial/screens/guide/STT_popup.dart';

class VoiceInputPopup extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text('어떤 도움이 필요하신가요?'),
      content: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          Text('예: 돈을 보내거야'),
          SizedBox(height: 20),
          IconButton(
            icon: Icon(Icons.mic, size: 30, color: Colors.red),
            onPressed: () {
              // Close the current pop-up and show the second pop-up
              Navigator.pop(context);
              showDialog(
                context: context,
                builder: (context) => STTPopup(),
              );
            },
          ),
        ],
      ),
    );
  }
}