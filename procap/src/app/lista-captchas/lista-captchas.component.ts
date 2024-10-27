import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-captchas',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './lista-captchas.component.html',
  styleUrl: './lista-captchas.component.css'
})
export class ListaCaptchasComponent implements OnInit {
  captchas: string[] = [];
  selectedDetails: { id: string; name: string } | null = null;

  constructor(private http: HttpClient, private router: Router){}

  ngOnInit(): void {
      this.loadCaptchas();
  }

  loadCaptchas() {
    this.http.get<string[]>('http://localhost:8080/api/list-captchas')
      .subscribe(
        (data) => this.captchas = data,
        (error) => console.error('Error al obtener la lista de captchas', error)
      );
  }

  abrirCaptcha(captcha: string){
    const url = `http://localhost:8080/${captcha}`;
    window.open(url, '_blank');
  }

  eliminarCaptcha(captcha: string){
    if (confirm(`¿Estás seguro de que deseas eliminar ${captcha}?`)) {
      this.http.delete(`http://localhost:8080/api/delete-captcha/${captcha}`)
        .subscribe(
          () => {
            this.captchas = this.captchas.filter(c => c !== captcha);
            alert(`${captcha} eliminado exitosamente`);
          },
          (error) => console.error('Error al eliminar el captcha', error)
        );
    }
  }

  verDetalles(captcha: string) {
    const url = `http://localhost:8080/api/${captcha}`;
    this.http.get(url, { responseType: 'text' })
      .subscribe(
        (htmlContent) => {
          const parser = new DOMParser();
          const doc = parser.parseFromString(htmlContent, 'text/html');
          const id = doc.documentElement.getAttribute('id') || 'N/A';
          const name = doc.documentElement.getAttribute('name') || 'N/A';
          this.selectedDetails = { id, name };
        },
        (error) => {
          console.error('Error al obtener el contenido HTML', error);
          alert('Error al obtener el contenido HTML: ' + error.message);
        }
      );
  }

  regresar(){
    this.router.navigate(['/']);
  }
}
