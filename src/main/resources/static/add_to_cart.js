$(document).ready(function(){
   $("#buttonAdd2Cart").on("click", function(e){
   addToCart();
   });
});

function addToCart(){
    var contextPath = "/";
    var csrfHeaderName = "[[${_csrf.headerName}]]";
    var csrfValue = "[[${_csrf.token}]]";
     var productId = $(this).attr("productId");

     var quantity = $("#quantity" + productId).val();
    alert(quantity);
    let url = "http://localhost:8080/cart/add/" + productId + "/" + quantity;
    alert(csrfHeaderName + productId);
    $.ajaxSetup({
        headers:
            { 'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content') }
    });

    $.ajax({
    method: "POST",
    url: url

    }).done(function(response){
    $("#modalTitle").text("Shopping Cart");
    $("#modalBody").text(response);
    $("#myModal").modal();
    }).fail(function(){
    $("#modalTitle").text("Shopping Cart");
        $("#modalBody").text("Error while adding product to shopping cart");
        $("#modalBody").modal();
    });
}