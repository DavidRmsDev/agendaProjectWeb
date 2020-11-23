<?php
require_once("mbbdd.php");

class clasecontactos
{
	private $codigocontacto;

	public function __construct($codigocontacto)
	{
		$this->codigocontacto=$codigocontacto;
	}

	public function __destruct()
	{}

	public function obtener_valornombrecampo($nombrecampo)
	{
		return $this->$nombrecampo;
	} 

	public function seleccionar_contactos($user)
	{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="select * from contactos where user =" .$user;
 $resultado=$objDatos->seleccionar_datos($sql);
 return $resultado;
 $objDatos->cerrarconexion();
}

public function seleccionar_contacto($id)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="select * from contactos where id=".$id;
 $resultado=$objDatos->seleccionar_datos($sql);
 return $resultado;
 $objDatos->cerrarconexion();
}

public function insertar_contacto($user,$nombre,$apellidos,$telefono,$direccion,$email)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="insert into contactos (user,nombre,apellidos,telefono,direccion,email) values
 (".$user.",'".$nombre."','".$apellidos."',".$telefono.",'".$direccion."','".$email."')";
 $resultado=$objDatos->ejecutar_sentencias($sql,"insertar");
 return $resultado;
 $objDatos->cerrarconexion();
}

public function actualizar_contacto($id,$nombre,$apellidos,$telefono,$direccion,$email)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="update contactos set nombre='".$nombre."',apellidos='".$apellidos."',direccion='".$direccion."',telefono=".$telefono.",email='".$email."' where id=".$id;
 $resultado=$objDatos->ejecutar_sentencias($sql,"actualizar");
 return $resultado;
 $objDatos->cerrarconexion();
}

public function elimina_contacto($id)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="delete from contactos where id=".$id;
 $resultado=$objDatos->ejecutar_sentencias($sql,"eliminar");
 return $resultado;
 $objDatos->cerrarconexion();
}

}
?> 
