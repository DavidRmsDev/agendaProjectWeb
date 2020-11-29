function verify()
{
var tecla=window.event.keyCode;
if (tecla==116) {
 confirm('Si recarga la página volverá a la pantallade login.\n¿Deseas recargar la página?"', function (result) {
     if (result) {
           location.reload();
      } else {
           event.keyCode=0;
event.returnValue=false;
      }
}); 

}
}
