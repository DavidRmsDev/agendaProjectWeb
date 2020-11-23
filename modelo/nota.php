<?php
require_once("mbbdd.php");

class clasenotas
{
	private $codigonota;

	public function __construct($codigonota)
	{
		$this->codigonota=$codigonota;
	}

	public function __destruct()
	{}

	public function obtener_valornombrecampo($nombrecampo)
	{
		return $this->$nombrecampo;
	} 

	public function seleccionar_notas($user)
	{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="select * from nota where user =" .$user;
 $resultado=$objDatos->seleccionar_datos($sql);
 return $resultado;
 $objDatos->cerrarconexion();
}

public function seleccionar_nota($id)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="select * from nota where id=".$id;
 $resultado=$objDatos->seleccionar_datos($sql);
 return $resultado;
 $objDatos->cerrarconexion();
}

public function insertar_nota($user,$titulo,$notas,$fecha)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="insert into nota (user,titulo,notas,fecha) values
 (".$user.",'".$titulo."','".$notas."','".$fecha."')";
 $resultado=$objDatos->ejecutar_sentencias($sql,"insertar");
 return $resultado;
 $objDatos->cerrarconexion();
}

public function actualizar_nota($id,$titulo,$notas,$fecha)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="update nota set titulo='".$titulo."',notas='".$notas."',fecha='".$fecha."' where id=".$id;
 $resultado=$objDatos->ejecutar_sentencias($sql,"actualizar");
 return $resultado;
 $objDatos->cerrarconexion();
}

public function elimina_nota($id)
{
 $objDatos=new clasebbdd(); //crea un objeto para conectarse a la base de datos.
 $sql="delete from nota where id=".$id;
 $resultado=$objDatos->ejecutar_sentencias($sql,"eliminar");
 return $resultado;
 $objDatos->cerrarconexion();
}

}
?> 
