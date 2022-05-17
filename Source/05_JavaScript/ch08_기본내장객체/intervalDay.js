// JavaScript source code (intervalDay.js)

// 나를 호출한 this와 매개변수가 몇일 차이가 나는지 확인하기 위함
Date.prototype.intervalDay = function (that) {
    if (this > that) {
        //크다는 것은 나중을 의미
        var intervalMili = this.getTime() - this.getTime();
        //getTime이 밀리세컨을 가져옴
    } else {
        // 같던지 that이 나중이던지
        intervalMili = that.getTime() - this.getTime();
    }
    // 몇일인지를 리턴해야 하기 때문에
    // (초,분,시간,일) 
    var day = intervalMili / (1000 * 60 * 60 * 24);
    return Math.trunc(day); // 시간은 버려준다.
};


// that은 now
// limitday는 this로