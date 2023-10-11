import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {

       record Cliente (String ruc,  String razon_social,  String direccion,String correo ){}


        ArrayList<Cliente> clientesArray = new ArrayList<>();
        clientesArray.add(new Cliente("12345678901", "Ayudar", "Jr.barrio 2", "Juan@gmail.com"));
        clientesArray.add(new Cliente("12345678902", "Estudiar", "Jr.barrio 3", "Pedrro@gmail.com"));
        clientesArray.add(new Cliente("12345678903", "Comer", "Jr.barrio 4", "luis@Gmail.com"));
        clientesArray.add(new Cliente("12345678904", "Dormir", "Jr.barrio 5", "carla@gmail.com"));
        clientesArray.add(new Cliente("12345678905", "Jugar", "Jr.barrio 6", "carlos@gmail.com"));

        // recorrer la lista
        clientesArray.forEach(clientes -> System.out.println(
                        clientes.ruc() + " " +
                        clientes.razon_social() + " " +
                        clientes.direccion() + " " +
                        clientes.correo()
        ));

        // usar map para recorrer la lista
        // clientesArray.stream().map(cliente -> cliente.ruc()).forEach(System.out::println);

        Iterator<Cliente> iterator = clientesArray.iterator();
        System.out.println("Iterando con while");

        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            System.out.println(cliente.ruc() + " " +
                    cliente.razon_social() + " " +
                    cliente.direccion() + " " +
                    cliente.correo());
        }



        // Obtener el tamaño de la lista
        Function<List<Cliente>,Integer> tamañoList = List::size;
        System.out.println("El tamaño de la lista es: " + tamañoList.apply(clientesArray));


        // ------------------El uso de lambda en colecciones -----------------------
        // primero se crea un stream: un stream es una secuencia de elementos que se obtienen de una colección

        Stream<Cliente> stream = clientesArray.stream();
        // se filtra los elementos de la colección
        System.out.println(stream.filter(cliente -> cliente.ruc().equals("12345678901")).toList());

        // map: permite transformar los elementos de una colección
        List<String> listaRuc = clientesArray.stream().map(cliente -> cliente.ruc()).collect(Collectors.toList());
        System.out.println(listaRuc);

        // collect: permite obtener los elementos de una colección
        List<Cliente> listaClientes = clientesArray.stream().collect(Collectors.toList());
        System.out.println(listaClientes);













    }
}