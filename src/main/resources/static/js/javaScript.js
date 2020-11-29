function rellenar(name, id, ape, tel, dir, ema) {
    document.formulario.nombre.value = name;
    document.formulario.id.value = id;
    document.formulario.apellidos.value = ape;
    document.formulario.telefono.value = tel;
    document.formulario.direccion.value = dir;
    document.formulario.email.value = ema;
}

function validacion(opcion) {
    if (document.formulario.usuario.value == "") {
        alert("Debe introducir un nombre de usuario");
    } else {
        if (document.formulario.pass.value == "") {
            alert("Debe introducir una contraseña");
        } else {
            boton(opcion);
            document.formulario.submit();
        }
    }
}

function boton(valor) {
    document.formulario.botoncillo.value = valor;
}
function usuarioExiste() {
    alert("El nombre de usuario ya existe, pruebe con otro");
}
function usuarioNoExiste() {
    alert("El nombre de usuario no existe, pruebe con otro o regístrese primero");
}
function usuarioRegistrado() {
    alert("El usuario se ha registrado con éxito");
}
function contraniaIncorrecta() {
    alert("La contraseña introducida no es válida");
}


function caso() {
    switch (document.getElementById('casos').value) {
        case '1':
            usuarioNoExiste();
            break;
        case '2':
            contraniaIncorrecta();
            break;
        case '3':
            usuarioExiste();
            break;
        case '4':
            usuarioRegistrado();
            break;
        default:
            break;
    }
}


function habilitarRegistro() {

    var checkBox = document.formulario.checkbox;

    if (checkBox.checked === true) {
        document.formulario.regButton.disabled = false;
    } else {
        document.formulario.regButton.disabled = true;

    }
}


            