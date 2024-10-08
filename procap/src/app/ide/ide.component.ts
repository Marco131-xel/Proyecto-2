import { Component, ElementRef, ViewChild, AfterViewInit, ChangeDetectorRef } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ide',
  standalone: true,
  templateUrl: './ide.component.html',
  styleUrls: ['./ide.component.css'],
  imports: [FormsModule]
})
export class IdeComponent implements AfterViewInit {
  @ViewChild('codeEditor', { static: true }) codeEditor!: ElementRef;
  @ViewChild('lineCounter', { static: true }) lineCounter!: ElementRef;

  codeContent: string = '';

  constructor(private cdr: ChangeDetectorRef) {} 

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
    console.log('Guardar el código: \n', this.codeContent);
  }

  saveCodeAs(): void {
    console.log('Guardando como ...\n', this.codeContent);
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
    console.log('Compilar código:', this.codeContent);
  }

  createCaptcha() {
    console.log('Crear nuevo captcha con el código:', this.codeContent);
  }

  listCaptchas() {
    console.log('Mostrar lista de captchas');
  }

}
