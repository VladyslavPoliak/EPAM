;$(function () {
    var init = function () {
        initBuyBtn();
        $('#addProductPopup .cost').text('$ ');
        $('#addToCart').click(addProductToCart);
        $('#addProductPopup .count').change(calculateCost);
        $('.remove-product').click(removeProductFromCart);
        $('.post-request').click(function () {
            postRequest($(this).attr('data-url'));
        });
    };

    var showAddProductPopup = function () {
        var idProduct = $(this).attr('data-id-product');
        var product = $('#product' + idProduct);
        $('#addProductPopup').attr('data-id-product', idProduct);
        $('#addProductPopup .product-image').attr('src', product.find('.thumbnail img').attr('src'));
        $('#addProductPopup .name').text(product.find('.name').text());
        var price = product.find('.price').text();
        $('#addProductPopup .price').text(price);
        $('#addProductPopup .category').text(product.find('.category').text());
        $('#addProductPopup .producer').text(product.find('.producer').text());
        $('#addProductPopup .count').val(1);
        $('#addProductPopup .cost').text(price);
        $('#addToCart').removeClass('hidden');
        $('#addToCartIndicator').addClass('hidden');
        $('#addProductPopup').modal({
            show: true
        });
    };
    var postRequest = function (url) {
        var form = '<form id="postRequestForm" action="' + url + '" method="post"></form>';
        $('body').append(form);
        $('#postRequestForm').submit();
    };

    var initBuyBtn = function () {
        $('.buy-btn').click(showAddProductPopup);
    };

    var addProductToCart = function () {
        var idProduct = $('#addProductPopup').attr('data-id-product');
        var count = $('#addProductPopup .count').val();
        var btn = $('#addToCart');
        convertButtonToLoader(btn, 'btn-primary');
        $.ajax({
            url: '/ajax/json/car/add',
            method: 'POST',
            data: {
                idCar: idProduct,
                days: count
            },
            success: function (data) {
                $('#currentShoppingCart .total-count').text(data.totalCount);
                $('#currentShoppingCart .total-cost').text(data.totalCost);
                $('#currentShoppingCart').removeClass('hidden');
                convertLoaderToButton(btn, 'btn-primary', addProductToCart);
                $('#addProductPopup').modal('hide');
            },
            error : function(xhr) {
                convertLoaderToButton(btn, 'btn-primary', addProductToCart);
                if (xhr.status == 400) {
                    alert(xhr.responseJSON.message);
                } else {
                    alert('Error');
                }
            }
        });
    };
    var calculateCost = function () {
        var driver = $("input[name=driver]:checked").val();
        var priceStr = $('#addProductPopup .price').text();
        var price = parseFloat(priceStr.replace('$', ' '));
        var count = parseInt($('#addProductPopup .count').val());
        var min = parseInt($('#addProductPopup .count').attr('min'));
        var max = parseInt($('#addProductPopup .count').attr('max'));
        if (count >= min && count <= max) {
            var cost = price * count * driver;
            $('#addProductPopup .cost').text(cost + ' UAH');
        } else {
            $('#addProductPopup .count').val(1);
            $('#addProductPopup .cost').text(priceStr);
        }
    };
    var convertButtonToLoader = function (btn, btnClass) {
        btn.removeClass(btnClass);
        btn.removeClass('btn');
        btn.addClass('load-indicator');
        var text = btn.text();
        btn.text('');
        btn.attr('data-btn-text', text);
        btn.off('click');
    };
    var convertLoaderToButton = function (btn, btnClass, actionClick) {
        btn.removeClass('load-indicator');
        btn.addClass('btn');
        btn.addClass(btnClass);
        btn.text(btn.attr('data-btn-text'));
        btn.removeAttr('data-btn-text');
        btn.click(actionClick);
    };


    var confirm = function (msg, okFunction) {
        if (window.confirm(msg)) {
            okFunction();
        }
    };

    var removeProductFromCart = function () {
        var btn = $(this);
        confirm('Are you sure?', function () {
            executeRemoveProduct(btn);
        });
    };
    var refreshTotalCost = function () {
        var total = 0;
        $('#shoppingCart .item').each(function (index, value) {
            var count = parseInt($(value).find('.count').text());
            var price = parseFloat($(value).find('.price').text().replace('$', ' '));
            var val = price * count;
            total = total + val;
        });
        $('#shoppingCart .total').text(total + ' UAH');
    };

    var executeRemoveProduct = function (btn) {
        var idProduct = btn.attr('data-id-product');
        var count = btn.attr('data-count');
        convertButtonToLoader(btn, 'btn-danger');
        $.ajax({
            url: '/ajax/json/product/remove',
            method: 'POST',
            data: {
                idCar: idProduct,
                days: count
            },
            success: function (data) {
                if (data.totalCount == 0) {
                    window.location.href = '/cars';
                } else {
                    var prevCount = parseInt($('#product' + idProduct + ' .count').text());
                    var remCount = parseInt(count);
                    if (remCount >= prevCount) {
                        $('#product' + idProduct).remove();
                    } else {
                        convertLoaderToButton(btn, 'btn-danger', removeProductFromCart);
                        $('#product' + idProduct + ' .count').text(prevCount - remCount);
                        if (prevCount - remCount == 1) {
                            $('#product' + idProduct + ' a.remove-all').remove();
                        }
                    }
                    refreshTotalCost();
                }
            },
            error: function (data) {
                convertLoaderToButton(btn, 'btn-danger', removeProductFromCart);
                alert('Error');
            }
        });
    };

    var loadMoreMyOrders = function () {
        var btn = $('#loadMoreMyOrders');
        convertButtonToLoader(btn, 'btn-success');
        var pageNumber = parseInt($('#myOrders').attr('data-page-number'));
        var url = '/ajax/html/more/my-orders?page=' + (pageNumber + 1);
        $.ajax({
            url: url,
            success: function (html) {
                $('#myOrders tbody').append(html);
                pageNumber++;
                var pageCount = parseInt($('#myOrders').attr('data-page-count'));
                $('#myOrders').attr('data-page-number', pageNumber);
                if (pageNumber < pageCount) {
                    convertLoaderToButton(btn, 'btn-success', loadMoreMyOrders);
                } else {
                    btn.remove();
                }
            },
            error: function (xhr) {
                convertLoaderToButton(btn, 'btn-success', loadMoreMyOrders);
                if (xhr.status == 401) {
                    window.location.href = '/sign-in';
                } else {
                    alert('Error');
                }
            }
        });
    };
    init();
});