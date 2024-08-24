import 'package:flutter/material.dart';
import 'screens/home_screen.dart';

void main() {
  runApp(SSYRIALApp());
}

class SSYRIALApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'SSYRIAL',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: HomeScreen(),
    );
  }
}
