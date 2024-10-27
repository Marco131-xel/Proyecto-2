import { Routes } from '@angular/router';
import { IdeComponent } from './ide/ide.component';
import { ListaCaptchasComponent } from './lista-captchas/lista-captchas.component';

export const routes: Routes = [
    {path: '', component: IdeComponent},
    {path: 'lista-captchas', component: ListaCaptchasComponent}
];
