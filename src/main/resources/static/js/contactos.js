function rellenar(name, id, ape, tel, dir, ema) {
                document.formulario.nombre.value = name;
                document.formulario.id.value = id;
                document.formulario.apellidos.value = ape;
                document.formulario.telefono.value = tel;
                document.formulario.direccion.value = dir;
                document.formulario.email.value = ema;
            }
            function alerta(opcion)
            {
                var valor = confirm("¿Desea borrar el contacto?");
                if (valor == true) {
                    boton(opcion);
                    document.formulario.submit();
                }
            }
            function validacion(opcion) {
                if (document.formulario.id.value > 0) {
                    if (opcion == 'delete') {
                        alerta(opcion)
                    } else {
                        boton(opcion);
                        document.formulario.submit();
                    }
                } else
                    alert('Debe seleccionar un contacto de la tabla');
            }
            function boton(valor) {
                document.formulario.botoncillo.value = valor;
            }
            function comprobarNumeros() {
                document.formulario.telefono.value = document.formulario.telefono.value.replace(/[^0-9]/g, "");
            }

            function contactoNoInsertado() {
                alert("El contacto no se ha podido guardar. Teléfono duplicado");
            }
            function contactoInsertado() {
                alert("Contacto guardado correctamente");
            }
            function contactoModificado() {
                alert("Contacto modificado correctamente");
            }
            function contactoNoModificado() {
                alert("El contacto no se ha modificado correctamente. Teléfono duplicado");
            }
            function contactoEliminado() {
                alert("Contacto eliminado");
            }


            function estado() {
                switch (document.getElementById('estados').value) {
                    case '1':
                        contactoInsertado();
                        break;
                    case '2':
                        contactoNoInsertado();
                        break;
                    case '3':
                        contactoModificado();
                        break;
                    case '4':
                        contactoNoModificado();
                        break;
                    case '5':
                        contactoEliminado();
                        break;
                    default:
                        break;
                }
            }
            
            