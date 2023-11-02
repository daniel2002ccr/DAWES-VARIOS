<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Formulario Reserva</title>
    </head>
    <body>
        <h1>Formulario de reserva de salas de reunión</h1>
        <form action="http://localhost:8080/ReservaSalasMaven" method="post">
            <label for="Nombre">su nombre y su apellido</label>
            <input type="text" name="Nombre" id="Nombre"><br>
            <label for="fecha">Fecha y hora de inicio: </label>
            <input type="datetime" name="Fecha" id="fecha"><br>
            <label for="duracion">Duración de su reserva: </label>
            <input type="time" name="duracion" id="duracion"><br>
            <label for="tipo">Tipo de sala: </label>
            <select name="tipo" id="tipo">
                <option value="Sala de Juntas">Sala de Juntas</option>
                <option value="Sala de Conferencias">Sala de Conferencias</option>
                <option value="Oficina Privada">Oficina Privada</option>
            </select>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>