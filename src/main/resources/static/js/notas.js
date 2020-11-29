function resetear() {
    document.getElementById('campoFecha').style.display = 'none';
    document.formulario.fechaid.value = "";
}

function rellenar(titulo, id, fecha, nota) {
    document.getElementById('campoFecha').style.display = 'block';
    document.formulario.tituloid.value = titulo;
    document.formulario.id.value = id;
    document.formulario.fechaid.value = fecha;
    document.formulario.notasid.value = nota;
}
function alerta(opcion)
{
    var valor = confirm("¿Desea borrar la nota?");
    if (valor == true) {
        boton(opcion);
        document.formulario.submit();
    }
}
function validacion(opcion) {
    if (document.formulario.id.value > 0) {
        if (opcion == 'delete') {
            alerta(opcion);
        } else {
            boton(opcion);
            document.formulario.submit();
        }
    } else
        alert('Debe seleccionar una nota de la tabla');
}
function boton(valor) {
    document.formulario.botoncillo.value = valor;
}
function notaNoInsertada() {
    alert("La nota no se ha podido guardar.");
}
function notaInsertada() {
    alert("Nota guardada correctamente");
}
function notaModificada() {
    alert("Nota modificada correctamente");
}
function notaEliminada() {
    alert("Nota eliminada");
}


function estado() {
    switch (document.getElementById('estados').value) {
        case '1':
            notaInsertada();
            break;
        case '2':
            notaNoInsertada();
            break;
        case '3':
            notaModificada();
            break;
        case '4':
            notaEliminada();
            break;
        default:
            break;
    }
}
            