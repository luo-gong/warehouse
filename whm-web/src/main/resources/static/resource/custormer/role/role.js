$("#roleadd").click(function () {
    location.href = "/role/addRoleHtml";
});
$(".update").click(function () {
    location.href = "/role/updateRoleHtml/" + this.id;
});

$(".delete").click(function () {
    location.href = "/role/roleDelete?rid=" + this.id;
});
