<#import "/spring.ftl" as spring/>
<#import "/headers/head.ftl" as integra/>
<!DOCTYPE HTML>
<html>
<head>
    <title>Issue tracker</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/css/style.css?10" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <@integra.head />
</head>
<body>
<div class = "blocktext">
  <table class = "table">
    <tr>
    <th>Name</th>
    <th>Status</th>
    <th>Date</th>
    </tr>
      <#list stat as el>
      <tr>
        <td border = "1"><a href="/View_and_comment_issue/${el.id}">${el.name}</td>
        <td border = "1">${el.status}</td>
        <td border = "1">${el.date}</td>
      </tr>
      </#list>
  </table>
  <a href="/">Главная</a>
</div>
</body>
</html>