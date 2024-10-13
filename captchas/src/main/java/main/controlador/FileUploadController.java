package main.controlador;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import main.analizadores.*;
import main.excepciones.Errores;
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
        LinkedList<Errores> listaErrores = new LinkedList<>();
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se recibio ningún archivo");
        }

        try {
            System.out.println("Archivo recibido: " + file.getOriginalFilename());
            InputStream input = file.getInputStream();
            Reader read = new InputStreamReader(input);
            scanner scanner = new scanner(read);
            parser parser = new parser(scanner);
            parser.parse();

            listaErrores.addAll(scanner.getErrores());
            listaErrores.addAll(parser.getErrores());

            if (!listaErrores.isEmpty()) {
                System.out.println("Errores encontrados durante el analisis");
                for (Errores error : listaErrores) {
                    System.out.println(error.toString());
                }
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaErrores);
            }

            return ResponseEntity.ok("Archivo subido y procesado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo: " + e.getMessage());
        }
    }

}
