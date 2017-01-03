import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ShortenComponent } from "./shorten/shorten.component";

const appRoutes:Routes = <Routes>[
  {path: '', /*canActivate: [], */component: ShortenComponent},
  {path: '**', redirectTo: ''} // exceptional urls redirected to default url
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
