import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { IdeComponent } from "./ide/ide.component";
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, IdeComponent, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'procap';
}
