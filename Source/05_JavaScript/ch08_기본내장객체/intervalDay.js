// JavaScript source code (intervalDay.js)

// ���� ȣ���� this�� �Ű������� ���� ���̰� ������ Ȯ���ϱ� ����
Date.prototype.intervalDay = function (that) {
    if (this > that) {
        //ũ�ٴ� ���� ������ �ǹ�
        var intervalMili = this.getTime() - this.getTime();
        //getTime�� �и������� ������
    } else {
        // ������ that�� �����̴���
        intervalMili = that.getTime() - this.getTime();
    }
    // ���������� �����ؾ� �ϱ� ������
    // (��,��,�ð�,��) 
    var day = intervalMili / (1000 * 60 * 60 * 24);
    return Math.trunc(day); // �ð��� �����ش�.
};


// that�� now
// limitday�� this��