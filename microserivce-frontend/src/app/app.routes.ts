import { Routes } from '@angular/router';
import {CustomersComponent} from "./customers/customers.component";
import {AccountsComponent} from "./accounts/accounts.component";
import {AdminTemplateComponent} from "./admin-template/admin-template.component";

export const routes: Routes = [
  {path : "customers" , component : CustomersComponent},
  {path : "accounts", component : AccountsComponent},
  {path : "admin-template" , component : AdminTemplateComponent},

];
