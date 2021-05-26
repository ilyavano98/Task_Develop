<#import "/spring.ftl" as spring/>
<#import "/headers/head.ftl" as integra/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Регистрация</title>
</head>

<body>
<div>
  <form method="post" modelAttribute="userForm">
    <h2>Регистрация</h2>
    <div>
      <input type="text" name = "username" path="username" placeholder="Username"
                  autofocus="true"/>

    </div>
    <div>
      <input type="password" name = "password" path="password" placeholder="Password"/>
    </div>
    <div>
      <input type="password" name="passwordConfirm" path="passwordConfirm"
                  placeholder="Confirm your password"/>

    </div>
    <button type="submit">Зарегистрироваться</button>
  </form>
  <a href="/">Главная</a>
</div>
</body>
</html>