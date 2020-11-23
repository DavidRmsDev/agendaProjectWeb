<?php
class clasebbdd
{
	private $conexionbbdd;

	public function __construct()
	{
		$servidor="localhost";
		$usuario="root";
		$clave="";
		$bbdd="agenda";

		$this->conexionbbdd=@mysql_connect($servidor,$usuario,$clave);
		mysql_select_db($bbdd,$this->conexionbbdd);
	}

	public function __destruct()
	{}

	public function seleccionar_datos($sql)
	{
		$datosseleccionados=mysql_query($sql,$this->conexionbbdd);
		$numerocampos=mysql_num_fields($datosseleccionados);

		$j=0;
		$x=1;
		while($fila=mysql_fetch_array($datosseleccionados))
		{
			for($j=0;$j<$numerocampos;$j++)
			{
				$nombrecampo=mysql_field_name($datosseleccionados,$j);
				$objecto[$x][$nombrecampo]=$fila[$nombrecampo];
			}
			$x++;
		}
		return @$objecto;
	}

	public function cerrar_datos_seleccionados($datosseleccionados)
	{
		mysql_free_result($datosseleccionados);
	}


	public function ejecutar_sentencias($sql,$operacion)
	{
		$cadena="";

		$resultado=mysql_query($sql,$this->conexionbbdd);
		if($resultado==1)
		{
			$resultado=1;
		}
		else
		{
			$numeroerror=mysql_errno($this->conexionbbdd);
			$mensajeerror=mysql_error($this->conexionbbdd);

			switch($operacion)
			{
				case "insertar":
				{
					$cadena="Hay errores en los campos.<br><br>Error
					número: ".$numeroerror." - ".$mensajeerror;
					break;
				}

				case "actualizar":
				{
					$cadena="No se ha podido Actualizar el registro. Hay errores
					en los campos.<br><br>Error número: ".$numeroerror." -
					".$mensajeerror;
					break;
				}

				case "eliminar":
				{
					$cadena="No se ha podido Eliminar el registro que ha
					seleccionado.<br><br>Error número: ".$numeroerror." -
					".$mensajeerror;
					break;
				}
				
				
			}
			$resultado=$cadena;
		}
		return $resultado;
	}

	public function cerrarconexion()
	{
		mysql_close($this->conexionbbdd);
	}
}
?> 