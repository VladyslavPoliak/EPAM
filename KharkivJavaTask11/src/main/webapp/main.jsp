<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Main</title>

</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
            aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">Home</a>

    <div class="collapse navbar-collapse" id="navbarToggler">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="#">Bicycles</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Car</a>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/test" class="nav-link"> Sign Up </a></li>
            <li><a href="#" class="nav-link"> Login </a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="card col-sm-4">
            <img class="card-img-top"
                 src="https://bls.ua/image_cache/cars/97.Seat_Ibiza_2019/585x440-5c9e3129877ff.jpg"
                 alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title text-truncate" data-toggle="tooltip" data-placement="top"
                    title=" Seat Ibiza ">Seat Ibiza</h5>
                <p class="card-text">МЕСТ 4; ПЕРЕДНИЙ ПРИВОД; С КОНДИЦИОНЕРОМ; БЕНЗИН 1.2</p>
                <h5>Price: 40$</h5>
                <a href="#" class="btn btn-primary">Rent</a>
            </div>
        </div>
        <div class="card col-sm-4">
            <img class="card-img-top"
                 src="https://bls.ua/image_cache/cars/4.VolkswagenPolo2017/585x440-5a5e12254199c.jpg"
                 alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title text-truncate" data-toggle="tooltip" data-placement="top"
                    title="Volkswagen Polo">Volkswagen Polo</h5>
                <p class="card-text">МЕСТ 4; ПЕРЕДНИЙ ПРИВОД; С КОНДИЦИОНЕРОМ; БЕНЗИН 1.4</p>
                <h5>Price: 60$</h5>
                <a href="#" class="btn btn-primary">Rent</a>
            </div>
        </div>
        <div class="card col-sm-4">
            <img class="card-img-top"
                 src="https://bls.ua/image_cache/cars/46.HyundayAccentTumentsev_2017/585x440-5a72dcb69e541.jpg"
                 alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title text-truncate" data-toggle="tooltip" data-placement="top"
                    title="Hyundai Accent NEW">Hyundai Accent NEW</h5>
                <p class="card-text">МЕСТ 5; ПЕРЕДНИЙ ПРИВОД; С КОНДИЦИОНЕРОМ; БЕНЗИН 1.4</p>
                <h5>Price: 55$</h5>
                <a href="#" class="btn btn-primary">Rent</a>
            </div>
        </div>
        <div class="card col-sm-4">
            <img class="card-img-top"
                 src="https://bls.ua/image_cache/cars/58.SkodaOctaviaA7_2018/585x440-5a93fd43d8178.jpg"
                 alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title text-truncate" data-toggle="tooltip" data-placement="top"
                    title="Skoda Octavia A7 ">Skoda Octavia A7 </h5>
                <p class="card-text">МЕСТ 5; ПЕРЕДНИЙ ПРИВОД; С КОНДИЦИОНЕРОМ; БЕНЗИН 1.6л</p>
                <h5>Price: 65$</h5>
                <a href="#" class="btn btn-primary">Rent</a>
            </div>
        </div>
        <div class="card col-sm-4">
            <img class="card-img-top"
                 src="https://bls.ua/image_cache/cars/63.ChevroletSpark2018/585x440-5aaa606da30eb.jpg"
                 alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title text-truncate" data-toggle="tooltip" data-placement="top"
                    title=" Chevrolet Spark "> Chevrolet Spark </h5>
                <p class="card-text">МЕСТ 5; ПЕРЕДНИЙ ПРИВОД; С КОНДИЦИОНЕРОМ; БЕНЗИН 1.25</p>
                <h5>Price: 45$</h5>
                <a href="#" class="btn btn-primary">Rent</a>
            </div>
        </div>
        <div class="card col-sm-4">
            <img class="card-img-top"
                 src="https://bls.ua/image_cache/cars/53.Peugeot301_2018/585x440-5a901099d875e.jpg"
                 alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title text-truncate" data-toggle="tooltip" data-placement="top" title="Peugeot 301">
                    Peugeot 301</h5>
                <p class="card-text">МЕСТ 5; ПЕРЕДНИЙ ПРИВОД; С КОНДИЦИОНЕРОМ; БЕНЗИН 1.6</p>
                <h5>Price: 60$</h5>
                <a href="#" class="btn btn-primary">Rent</a>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script>
        $(function () {
            $('[data-toggle="tooltip"]').tooltip()
        })




</script>
</body>

</html>