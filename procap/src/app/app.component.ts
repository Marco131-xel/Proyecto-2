import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { IdeComponent } from "./ide/ide.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [HttpClientModule, IdeComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'procap';
}
