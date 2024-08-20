import 'package:flutter/material.dart';
import 'mission_type_selection_page.dart';

class MissionDifficultySelectionPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Select Mission Difficulty'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => MissionTypeSelectionPage()),
                );
              },
              child: Text('Basic'),
            ),
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => MissionTypeSelectionPage()),
                );
              },
              child: Text('Intermediate'),
            ),
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => MissionTypeSelectionPage()),
                );
              },
              child: Text('Advanced'),
            ),
          ],
        ),
      ),
    );
  }
}
