import 'package:flutter/material.dart';

class STTScreen extends StatefulWidget {
  final TextStyle? questionTextStyle; // 질문 텍스트 스타일
  final TextStyle? detectedTextStyle; // 음성 인식된 텍스트 스타일
  final Color micIconColor; // 마이크 아이콘 색상
  final double micIconSize; // 마이크 아이콘 크기
  final EdgeInsetsGeometry padding; // 전체 화면 패딩

  const STTScreen({
    Key? key,
    this.questionTextStyle,
    this.detectedTextStyle,
    this.micIconColor = Colors.red, // 기본 마이크 아이콘 색상
    this.micIconSize = 30.0, // 기본 마이크 아이콘 크기
    this.padding = const EdgeInsets.all(16.0), // 기본 패딩
  }) : super(key: key);

  @override
  _STTScreenState createState() => _STTScreenState();
}

class _STTScreenState extends State<STTScreen> {
  String detectedText = ""; // 실시간 STT 텍스트
  String questionText = ""; // 질문 텍스트
  bool isRecording = true; // 녹음 상태
  int sttCounter = 0; // 시뮬레이션을 위한 카운터

  @override
  void initState() {
    super.initState();
    startRecording(); // 녹음 시작
  }

  // 실제 STT 기능 구현을 위해 녹음을 시작하는 함수
  void startRecording() {
    // TODO: 실제 STT 시작 로직 구현
    simulateSTT(); // STT 결과를 시뮬레이션
  }

  // STT 결과를 시뮬레이션하는 함수
  void simulateSTT() {
    // 1초마다 "송금"과 "통장 정리"를 번갈아가며 표시
    Future.delayed(Duration(seconds: 1), () {
      setState(() {
        if (sttCounter % 2 == 0) {
          detectedText = "송금";
        } else {
          detectedText = "통장 정리";
        }
        sttCounter++;
        if (isRecording) {
          simulateSTT(); // 계속해서 시뮬레이션 반복
        }
      });
    });
  }

  // 녹음이 끝난 후 확인 상태로 전환하는 함수
  void stopRecording() {
    setState(() {
      isRecording = false; // 녹음 중지
      updateQuestionText(); // 질문 텍스트 업데이트
    });
  }

  // 인식된 텍스트에 따라 질문 텍스트를 업데이트하는 함수
  void updateQuestionText() {
    if (detectedText.contains("송금")) {
      questionText = "송금에 관한 내용이 맞나요?";
    } else if (detectedText.contains("통장 정리")) {
      questionText = "통장 정리에 관한 내용이 맞나요?";
    } else {
      questionText = "이 내용이 맞나요?";
    }
  }

  // 녹음을 다시 시작하는 함수
  void restartRecording() {
    setState(() {
      isRecording = true;
      detectedText = ""; // STT 텍스트 초기화
      sttCounter = 0; // 카운터 초기화
    });
    startRecording(); // STT 재시작
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: widget.padding, // 전체 화면의 패딩 설정
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          buildImage(), // 이미지 빌드
          SizedBox(height: 20),
          buildSTTContainer(), // STT 결과 빌드
          SizedBox(height: 20),
          isRecording ? buildRecordingButton() : buildConfirmationSection(), // 녹음 중인지 확인에 따라 버튼 표시
        ],
      ),
    );
  }

  // 이미지를 빌드하는 함수
  Widget buildImage() {
    return Image.asset(
      'assets/images/moli.gif', // 예시 이미지
      width: 100,
      height: 100,
    );
  }

  // STT 결과 텍스트를 표시하는 컨테이너 빌드 함수
  Widget buildSTTContainer() {
    return Container(
      padding: EdgeInsets.all(12),
      decoration: BoxDecoration(
        color: Colors.grey[200],
        borderRadius: BorderRadius.circular(8),
      ),
      child: Text(
        "들은 내용: $detectedText", // 녹음 중 또는 STT 결과 표시
        style: widget.detectedTextStyle ?? TextStyle(fontSize: 18),
      ),
    );
  }

  // 녹음 버튼을 빌드하는 함수
  Widget buildRecordingButton() {
    return IconButton(
      icon: Icon(
        Icons.mic,
        size: widget.micIconSize,
        color: widget.micIconColor,
      ),
      onPressed: stopRecording, // 녹음 중지 및 확인 상태로 전환
    );
  }

  // 녹음 후 확인 섹션을 빌드하는 함수
  Widget buildConfirmationSection() {
    return Column(
      children: [
        Text(
          questionText, // 질문 텍스트 표시
          style: widget.questionTextStyle ?? TextStyle(fontSize: 18),
        ),
        SizedBox(height: 20),
        buildConfirmationButtons(), // 확인 버튼 빌드
      ],
    );
  }

  // 확인 버튼들을 빌드하는 함수
  Widget buildConfirmationButtons() {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        ElevatedButton(
          onPressed: () {
            Navigator.pop(context); // "네" 버튼 클릭 시 화면 종료
          },
          child: Text("네"),
          style: ElevatedButton.styleFrom(
            backgroundColor: Colors.blue, // "네" 버튼 색상 설정
          ),
        ),
        SizedBox(width: 20),
        ElevatedButton(
          onPressed: restartRecording, // "아니요" 버튼 클릭 시 녹음 재시작
          child: Text("아니요"),
          style: ElevatedButton.styleFrom(
            backgroundColor: Colors.grey, // "아니요" 버튼 색상 설정
          ),
        ),
      ],
    );
  }
}
