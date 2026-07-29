/**
 * ex04_script.js 
 */

function nameAlert(name){
	alert(`${name}님 환영합니다.`);
}

function getRndNumber(min, max){
	return Math.floor(Math.random() * (max-min+1)) + min;
}

function getDayOfWeek(year, month, day){
	const d = new Date(year, month-1, day);
	return d.getDay();
}

function getLastDay(year,month){
	// 1달 더하고, 하루는 빼기
	const d = new Date(year,month,0);
	return d.getDate();
}

// 달력을 그릴 때 1일 요일과 마지막 날짜를 반환
function getCalendarInfo(year, month ){
   const first = new Date(year, month-1, 1 );
   //let firstDay = first.getDay();
   
   const last = new Date(year, month, 0 );
   //let lastDate = last.getDate();
   
   return {
      firstDay: first.getDay(),  // 0~6
      lastDate: last.getDate()   // 28,29,30,31
   };
}

function getCalendarInfo2(year, month ){
   const first = new Date(year, month-1, 1 );
   //let firstDay = first.getDay();
   
   const last = new Date(year, month, 0 );
   //let lastDate = last.getDate();
   
   return [ first.getDay(),   last.getDate() ];
}