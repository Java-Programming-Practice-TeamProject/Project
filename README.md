# Java Programming Team Project : Scheduler

## 실행법
1. Server.java 실행
2. StartCalendar.java 실행
user를 추가하고 싶을 때마다 StartCalendar.java 실행

## 기능
#### Calendar : 
  Schedule들을 포함한다. 색을 선택해 주별 일정을 확인할 때 그 Calendar에 포함된 일정은 선택한 색으로 표시된다.
  
  default calendar : 기본적으로 추가되어 있는 캘린더로 해당되는 주를 클릭하면 모든 캘린더의 일정을 볼 수 있다.
  1. 해당되는 주를 클릭하면 선택한 calendar에 포함된 그 주의 일정을 볼 수 있다.
  2. 해당되는 날짜를 클릭하면 선택한 calendar에 포함된 그 날의 일정을 볼 수 있다.
  3. add: calendar를 추가/삭제하거나 schedule을 추가할 수 있다.
  4. share: 다른 user에게 schedule을 공유할 수 있다.
  5. import: 선택한 calendar의 모든 schedule을 파일로 저장한다(파일 이름 : calendar name+"Calendar.txt")
  6. export: 선택한 calendar와 이름이 같은 파일에서 schedule을 가져온다.
  
#### Schedule : 하루종일인 schedule과 시작시간,종료시간이 정해진 schdule로 나뉜다.

  시간, overlap 가능 여부, important, memo, 반복여부를 설정할 수 있다.
