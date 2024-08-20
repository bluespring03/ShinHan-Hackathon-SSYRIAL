import 'package:flutter/material.dart';
import 'mission_page.dart';

class MissionTypeSelectionPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Select Mission Type'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => MissionPage(missionName: 'Mission 1')),
                );
              },
              child: Text('Mission 1'),
            ),
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => MissionPage(missionName: 'Mission 2')),
                );
              },
              child: Text('Mission 2'),
            ),
          ],
        ),
      ),
    );
  }
}
