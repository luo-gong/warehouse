function aClick(ele) {
    var current = ele.id;
    var productCode = $("#productCode");
    var warehouseEndId = $("#warehouseEndId");
    var productName = $("#productName");
    var productBatch = $("#productBatch");
    location.href = "/ledger/ledgerHtml?" +
        "productCode=" + productCode.val() +
        "&warehouseEndId=" + warehouseEndId.val() +
        "&productName=" + productName.val() +
        "&current=" + current +
        "&productBatch=" + productBatch.val();

}