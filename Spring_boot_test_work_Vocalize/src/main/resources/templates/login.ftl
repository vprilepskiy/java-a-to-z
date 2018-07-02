<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
<head>
    <title>Spring Security</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div>
    <p id="message"></p>
</div>
<form action="/logout" method="post">
    <div><input type="submit" value="Log out..."/></div>
</form>
<form action="/login" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Log In..."/></div>
    <div><a href="/all/registration.html">Registration</a></div>
</form>
<form>
    <div><label> User Name : <input id="user_name" type="text" name="username"/> </label></div>
    <div><label> Password: <input id="user_password_1" type="password" name="password"/> </label></div>
    <div><label> Password: <input id="user_password_2" type="password" name="password"/> </label></div>
    <div><input type="button" value="Registration..."
                onclick="addNewUser((document.getElementById('user_name').value),
                                    (document.getElementById('user_password_1').value),
                                    (document.getElementById('user_password_2').value))"/>
    </div>
    <div>
        <p id="message"></p>
    </div>
</form>
<script>
    function setVisibleDivFromUrl() {
        var htmlMessage = document.getElementById("message");
        var parameter = document.location.search;
        if (parameter === '?error') {
            htmlMessage.innerHTML = 'Invalid login password.';
        } else if (parameter === '?logout') {
            htmlMessage.innerHTML = 'You have successfully logged out.';
        }
    };

    setVisibleDivFromUrl();

    function addNewUser(user_name, user_password_1, user_password_2) {
        if (user_password_1 === user_password_2) {
            $(
                    $.ajax('./all/registration', {
                        method: 'post',
                        data: ({login: user_name, password: user_password_1}),
                        complete: function (data) {
                            var response = data.responseText;
                            var htmlMessage = document.getElementById("message");

                            htmlMessage.innerHTML = response;
                        }
                    })
            );
        } else {
            alert("Passwords are not the same!");
        }
    };
</script>
</body>
</html>