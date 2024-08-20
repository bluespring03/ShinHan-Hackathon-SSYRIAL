import 'package:flutter/material.dart';

class MissionPage extends StatelessWidget {
  final String missionName;

  MissionPage({required this.missionName});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        title: Text('Mission Page'),
      ),
      body: Center(
        child: Text(
          missionName,
          style: TextStyle(
            fontSize: 24.0,
            fontWeight: FontWeight.bold,
            color: Colors.black,
          ),
        ),
      ),
    );
  }
}
