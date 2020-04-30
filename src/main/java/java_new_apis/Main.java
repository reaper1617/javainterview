package java_new_apis;

import java.io.*;
import java.lang.invoke.MethodHandles;
import java.lang.ref.Cleaner;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        // Objects.requireNonNullElseGet
        Integer obj = null;
        Integer got = Objects.requireNonNullElse(obj, 14);

        System.out.println(got);

        Integer obj2 = 12;
        Integer lazyGot = Objects.requireNonNullElseGet(obj2, Main::supply);
        System.out.println(lazyGot);


        // Static fabric methods

        // create UNMODIFIABLE collection!
        List<Integer> list1 = List.of(1, 2, 3);
        List<Float> list2 = List.of(1.1f);

        Set<Character> charSet = Set.of();

        Map<List<Integer>, Set<String>> map = Map.of();
        Map<String, String> map2 = Map.ofEntries();

        Map.Entry<String, String> entry = Map.entry("Str", "Val");

        // copy

        List<Integer> list3 = List.copyOf(list1);

        Set<Character> charSet2 = Set.copyOf(charSet);

        Map<String, String> map3 = Map.copyOf(map2);

        // Files read/write string

        Path path = Path.of("/Users/maksim.gerasimchuk/IdeaProjects/javainterview/src/main/java/java_new_apis/test_file.txt");
        String content = Files.readString(path);
        content = content.concat("Modified from Java code!\n");
        Files.writeString(path, content);


        // Optionals

//        Optional<String> opt = Optional.of("Val");
        Optional<String> opt = Optional.empty();

        opt.ifPresentOrElse(
                str -> System.out.println("Val: " + opt.get()),
                () -> System.out.println("No val!")
        );

        // isEmpty()

        if (opt.isEmpty()){
            System.out.println("Empty!");
        }

        // stream of one element or empty if not presented
        Stream<String> s = opt.stream();


        // Process IDs

        Process process = Runtime.getRuntime().exec("java -version");
        System.out.println(process.pid());

        // ProcessHandle.Info info = process.info();

        ProcessHandle handle = ProcessHandle.current();
        ProcessHandle.Info info = handle.info();

        System.out.println("PID = " + process.pid());
        System.out.println("User = " + info.user());
        System.out.println("Command = " + info.command());
        System.out.println("Args = " + info.arguments().map(
                Arrays::toString
        ));
        System.out.println("Command line = " + info.commandLine());
        System.out.println("Start time = " + info.startInstant());
        System.out.println("Total time = " + info.totalCpuDuration());


        // Strings

        String example = "    \n \r \t";
        // checks if string consists of whitespaces only
        System.out.println(example.isBlank()); // true

        String ex2 = " \t Hello, world! \n \t  ";
        String str1 = ex2.stripLeading();
        String str2 = ex2.stripTrailing();
        String str3 = ex2.strip();

        System.out.println(str1); // "Hello, world! \n \t  "
        System.out.println(str2); // " \t Hello, world!"
        System.out.println(str3); // "Hello, world!"

        String s10 = str3.repeat(10);
        System.out.println(s10);


        Stream<String> linesStream = "line1 \n line2 \n line3".lines();
        List<String> strings = linesStream.map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(strings);

        // ??????
//        System.out.println("to_indent".indent(4));

        List<String> stringsList = List.of("s1", "s2", "s3", "s4", "s5", "z6");
        List<String> taken = stringsList.stream()
                .takeWhile(el -> el.startsWith("s"))
                .collect(Collectors.toList());
        System.out.println(stringsList);
        System.out.println(taken);

        List<String> dropped = stringsList.stream()
                .dropWhile(el -> el.startsWith("s"))
                .collect(Collectors.toList());
        System.out.println(dropped);

        IntStream.iterate(1, i -> i < 100, i -> i *= 2).forEach(System.out::println);

        Stream<List<String>> stringStream = Stream.ofNullable(stringsList);

        // Predicate.not()
        Files.lines(path).filter(Predicate.not(String::isEmpty)).forEach(System.out::println);

        // java 12
//        Path src = Path.of("");
//        Path dst = Path.of("");
//        Files.mismatch(src, dst); // -1 if true or number of the first mismatch byte

        FileTime time = Files.getLastModifiedTime(path);
        Instant to = Instant.now();
        Instant from = time.toInstant();
        Duration d = Duration.between(from, to);
        System.out.println(String.format("Days %d , hours %d, min %d, sec %d, ms %d",
                d.toDaysPart(),
                d.toHoursPart(),
                d.toMinutesPart(),
                d.toSecondsPart(),
                d.toMillisPart())
        );

        // List to array
        List<Integer> listIntegers = List.of(1, 2, 3);
        Integer[] arr = listIntegers.toArray(Integer[]::new);


        // readAllBytes()
        Process proc = Runtime.getRuntime().exec("java --version");
        try (InputStream inputStream = proc.getInputStream()) {
            byte[] bytes = inputStream.readAllBytes();
            System.out.println(new String(bytes));
        }

        // transferTo()
        Process proc2 = Runtime.getRuntime().exec("java --version");
        try (InputStream inputStream = proc2.getInputStream();
             OutputStream outputStream = Files.newOutputStream(path)) {
            inputStream.transferTo(outputStream);
        }


        List<String> listStr = List.of("s1", "s2", "s3", "s4", "z5", "f6");

        // java 12
//        listStr.stream().collect(Collectors.teeing( ... , ... ))


        // version
        Runtime.Version version = Runtime.version();
        System.out.println("Feature = " + version.feature());
        System.out.println("Interim = " + version.interim());
        System.out.println("Update = " + version.update());
        System.out.println("Patch = " + version.patch());

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder(new URI("https://minijug.ru")).build();

        HttpResponse<Stream<String>> response = client.send(request, HttpResponse.BodyHandlers.ofLines());

        System.out.println("Response: " + response.statusCode() );
        System.out.println("Body = " );
        response.body().limit(4).forEach(System.out::println);


        // to make this work:
        // 1. compile Temp.java: javac Temp
        // 2. compile Main: javac Main
        // 3. run Main: java /Users/maksim.gerasimchuk/IdeaProjects/javainterview/src/main/java/java_new_apis/Main.java
        Path pathToTempClass = Path.of("/Users/maksim.gerasimchuk/IdeaProjects/javainterview/src/main/java/java_new_apis/Temp.class");
        byte[] bytes = Files.readAllBytes(pathToTempClass);
        Class<?> clazz = MethodHandles.lookup().defineClass(bytes);
        Object object = clazz.getDeclaredConstructor().newInstance();
        System.out.println(object);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] bytesArr = {1,2,3};
        Stream<byte[]> streamBytes = Stream.of(bytesArr);
        streamBytes.forEach(out::writeBytes);
        System.out.println(Arrays.toString(out.toByteArray()));

    }

    public static Integer supply() {
        System.out.println("Init started!");
        return 15;
    }

    // Cleaner 
    public class Resource implements Closeable {

        private final Cleaner cleaner = Cleaner.create();
        private final Cleaner.Cleanable cleanable;

        public Resource() {
            cleanable = cleaner.register(this, () -> {
                System.out.println("Cleaning ...");
            });
        }

        @Override
        public void close() throws IOException {
            cleanable.clean();
        }
    }

}
