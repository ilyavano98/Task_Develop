<#import "/spring.ftl" as spring/>
<#import "/headers/head.ftl" as integra/>
<!DOCTYPE HTML>
<html">
<head>
    <title>Полноное содержимое статьи</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/css/style.css?10" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <@integra.head />
</head>
<body>
    <div class = container mt-5 mb-20 >
        <#list stat as el>
            <h2>${el.name}</h2>
            <div>
                <p><b>Status</b>: ${el.status}</p>
                <p><b>Start Date</b>: ${el.date}</p>
                <p><b>Author</b>: ${el.author}</p>
                <b>Description</b>
                <p>${el.getFull_text()}</p>
            </div>
            <b>Comments: </b>
            <#if no_comment??>
                <h3>${no_comment}</h3>
            <#else>
            <#list comments as com>
            <div border = "1">
                <p> Update by ${com.author} ${com.getDate()}:
                    <p>Status changed to ${el.status}</p>
                    <p>${com.text}</p></p>
                    </div>
            </#list>
            </#if>
        </#list>
        <div class = "block1">
            <h3>New comment</h3>
            <form method="post">
                <select type = "text" name = "status">
                    <option>Resolved</option>
                    <option>Closed</option>
                </select>
                <input type = "text" name = "author" placeholder="Введите имя автора"/><br>
                <textarea name = "text" placeholder="Введите текст статьи"></textarea><br>
                <button type="submit" class = "btn btn-success">Add</button>
            </form>
        </div>
    </div>
</body>
</html>