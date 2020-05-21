function aClick(ele) {
    var current = ele.id;
    var productCode = $("#productCode");
    var warehouseId = $("#warehouseId");
    var productName = $("#productName");
    var productBatch = $("#productBatch");
    location.href = "/stock/stockHtml?" +
        "productCode=" + productCode.val() +
        "&warehouseId=" + warehouseId.val() +
        "&productName=" + productName.val() +
        "&current=" + current +
        "&productBatch=" + productBatch.val();
}