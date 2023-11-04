<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario Reserva</title>
</head>
<body>
    <h1>Formulario de reserva de salas de reunión</h1>
    <form action="http://localhost:8080/ReservaSalasMaven/ReservaServlet" method="post">
        <label for="Nombre">Nombre y Apellido:</label>
        <input type="text" name="Nombre" id="Nombre"><br>
        
        <label for="Fecha">Fecha y hora de inicio:</label>
        <input type="datetime-local" name="Fecha" id="Fecha"><br>
        
        <label for="duracion">Duración de su reserva (minutos o horas):</label>
        <input type="number" name="duracion" id="duracion"><br>
        
        <label for="tipo">Tipo de sala:</label>
        <select name="tipo" id="tipo">
            <option value="" disabled selected>Seleccione un tipo</option>
            <option value="Sala de Juntas">Sala de Juntas</option>
            <option value="Sala de Conferencias">Sala de Conferencias</option>
            <option value="Oficina Privada">Oficina Privada</option>
        </select>
        
        <input type="submit" value="Enviar">
    </form>
</body>
</html>