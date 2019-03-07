<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
<head>
    <title>Security</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <!-- Brand/logo -->
    <a class="navbar-brand" href="/generation.html">ГЕНЕРАТОР ТРАНЗАКЦИЙ</a>

    <!-- Links -->
    <ul class="navbar-nav">

        <li class="nav-item">

        </li>

    </ul>

    <span class="navbar-nav  ml-auto">
        <p>Sign in...</p>
    </span>
</nav>


<div class="container" id="container_form">
    <div class="shadow-lg p-3 mb-5 bg-white rounded">
        <form action="/login" method="post">
            <div class="row">
                <label class="col-3">Логин</label>
                <input class="col-3" type="text" name="username"/>
            </div>
            <div class="row">
                <label class="col-3">Пароль</label>
                <input class="col-3" type="password" name="password"/>
            </div>
            <div class="row">
                <div class="col-3"></div>
                <input class="col-3" type="submit" value="Log In..."/>
            </div>
            <div class="row">
                <p class="col-3" id="message"></p>
            </div>
        </form>
    </div>
    <p class="my_sign">developed by Vladimir Prilepskiy 2018</p>
</div>

<script>
    function setVisibleDivFromUrl() {
        var htmlMessage = document.getElementById("message");
        var parameter = document.location.search;
        if (parameter === '?error') {
            htmlMessage.innerHTML = 'Invalid login password.';
        } else if (parameter === '?logout') {
            htmlMessage.innerHTML = 'You have successfully logged out.';
            $("#container_form").empty();
        }
    };

    setVisibleDivFromUrl();
</script>
</body>
</html>