<?php
require_once("mbbdd.php");

class claseusuarios
{
	private $codigousuario;

	public function __construct($codigousuario)
	{
		$this->codigousuario=$codigousuario;
	}

	public function __destruct()
	{}

	public function obtener_valornombrecampo($nombrecampo)
	{
		return $this->$nombrecampo;
	} 

	public function seleccionar_usuario($nick,$pass)
	{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="select * from usuario where nickname = '" .$nick."' and password ='".$pass."'";
 $resultado=$objDatos->seleccionar_datos($sql);
 return $resultado;
 $objDatos->cerrarconexion();
	}

public function seleccionar_nick($nick)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="select * from usuario where nickname = '" .$nick."'";
 $resultado=$objDatos->seleccionar_datos($sql);
 return $resultado;
 $objDatos->cerrarconexion();
}

public function insertar_usuario($nick,$pass)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="insert into usuario (nickname,password) values
 ('".$nick."','".$pass."')";
 $resultado=$objDatos->ejecutar_sentencias($sql,"insertar");
 return $resultado;
 $objDatos->cerrarconexion();
}

public function actualizar_usuario($user,$nick,$pass)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="update usuario set nickname='".$nick."',pass='".$pass."' where user=".$user;
 $resultado=$objDatos->ejecutar_sentencias($sql,"actualizar");
 return $resultado;
 $objDatos->cerrarconexion();
}

public function elimina_usuario($user)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="delete from usuario where user=".$user;
 $resultado=$objDatos->ejecutar_sentencias($sql,"eliminar");
 return $resultado;
 $objDatos->cerrarconexion();
}

}
?> 