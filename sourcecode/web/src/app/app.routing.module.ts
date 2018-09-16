import { Routes } from '@angular/router';


export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/distributed/index/introduce' },
  { 'path': 'distributed', 'loadChildren': './router/distributed/index.module#DistributedModule' },
];
