/**
 * 
 */

 function check() {
	 if(frm.JUMIN.value === "") {
		 alert("주민번호 입력하셈");
		 frm.JUMIN.focus();
		 return false;
	 }
	 if(frm.NAME.value === "") {
		 alert("성명 입력하셈");
		 frm.NAME.focus();
		 return false;
	 }
	 if(frm.VNUM.value === "") {
		 alert("투표 번호 입력하셈");
		 frm.VNUM.focus();
		 return false;
	 }
	 if(frm.TIME.value === "") {
		 alert("투표시간 입력하셈");
		 frm.TIME.focus();
		 return false;
	 }
	 if(frm.AREA.value === "") {
		 alert("투표 장소 입력하셈");
		 frm.AREA.focus();
		 return false;
	 }
	 if(frm.VOTER.value === "") {
		 alert("유권자 확인하셈");
		 frm.VOTER.focus();
		 return false;
	 }
 }
 
 function rollback() {
	 alert("다시 입력하셈");
	 document.getElementById('jumin').focus();
	 
 }