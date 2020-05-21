$(".find").click(function () {
    var id = this.id;
    $.getJSON("/user/findUserById", {"id": id}, function (data) {
        console.log(data);
    });
});

$(".update").click(function () {
    location.href = "/user/userUpdateHtml?id=" + this.id;
});
$(".delete").click(function () {
    location.href = "/user/userDelete?userId=" + this.id;
});
$("#useradd").click(function () {
    location.href = "/user/useraddHtml";
});