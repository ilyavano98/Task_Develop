<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Log in with your account</title>
  <link href="/css/style_admin.css?4" rel="stylesheet">
</head>

<body>
<div>
  <table>
    <thead class = "textcolor">
    <th>ID</th>
    <th>UserName</th>
    <th>Password</th>
    <th>Roles</th>
    </thead>
      <#list allUsers as user>
      <tr class = "table">
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
          <#list user.roles as role>
          <td>${role.name}</td>
          </#list>
        <td>
          <form method="post">
            <input type="hidden" name="userId" value="${user.id}"/>
            <input type="hidden" name="action" value="delete"/>
            <button type="submit">Delete</button>
            <a type="submit" href="/admin/${user.id}/edit">Edit</a>
          </form>
        </td>
      </#list>
      </tr>
  </table>
  <a href="/">Главная</a>
</div>
</body>
</html>
