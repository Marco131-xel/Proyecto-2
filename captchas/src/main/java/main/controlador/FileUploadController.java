package main.controlador;

import java.util.LinkedList;
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
            String outputFile= ruta + "/target/data/" + file.getOriginalFilename().replace(".cc", ".html");
            LinkedList<Errores> errores = make.translatehtml(file.getInputStream(), outputFile);
            
            if (!errores.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
            }
            
            return ResponseEntity.ok("Archivo subido y procesado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();  // Esto imprimirá el stack trace en la consola
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo: " + e.getMessage());
        }
    }
}
