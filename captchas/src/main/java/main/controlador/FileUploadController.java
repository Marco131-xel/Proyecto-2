package main.controlador;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import main.excepciones.Errores;
import main.make.MakeCC;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FileUploadController {

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se recibió ningún archivo");
        }

        try {
            System.out.println("Archivo recibido: " + file.getOriginalFilename());
            MakeCC make = new MakeCC();
            String ruta = System.getProperty("user.dir");
            String outputFile = ruta + "/target/data/" + file.getOriginalFilename().replace(".cc", ".html");
            LinkedList<Errores> errores = make.translatehtml(file.getInputStream(), outputFile);

            if (!errores.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
            }

            return ResponseEntity.ok("Archivo subido y procesado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();  // Esto imprimirá el stack trace en la consola
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo: " + e.getMessage());
        }
    }

    @GetMapping("/list-captchas")
    public ResponseEntity<List<String>> listCaptchas() {
        try {
            File folder = new File(System.getProperty("user.dir") + "/target/data");
            List<String> fileNames = Arrays.stream(folder.listFiles())
                    .filter(file -> file.isFile() && file.getName().endsWith(".html"))
                    .map(File::getName)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(fileNames);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonList("Error al listar archivos: " + e.getMessage()));
        }
    }

    @DeleteMapping("/delete-captcha/{filename}")
    public ResponseEntity<?> deleteCaptcha(@PathVariable String filename) {
        try {
            File file = new File(System.getProperty("user.dir") + "/target/data/" + filename);
            if (file.exists() && file.delete()) {
                return ResponseEntity.ok("Archivo eliminado exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Archivo no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el archivo: " + e.getMessage());
        }
    }

    @GetMapping("/{filename}")
    public ResponseEntity<String> getCaptchaHtml(@PathVariable String filename) {
        try {
            File file = new File(System.getProperty("user.dir") + "/target/data/" + filename);
            if (!file.exists()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Archivo no encontrado");
            }

            String content = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
            return ResponseEntity.ok(content);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al leer el archivo: " + e.getMessage());
        }
    }

}
