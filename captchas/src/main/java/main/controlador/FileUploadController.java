package main.controlador;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permitir solicitudes de Angular
@RequestMapping("/api")
public class FileUploadController {

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se recibió ningún archivo");
        }

        try {
            System.out.println("Archivo recibido: " + file.getOriginalFilename());

            // Aquí podrías realizar el procesamiento del archivo con JFlex y CUP.
            // Si todo va bien:
            return ResponseEntity.ok("Archivo subido y procesado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo: " + e.getMessage());
        }
    }

}
