// Call the dataTables jQuery plugin

//esto es una funcion de JQuery
//una vez cargo usuarios.html se ejecutara
//esta funcion de JQuery que ejecutara
//codigo JavaScript
$(document).ready(function () {//funcion anonima que se pasa como argumento al JQuery y que se ejecutara
    cargarUsuarios();//llamada a la funcion
    $('#usuarios').DataTable();//selecciona elemento HTML con ID "usuarios"
                    //convierte la tabla HTML estandar a INTERACTIVA con las funcionalidades de DataTables
});

/*
Funcion asicrona que permite usar AWAIT
para el manejo de operaciones asincronas
como solicitudes de red
 */
async function cargarUsuarios() {
    //fetch para realizar una solicitud GET a la URL -> usuarios
    //await esperar hasta que la consulta se complete antes de continuar
    //tambien espera contenido en formato JSON
    const request = await fetch("api/usuarios", {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    /*
    recibe la respuesta de la solicitud, extra contenido del JSON
    se usa await nuevamente para esperar la conversion a JSON
     */
    const usuarios = await request.json();
    //cadena vacia que construirar HTML de la tabla usuarios
    let listadoHtml = '';
    //iterara cada objeto de la lista usuarios
    for (let usuario of usuarios) {
        //boton eliminar HTML
        let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

        let telefonotexto = usuario.telefono == null ? '-' : usuario.telefono;

        //para cada usuario se construye HTML
        let userHtml = '<tr><td>' + usuario.id + '</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>'
            + usuario.email + '</td><td>' + telefonotexto
            + '</td><td>' + botonEliminar + '</td></tr>';
        //filas generadas
        listadoHtml += userHtml;
    }
    console.log(usuarios);
    //seleccionar TBODY de la tabla con ID #usuarios
    //y reemplaza el contenido con el nuevo HTML generado
    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}

async function eliminarUsuario(id) {

    if(!confirm("¿Desea eliminar este usuario?")){
        return;
    }

    const request = await fetch('api/usuarios/' + id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    document.location.reload();
}