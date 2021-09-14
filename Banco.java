import java.util.Scanner;

public class Banco {

    public static void main(String args[]){
        menu();
    }

    public static cuenta cuenta;

    public static int capturaInt(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String capturaString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static double capturaDouble(){
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    public static void menu(){
        int opc = 0;
        do{
            System.out.println("\nIngrese la opcion deseada.\n");
            System.out.println("(1) Cuenta bancaria existente.");
            System.out.println("(2) Crear una cuenta bancaria.");
            System.out.println("(3) Salir.");
            opc = capturaInt();

            switch (opc) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    crearUsuario();
                    break;
                case 3:
                    System.out.println("Hasta pronto.");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida.");
            }
        }while(opc != 3);
    }

    public static void crearUsuario(){
        cuenta = new cuenta();
        double deposito;
        cuenta.setSaldo(0);

        System.out.println("\nIngresa tu nombre completo: ");
        cuenta.setNombre(capturaString());

        System.out.println("Ingrese un PIN de 4 digitos con el que accederas a tu cuenta: ");
        cuenta.setPin(capturaInt());

        System.out.println("Ingrese la cantidad que guste depositar por primera vez: ");
        deposito = capturaDouble();
        cuenta.setSaldo((float) deposito);
    }

    public static void iniciarSesion(){

        int pin, opc = 0;
        double retirar = 0,depositar = 0;

        System.out.println("\nIngrese su PIN para iniciar sesion.");
        pin = capturaInt();

        if(cuenta != null) {
            if (pin == cuenta.getPin()) ;

            do {
                System.out.println("Inicio de sesion correcto. Seleccione la opcion deseada.");
                System.out.println("Bienvenido "+cuenta.getNombre());
                System.out.println("(1) Depositar dinero.");
                System.out.println("(2) Retirar dinero.");
                System.out.println("(3) Consultar tu saldo actual.");
                System.out.println("(4) Salir");
                opc = capturaInt();

                switch (opc) {
                    case 1:
                        System.out.println("Ingrese la cantidad a depositar: ");
                        depositar = capturaDouble();
                        cuenta.setSaldo((float) (cuenta.getSaldo() + depositar));
                        System.out.print("Transaccion exitosa.");
                        break;
                    case 2:
                        retiro(retirar);
                        System.out.print("Transaccion exitosa.");
                        break;
                    case 3:
                        System.out.println("Tu saldo actual es de: $ " + cuenta.getSaldo());
                        break;
                    case 4:
                        System.out.println("Hasta pronto.");
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida.");
                }
            } while (opc != 4);
        }else
            System.out.println("No hay ninguna cuenta creada con ese PIN.");
    }

    public static void retiro(double retirar){
        //Cuenta cuenta = new Cuenta();
        int i = 0;
        do{
            System.out.println("Ingrese la cantidad a retirar: ");
            retirar = capturaDouble();
            if(retirar <= cuenta.getSaldo()){
                cuenta.setSaldo((float)(cuenta.getSaldo()-retirar));
                i = 1;
            }else{
                System.out.print("No cuentas con el saldo suficiente, vuelva a intentarlo.");
            }
        }while(i!=1);
    }
}