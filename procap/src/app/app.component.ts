import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { IdeComponent } from "./ide/ide.component";
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [HttpClientModule, IdeComponent,RouterModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'procap';
}
