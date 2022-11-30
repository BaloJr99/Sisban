package misExcepciones;

public class MisExcepciones extends Exception{
    private int codigoError;

    public MisExcepciones(int codigo) {
        this.codigoError = codigo;
    }

    @Override
    public String getMessage() {
        String mensaje = "";
        
        switch(codigoError){
            case 1:
                mensaje = "ERROR (1): Campo Usuario Vacio";
                break;
            case 2:
                mensaje = "ERROR (2): Campo Contraseña Vacio";
                break;
            case 3:
                mensaje = "ERROR (3): Usuario/Contraseña incorrecto";
                break;
            case 4:
                mensaje = "ERROR (4): Campo Nombre Vacio";
                break;
            case 5:
                mensaje = "ERROR (5): Campo Apellido Paterno Vacio";
                break;
            case 6:
                mensaje = "ERROR (6): Campo Apellido Materno Vacio";
                break;
            case 7:
                mensaje = "ERROR (7): Debe ingresar la fecha de nacimiento";
                break;
            case 8:
                mensaje = "ERROR (8): Debe seleccionar almenos un Regimen";
                break;
            case 9:
                mensaje = "ERROR (9): Debe ingresar el RFC";
                break;
            case 10:
                mensaje = "ERROR (10): Debe ingresar el CURP";
                break;
            case 11:
                mensaje = "ERROR (11): Debe seleccionar almenos un genero";
                break;
            case 12:
                mensaje = "ERROR (12): Debe ingresar el telefono";
                break;
            case 13:
                mensaje = "ERROR (13): Debe ingresar el correo";
                break;
            case 14:
                mensaje = "ERROR (14): Debe seleccionar almenos un tipo de telefono";
                break;
            case 15:
                mensaje = "ERROR (15): Debe ingresar el INE";
                break;
            case 16:
                mensaje = "ERROR (16): Debe ingresar la calle";
                break;
            case 17:
                mensaje = "ERROR (17): Debe ingresar el colonia";
                break;
            case 18:
                mensaje = "ERROR (18): Debe ingresar el codigo postal";
                break;
            case 19:
                mensaje = "ERROR (19): Debe ingresar el numero exterior";
                break;
            case 20:
                mensaje = "ERROR (20): El RFC y CURP no coinciden";
                break;
            case 21:
                mensaje = "ERROR (21): Debe buscar al cliente";
                break;
            case 22:
                mensaje = "ERROR (22): No existe ese usuario";
                break;
            case 23:
                mensaje = "ERROR (23): Favor de ingresar un numero de cliente valido";
                break;
            case 24:
                mensaje = "ERROR (24): Debe ingresar el parentesco";
                break;
            case 25:
                mensaje = "ERROR (25): Debe ingresar la fecha de ingreso";
                break;
            case 26:
                mensaje = "ERROR (26): Debe seleccionar el puesto";
                break;
            case 27:
                mensaje = "ERROR (27): Debe ingresar el numero de seguridad social";
                break;
            case 28:
                mensaje = "ERROR (28): Favor de ingresar un numero de empleado valido";
                break;
            case 29:
                mensaje = "ERROR (29): Favor de ingresar nombre de usuario";
                break;
            case 30:
                mensaje = "ERROR (30): Favor de ingresar contraseña";
                break;
            case 31:
                mensaje = "ERROR (31): Favor de ingresar confirmacion de contraseña";
                break;
            case 32:
                mensaje = "ERROR (32): No coinciden las contraseñas";
                break;
            case 33:
                mensaje = "ERROR (33): Favor de capturar la cuenta";
                break;
            case 34:
                mensaje = "ERROR (34): Favor de elegir el tipo de cuenta";
                break;
            case 35:
                mensaje = "ERROR (35): Favor de generar o buscar la cuenta/tarjeta en el apartado de cuentas/tarjetas";
                break;
             case 36:
                mensaje = "ERROR (36): Ingrese el numero de cuenta";
                break;
            case 37:
                mensaje = "ERROR (37): Ingrese el numero de Tarjeta";
                break;
            case 38:
                mensaje = "ERROR (38): Ingrese monto";
                break;
            case 39:
                mensaje = "ERROR (39): Favor de selecionar un tipo de movimiento ";
                break;
            case 40:
                mensaje = "ERROR (40): Seleccione un servicio a pagar ";
                break;
        }
        return mensaje;
    }
    
    
}
