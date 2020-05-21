$(".find").click(function () {
    var id = this.id;
    $.getJSON("/menu/findMenuById", {"id": id}, function (data) {
        console.log(data);
    });
});

$(".update").click(function () {
    location.href = "/menu/menuUpdateHtml/" + this.id;
});
$(".delete").click(function () {
    location.href = "/menu/menuDelete?id=" + this.id;
});
$("#menuadd").click(function () {
    location.href = "/menu/menuaddHtml";
});