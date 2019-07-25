<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <link href="css/app.css" rel="stylesheet">
    <link crossorigin="anonymous" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" rel="stylesheet">

    <title>Rent car</title>
</head>
<body>

<header>
    <jsp:include page="/header.jsp"/>
</header>
<div class="container-fluid">
    <div class="row">
        <aside class="col-xs-12 col-sm-4 col-md-3 col-lg-2">
            <jsp:include page="/aside.jsp"/>
        </aside>
        <main class="col-xs-12 col-sm-8 col-md-9 col-lg-10">
            <jsp:include page="${currentPage}"/>
        </main>
    </div>
</div>
<footer class="footer">
    <jsp:include page="/footer.jsp"/>
</footer>
<script crossorigin="anonymous"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script crossorigin="anonymous"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script crossorigin="anonymous"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>

    const buyItemButtons = $("[name='buyItem']");
    buyItemButtons.click(buyItem);

    function buyItem(event) {
        let carId = $(event.target).attr('id');
        $.post('./addToCart', { 'id': carId }).done(function(data) {
             window.location.reload();
        });
    }


</script>

<script type="text/javascript">
        const $editItemQuantityInputs = $("[name='editItemQuantityInput']");
        const $totalCost = $('#totalCost');
        $editItemQuantityInputs.change(changeItemQuantity);
        function changeItemQuantity(event) {
            let id = $(event.target).attr('id');
            let count = $(event.target).val();
            $.post("./shopping-cart", { id: id, count: count }).done(function(data) {
                $(event.target).parent().prev().text(data.itemPrice );
                $totalCost.text(data.totalPrice );
            });
        }

</script>

<script>
    const deleteButton = $("[name='deleteItem']");
    deleteButton.click(deleteItem);

      function deleteItem(event) {
        let Id = $(event.target).attr('data-id-product');
        $.post('./deleteFromCart', { 'id': Id }).done(function(data) {
           window.location.reload();
        });
    }


</script>

</body>
</html>