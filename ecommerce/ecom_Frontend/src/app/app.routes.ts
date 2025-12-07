import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    redirectTo: '/customer',
    pathMatch: 'full'
  },
  {
    path: 'login',
    loadComponent: () => import('./login/login').then(m => m.Login)
  },
  {
    path: 'signup',
    loadComponent: () => import('./signup/signup').then(m => m.Signup)
  },
  {
    path: 'customer',
    loadComponent: () => import('./customer/customer').then(m => m.Customer)
  },
  {
    path: 'admin',
    loadComponent: () => import('./admin/admin').then(m => m.Admin)
  }
];
