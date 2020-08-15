import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MsalGuard } from '@azure/msal-angular';

import {HomeComponent} from './home/home.component';

const routes: Routes = [
  { path: 'home',  component: HomeComponent, canActivate:[MsalGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: false})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
