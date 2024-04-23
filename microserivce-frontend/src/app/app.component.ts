import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {AdminTemplateComponent} from "./admin-template/admin-template.component";
import {HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, AdminTemplateComponent,HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'microserivce-frontend';
}
