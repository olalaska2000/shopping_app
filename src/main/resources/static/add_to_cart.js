$(document).ready(function(){
   $("#buttonAdd2Cart").on("click", function(e){
   addToCart();
   });
});

function addToCart(){
      var productId = "[[${product.id}]]";
      var contextPath = "[[@{/}]]";
      var csrfHeaderName = "[[${_csrf.headerName}]]";
      var csrfValue = "[[${_csrf.token}]]";

    quantity = $("#quantity" + productId).val();
    alert(quantity);
    url = contextPath + "cart/add/" + productId + "/" + quantity;

    $.ajax({
    type: "POST",
    url: url,
                beforeSend: function(xhr){
                xhr.setRequestHeader(csrfHeaderName, csrfValue);
                }
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