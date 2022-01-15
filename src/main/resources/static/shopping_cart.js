$(document).ready(function(){
    updateTotal();

     $(".minusButton").on("click", function(evt){
         evt.preventDefault();
         decreaseQuantity($(this));
    });

    $(".plusButton").on("click", function(evt){
         evt.preventDefault();
         increaseQuantity($(this));
    });
});

function decreaseQuantity(link){
    productId = link.attr("pid");
    qtyInput = $("#quantity" + productId);

    newQty = parseInt(qtyInput.val())-1;
    if(newQty>0){
        qtyInput.val(newQty);
        updateQuantity(productId,quantity);
    }
}
function increaseQuantity(link){
productId = link.attr("pid");
    qtyInput = $("#quantity" + productId);

    newQty = parseInt(qtyInput.val())+1;
    if(newQty<10){
        qtyInput.val(newQty);
        updateQuantity(productId,quantity);
    }
}
function updateQuantity(productId, quantity){
    url = contextPath + "cart/update/" + productId + "/" + quantity;

    $.ajax({
    type: "POST",
    url: url,
        beforeSend: function(xhr){
        xhr.setRequestHeader(csrfHeaderName, csrfValue);
    }
    }).done(function(newSubtotal){
    updateSubtotal();
    updateTotal();
    }).fail(function(){
    $("#modalTitle").text("Shopping Cart");
        $("#modalBody").text("Error while adding product to shopping cart");
        $("#modalBody").modal();
    });
}

function updateSubtotal(){
}

function updateTotal(){
    total= 0.0;

    $(".productSubtotal").each(function(index,element){
    total = total  + parseFloat(element.innerHTML);
    });

    $("#totalAmount").text("$" + total);
}