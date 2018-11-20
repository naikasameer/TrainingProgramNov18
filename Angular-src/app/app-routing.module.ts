import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmpComponent } from './emp/emp.component';
import { CasestudiesComponent } from './casestudies/casestudies.component';
import { CustomersComponent } from './customers/customers.component';
import { AboutComponent } from './about/about.component';

const routes: Routes = [
  {path:'',component:EmpComponent},
  {path:'case-studies',component:CasestudiesComponent},
  {path:'customers',component:CustomersComponent},
  {path:'about',component:AboutComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
