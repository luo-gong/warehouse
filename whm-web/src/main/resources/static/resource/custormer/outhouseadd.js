$("input[name='productId']:first").click(function () {
    if ($("input[name='productId']").prop("checked")) {
        $("input[name='productId']").prop("checked", false);
    } else {
        $("input[name='productId']").prop("checked", true);
    }
});


function productClone() {
    console.log("outhouseadd.js");
    var productCode = $("#productCode");
    var productName = $("#productName");//商品名称
    if (productCode) {
        productCode = productCode.val();//商品编码
    }
    if (productName) {
        productName = productName.val();//商品编码
    }
    $.getJSON("/outhouse/outhouseadd/productByProduct", {
        "productCode": productCode,
        "productName": productName
    }, function (data) {
        console.log(data);
        $(".productTr:eq(0)").nextAll().remove();
        $(data).each(function (index, ele) {
            var productTr = $(".productTr:first").clone();
            productTr.children("td:first").children("input").attr("name", "orders[" + index + "].productId").val(ele.productId);
            productTr.children("td:eq(1)").html("<input type='hidden' name='orders[" + index + "].productName' value='" + ele.productName + "'>" + ele.productName);
            productTr.children("td:eq(2)").html("<input type='hidden' name='orders[" + index + "].productCode' value='" + ele.productCode + "'>" + ele.productCode);
            productTr.children("td:eq(3)").html("<input type='hidden' name='orders[" + index + "].productSpec'>" + ele.productSpec);
            productTr.children("td:eq(4)").html("<input  type='text' name='orders[" + index + "].productBatch' placeholder='批次'>");
            productTr.children("td:eq(5)").html("<input onblur='priceEnvet(this)' type='text' name='orders[" + index + "].productPrice' placeholder='输入单价'>");
            productTr.children("td:eq(6)").html("<input onblur='outNumberEnvet(this)' type='text' name='orders[" + index + "].orderNumber' placeholder='输入出库数'>");
            productTr.children("td:eq(7)").html("<input type='text' value='' readonly name='orders[" + index + "].orderProductPriceSum'>");
            var storehouseStr = "<option value='1'>请选择库位</option>";
            $(ele.storehouselist).each(function (index1, ele1) {
                storehouseStr += "<option value='" + ele1.stockId + "'>" + ele1.storehouseName + "</option>"
            });
            productTr.children("td:eq(8)").html("<select  name='orders[" + index + "].storehouseId'>" + storehouseStr + "<seletc/>");
            $(".productTr:last").after(productTr);
        });
    });
}

$("#product_input").click(productClone);

function outNumberEnvet(ele) {
    var inNum = $(ele).val();
    if (inNum) {
        inNum = parseInt(inNum);
        var price = parseFloat($(ele).parent().prev().children().val());
        $(ele).parent().next().children().val(price * inNum);
    }
    console.log("outNumberEnvet");
}

function priceEnvet(ele) {
    var price = $(ele).val();
    if (price) {
        price = parseFloat(price);
        var inNum = parseFloat($(ele).parent().next().children().val());
        $(ele).parent().next().next().children().val(price * inNum);
    }
    console.log("priceEnvet");
}

/*$("#table").no("blur", ".productTr td:eq(6) input", {}, function () {
    var inNum = $(this).val();
    inNum = parseInt(inNum);
    var price = parseFloat($(this).prev().val());
    $(this).next().val(price * inNum);

});*/
productClone();

//客户编号选择
$("#customerCode_select").change(function () {
    var customerCode = $(this).val();
    $.getJSON("/outhouse/customerCodeSelect", {
        "customerCode": customerCode
    }, function (data) {
        $("#customerPhone_input").val(data.customerPhone);
        $("#customerContactName_input").val(data.customerContactname);
        $("#customerName_input").val(data.customerName);
        $("#customerId_input").val(data.customerId);
    });

});