import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './inicio/inicio.component';
import { ListaTransferenciasComponent } from './lista-transferencias/lista-transferencias.component';

const routes: Routes = [
  { path: '', component: InicioComponent },
  { path: 'lista-transferencias', component: ListaTransferenciasComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }