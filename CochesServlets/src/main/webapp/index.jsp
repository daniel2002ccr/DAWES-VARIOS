<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario</title>
</head>
<body>
    <h1>Introduzca su nombre por favor</h1>
    <form action="http://localhost:8080/CochesServlets/coches" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" id="nombre">
         <input type="submit" value="Consultar">
    </form>
</body>
</html>