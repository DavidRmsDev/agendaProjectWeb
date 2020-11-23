<?php
require_once("mbbdd.php");

class claserecordatorios
{
	private $codigorecordatorio;

	public function __construct($codigorecordatorio)
	{
		$this->codigorecordatorio=$codigorecordatorio;
	}

	public function __destruct()
	{}

	public function obtener_valornombrecampo($nombrecampo)
	{
		return $this->$nombrecampo;
	} 

	public function seleccionar_recordatorios($user)
	{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="select * from recordatorio where user =" .$user;
 $resultado=$objDatos->seleccionar_datos($sql);
 return $resultado;
 $objDatos->cerrarconexion();
}

public function seleccionar_recordatorio($id)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="select * from recordatorio where id=".$id;
 $resultado=$objDatos->seleccionar_datos($sql);
 return $resultado;
 $objDatos->cerrarconexion();
}

public function insertar_recordatorio($user,$titulo,$fecha,$hora,$descripcion)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="insert into recordatorio (user,titulo,fecha,hora,descripcion) values
 (".$user.",'".$titulo."','".$fecha."','".$hora."','".$descripcion."')";
 $resultado=$objDatos->ejecutar_sentencias($sql,"insertar");
 return $resultado;
 $objDatos->cerrarconexion();
}

public function actualizar_recordatorio($id,$titulo,$fecha,$hora,$descripcion)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="update recordatorio set titulo='".$titulo."',hora='".$hora."',fecha='".$fecha."',descripcion='".$descripcion."' where id=".$id;
 $resultado=$objDatos->ejecutar_sentencias($sql,"actualizar");
 return $resultado;
 $objDatos->cerrarconexion();
}

public function elimina_recordatorio($id)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="delete from recordatorio where id=".$id;
 $resultado=$objDatos->ejecutar_sentencias($sql,"eliminar");
 return $resultado;
 $objDatos->cerrarconexion();
}

}
?> 
