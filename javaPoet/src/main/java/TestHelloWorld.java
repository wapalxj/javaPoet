import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.ThreadPoolExecutor;

public class TestHelloWorld {
    public static void main(String[] args) throws IOException {
        String path="D:\\workplace\\code\\GIT\\imooc\\javaPoet\\javaPoet\\src\\main\\java";
        //构造main()方法结构体
        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                //使用占位符，会自动完成到爆
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();
        //构造HelloWorld类结构体
        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .build();

        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                .build();
        javaFile.writeTo(System.out);
        javaFile.writeTo(new File("javaPoet\\src\\main\\java"));

        System.out.println(new File("").getAbsolutePath());
        System.out.println(new File("javaPoet\\src\\main\\java").toString());
        System.out.println(new File("javaPoet\\src\\main\\java").getCanonicalFile().toString());
    }
}
