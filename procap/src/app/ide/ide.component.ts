import { Component, ElementRef, ViewChild, AfterViewInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Errores } from '../errores';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ide',
  standalone: true,
  templateUrl: './ide.component.html',
  styleUrls: ['./ide.component.css'],
  imports: [FormsModule, CommonModule] 
})
export class IdeComponent implements AfterViewInit {
  @ViewChild('codeEditor', { static: true }) codeEditor!: ElementRef;
  @ViewChild('lineCounter', { static: true }) lineCounter!: ElementRef;

  codeContent: string = '';
  selectedFile: File | null = null;
  backendResponse: string = '';
  errores: Errores[];

  constructor(private cdr: ChangeDetectorRef, private http: HttpClient, private router: Router) {}

  ngOnInit(): void {
    this.updateLineCounter();
    if (typeof document !== 'undefined') {
      const fileInput = document.querySelector('input[type="file"]') as HTMLInputElement;
      if (fileInput) {
        fileInput.value = '';
      }
    }
  }

  onFileChange(event: any): void {
    const file = event.target.files[0];
    if (file) {
      this.selectedFile = file;
      const reader = new FileReader();
      reader.onload = (e: any) => {
        this.codeContent = e.target.result;
        this.cdr.detectChanges();
        this.updateLineCounter();
      };
      reader.readAsText(file);
    }
  }

  saveCode(): void {
    if(this.selectedFile){
      this.downloadFile(this.selectedFile.name, this.codeContent);
    } else {
      console.log('No hay archivo cargado,"use Guarda como" en su lugar')
    }
  }

  saveCodeAs(): void {
    const filename = prompt('Por favor, ingrese un nombre para el archivo:',"codigo.cc");
    if(filename){
      this.downloadFile(filename, this.codeContent);
    }
  }

  private downloadFile(fileName: string, content: string): void {
    const blob = new Blob([content], { type: 'text/plain' });
    const url = window.URL.createObjectURL(blob);
    
    const a = document.createElement('a');
    a.href = url;
    a.download = fileName;
    
    document.body.appendChild(a);
    a.click();
    
    document.body.removeChild(a);
    window.URL.revokeObjectURL(url);
  }

  ngAfterViewInit() {
    this.updateLineCounter();
    this.codeEditor.nativeElement.addEventListener('scroll', () => {
      this.lineCounter.nativeElement.scrollTop = this.codeEditor.nativeElement.scrollTop;
    });
    this.codeEditor.nativeElement.addEventListener('input', () => {
      this.updateLineCounter();
    });
  }

  updateLineCounter() {
    const lineCount = this.codeContent.split('\n').length;
    const lineNumbers = Array.from({ length: lineCount }, (_, i) => i + 1).join('<br>');
    this.lineCounter.nativeElement.innerHTML = lineNumbers;
  }

  compileCode() {
    if (this.selectedFile) {
      const formData = new FormData();
      formData.append('file', this.selectedFile);
      this.http.post<Errores[]>('http://localhost:8080/api/upload', formData)
        .subscribe(
          (response: any) => {
            // Si no hay errores, el backend devuelve una respuesta exitosa
            console.log('Respuesta del backend:', response);
            this.backendResponse = 'Archivo subido y procesado exitosamente';
          },
          (error: HttpErrorResponse) => {
            // Manejar los errores devueltos como JSON
            if (error.status === 400 && error.error instanceof Array) {
              this.errores = error.error; 
              this.backendResponse = 'Errores encontrados durante el análisis.';
            } else {
              console.error('Error al compilar el código:', error);
              this.backendResponse = 'Error al compilar el archivo.';
            }
          }
        );
    } else {
      this.backendResponse = 'No se ha cargado ningún archivo.';
      console.error('No se ha cargado ningún archivo.');
    }
  }
  
  listCaptchas() {
    console.log('Mostrar lista de captchas');
    this.router.navigate(['/lista-captchas']);
  }
}
