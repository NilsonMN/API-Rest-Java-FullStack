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

async function cargarUsuarios() {
    const request = await fetch("usuarios", {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const usuarios = await request.json();

    let listadoHtml = '';

    for (let usuario of usuarios) {
        let userHtml = '<tr><td>' + usuario.id + '</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>'
            + usuario.email + '</td><td>' + usuario.telefono
            + '</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';
        listadoHtml += userHtml;
    }

    console.log(usuarios);

    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}