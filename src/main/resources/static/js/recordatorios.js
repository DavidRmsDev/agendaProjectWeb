function rellenar(titulo, id, fecha, hora, descripcion) {
                document.formulario.tituloid.value = titulo;
                document.formulario.id.value = id;
                document.formulario.fechaid.value = fecha;
                document.formulario.horaid.value = hora;
                document.formulario.descripcionid.value = descripcion;
            }
            function alerta(opcion)
            {
                var valor = confirm("¿Desea borrar el recordatorio?");
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
                    alert('Debe seleccionar un recordatorio de la tabla');
            }

            function boton(valor) {
                document.formulario.botoncillo.value = valor;
            }
            function recordatorioNoInsertado() {
                alert("El recordatorio no se ha podido guardar.");
            }
            function recordatorioInsertado() {
                alert("Recordatorio guardado correctamente");
            }
            function recordatorioModificado() {
                alert("Recordatorio modificado correctamente");
            }
            function recordatorioEliminado() {
                alert("Recordatorio eliminado");
            }


            function estado() {
                switch (document.getElementById('estados').value) {
                    case '1':
                        recordatorioInsertado();
                        break;
                    case '2':
                        recordatorioNoInsertado();
                        break;
                    case '3':
                        recordatorioModificado();
                        break;
                    case '4':
                        recordatorioEliminado();
                        break;
                    default:
                        break;
                }
            }
            