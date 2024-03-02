<#assign map={"CASSA CONTANTI":"CASSACONTANTI"}/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello World</title>
</head>
<body>
    <h1>Hello ${name?j_string}!</h1>
    <p>You are ${age} years old.</p>
<#if map[payAccount]??>
    ${map[payAccount]}
<#else>
    ${payAccount}
</#if>
</body>
</html>