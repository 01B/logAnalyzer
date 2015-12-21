# logAnalyzer
D모 회사의 코딩테스트입니다.

문제 해결을 위한 코딩 시간은 24시간 정도 걸렸습니다.
OOP의 강점을 살리기 위해 노력하였습니다.

* 프로그램 개요
	- 로그 분석을 위한 프로그램을 만든다.
	- input.log 파일의 로그를 분석하여 output.log 파일을 생성한다.
	- output.log 파일은 다음과 같은 분석 결과를 출력한다.
		1. 최다호출 APIKEY
		2. (호출 횟수 기준)상위 3개의 API ServiceID와 각각의 요청 수
		3. 웹브라우저별 사용 비율

	
* 프로그램 개발 순서
	1. Domain 설계
	2. 클래스 간의 구조 설계
	3. 코딩


* 클래스 설명

	1. IO
		LogReader : 로그 데이터를 input.log 에서 읽습니다.
		LogWriter : 로그 분석 결과를 output.log 에 씁니다.

	2. Util
		Parser : 불러온 로그 정보를 분석하기 쉽게 데이터를 파싱힙니다.
		Formatter : 파싱된 데이터 정보를 토대로 자료구조와 서식을 만듦니다.

	3. Domain
		Log : 로그 한 줄의 정보를 담고 있습니다.
		UrlInfo : 로그 데이터 중 URL 에 해당하는 정보를 담고 있습니다.

* 주요 문제 해결
	1. input 로그 정보 저장(parser)
		=> URL 정보(UrlInfo class)를 포함한 모든 log 정보(Log class)를 Status 값을 기준으로 Map<Status, List<Log>> 의 자료구조에 저장하였습니다.

	2. 1에서 저장한 정보를 출력에 알맞는 자료구조로 변환(formatter)
		=> API key 호출 횟수, API ServiceID 요청 수, 그리고 브라우져별 사용 비율을 계산하고 서로 비교하기 위해 Comparator Interface 를 상속받아 사용하였습니다. 
		또한, 관점 분리 방식의 Interface 를 통해 Template pattern 을 사용하였습니다.

* 참고 : input.log, output.log 모두 프로젝트 root 폴더에 있습니다.
* 주의사항 : output.log 가 바뀌어도 IDE 내에서는 synchronize 하지 않으면 변경사항이 제대로 보이지 않는 경우가 있습니다. 반드시, 탐색기에서 확인하시거나 동기화 하신 후에 확인해 주세요.
