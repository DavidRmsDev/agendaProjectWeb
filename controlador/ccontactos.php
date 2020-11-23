<?php
if($_POST['operacion2']!="")
{
	require_once("../modelo/contacto.php");

	if($_POST['operacion2']=="seleccionar")
	{
		$objDatos=new clasecontactos("");
		$datosobtenidos=$objDatos->seleccionar_contactos();

		$delante="<p>";
		$detras="</p>";

		$i=1;
		$z=count($datosobtenidos);

		$cadena="";

		for($i=1;$i<=$z;$i++)
		{
			$cadena.="
			<tr>
			<td display="none">".$datosobtenidos[$i]['id']."</td>
			<td>".$datosobtenidos[$i]['nombre']."</td>
			<td>".$datosobtenidos[$i]['apellidos']."</td>
			<td>".$datosobtenidos[$i]['telefono']."</td>
			<td>".$datosobtenidos[$i]['direccion']."</td>
			<td>".$datosobtenidos[$i]['email']."</td>
			</tr>";
		}

		if($z>0)
		{
			$cadena="<table border='1' cellspacing='0' width='100%'>

			<thead><tr><td display="none">ID</td><td>Nombre</td><td>Apellidos</td><td>Teléfono</td><td>Dirección</td><td>Email</td>
			</tr></thead>

			<tfoot><tr><td display="none">ID</td><td>Nombre</td><td>Apellidos</td><td>Teléfono</td><td>Dirección</td><td>Email</td>
			</tr></tfoot>

			<tbody>".$cadena."</tbody></table>";

			$cadena.="<input type='hidden' name='hayregistros' id='hayregistrosid' value=1>";
		}
		else
		{
			$cadena="<b>No se han encontrado Registros.</b>";
			$cadena.="<input type='hidden' name='hayregistros' id='hayregistrosid'
			value=0>";
		}

		$cadena=utf8_encode($delante.$cadena.$detras);
		print($cadena);
	}


	if($_POST['operacion2']=="insertar")
	{
		$objDatos=new clasenotas(""); 

		$resultado=$objDatos->insertar_nota(utf8_decode($_POST['nombre2']),
			utf8_decode($_POST['apellidos2']),utf8_decode($_POST['dni2']),
			utf8_decode($_POST['direccion2']));

		$delante="<p>";
		$detras="</p>";

 if($resultado==1) //Se grabó correctamente el registro
 {
 	$cadena=$delante."Datos grabados correctamente.".$detras;
 	$cadena.="<input type='hidden' value='1' name='datoinserta'
 	id='datoinsertaid'>";
 }
 else
 {
 	$cadena=$delante."No se han podido insertar los datos en la Base de
 	datos.<br><br>";
 	$cadena.=utf8_encode($resultado).$detras;
 	$cadena.="<input type='hidden' value='0' name='datoinserta'
 	id='datoinsertaid'>";
 }
 print($cadena);
}


if($_POST['operacion2']=="actualizar2")
{
	$objDatos=new clasealumnos("");
	$codigo=$_POST['cod'];
	$datosobtenidos=$objDatos->seleccionar_alumno($codigo);
	$nombre=$datosobtenidos[1]['nombrealumno'];
	$apellidos=$datosobtenidos[1]['apellidosalumno'];
	$dni=$datosobtenidos[1]['dnialumno'];
	$direccion=$datosobtenidos[1]['direccionalumno'];
	$cadena=
	"<b>DATOS DEL ALUMNO - ACTUALIZAR</b><br><br>
	<table>
	<tr><td>Nombre: </td><td><input type='text' name='nombreactualizar' id='nombreactualizarid' value='$nombre'></td></tr>

	<tr><td>Apellidos: </td><td><input type='text' name='apellidosactualizar' id='apellidosactualizarid' value='$apellidos' size='30'
	maxlength='30'></td></tr>

	<tr><td>DNI: </td><td><input type='text' name='dniactualizar' id='dniactualizarid' value='$dni' size='14'
	maxlength='14'></td></tr> 

	<tr><td>Dirección: </td><td><input type='text' name='direccionactualizar' id='direccionactualizarid' value='$direccion' size='30'
	maxlength='60'></td></tr>
	</table>
	<br><input type='button' name='actualizalosboton' id='actualizalosbotonid' value='Actualizar'
	onclick='actualizalosdatos()'/>
	<input type='hidden' name='codigoalumno' id='codigoalumnoid' value='$codigo'/>
	<br><br><br>" ;
	print($cadena);
}


if($_POST['operacion2']=="actualizar")
{
	
	$objDatos=new clasealumnos(""); 

	$resultado=$objDatos->actualizar_alumno($_POST['cod3'],utf8_decode($_POST['nombre3']),
		utf8_decode($_POST['apellidos3']),utf8_decode($_POST['dni3']),
		utf8_decode($_POST['direccion3']));

	$delante="<p>";
	$detras="</p>";

 if($resultado==1) //Se grabó correctamente el registro
 {
 	$cadena=$delante."Datos actualizados correctamente.".$detras;
 	$cadena.="<input type='hidden' value='1' name='datoactualiza'
 	id='datoactualizaid'>";
 }
 else
 {
 	$cadena=$delante."No se han podido actualizar los datos en la Base de
 	datos.<br><br>";
 	$cadena.=utf8_encode($resultado).$detras;
 	$cadena.="<input type='hidden' value='0' name='datoactualiza'
 	id='datoactualizaid'>";
 }
 print($cadena);
}



if($_POST['operacion2']=="eliminar")
{
	$objDatos=new clasealumnos(""); 

	$resultado=$objDatos->elimina_alumno(utf8_decode($_POST['cod']));

	$delante="<p>";
	$detras="</p>";

 if($resultado==1) //Se eliminó correctamente el registro
 {
 	$cadena=$delante."Datos eliminados correctamente.".$detras;
 	$cadena.="<input type='hidden' value='1' name='datoelimina'
 	id='datoeliminaid'>";
 }
 else
 {
 	$cadena=$delante."No se han podido eliminar los datos en la Base de
 	datos.<br><br>";
 	$cadena.=utf8_encode($resultado).$detras;
 	$cadena.="<input type='hidden' value='0' name='datoelimina'
 	id='datoeliminaid'>";
 }
 print($cadena);
}




}
else print("Seguridad implementada.");
?> 
