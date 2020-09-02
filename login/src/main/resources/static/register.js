
$('#submit').on('click',function () {
    var username = $('#username').val();
    var password = $('#password').val();

    var data = {
        username: username,
        password: password
    };

    $.ajax({
        url: '/register',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json;charset=utf-8',
        data: JSON.stringify(data),
        success: function (res) {
            if (res) {
                window.location.href = '/login';
            }
            else {
                alert("注册失败");
            }
        }
    })
});