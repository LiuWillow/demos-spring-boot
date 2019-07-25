var stompClient = null;

function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
    });
}

//订阅echarts
stompClient.subscribe('/topic/echarts', function (data) {
    option.series[0].data[5]=data.body;
    myChart.setOption(option);
});
function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': "dawei"}));
}