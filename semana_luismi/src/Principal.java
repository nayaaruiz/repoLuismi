import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {

        List<Persona> personas = List.of(
                new Persona("Lucía", 22),
                new Persona("Claudia", 19),
                new Persona("Alberto", 26)
        );

        personas.stream()
                .map(Persona::nombre)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        personas.stream()
                .map(Persona::edad)
                .forEach(System.out::println);

        List<Integer> numeros = List.of(1,2,3,4,5,6,7,8);

        Optional<Integer> result =
            numeros
                    .stream()
                    .reduce((x, y) -> x+y);
        result.ifPresentOrElse(System.out::println, () -> System.out.println("Lista vacía"));

        Integer result2 =
                numeros
                        .stream()
                        .reduce(10, (x, y) -> x+y);
        System.out.println(result2);
        //Con la identidad no hace falta el optional porque el mínimo es 10

        LinkedList<Integer> resultado2 =
                numeros
                        .stream()
                        .collect(Collectors.toCollection(LinkedList::new));

        String quijote = "En un lugar de La Mancha de cuyo nombre no quiero acordarme";

        Map<String, Long> frecuencias = Arrays.stream(quijote.split(" "))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        frecuencias.forEach((k,v) -> System.out.println("%s: %d veces".formatted(k,v)));

    }

}
