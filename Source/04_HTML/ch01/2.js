// JavaScript source code
name = '홍길동'; // 한글자, 여러글자 상관없이 홑따옴표 사용
name = 10;

name = prompt("너의 이름이 뭐니? ", "Hong길동"); /* alert팝업 띄우고 이름 물어보는 창 생성 */

if (name != 'null') {
    document.write(name + "~ Welcome 반가워! <br>"); // body부분에 추가해서 이름을 적어놓는 것
}

// jsp에서 입력한 것은 현재 모두 깨져있다. utf-8코드 설정을 안해놨기 때문에.
// 메모장에서 ANSI를 UTF-8로 실행을 한다.